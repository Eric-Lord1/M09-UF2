import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

class BanyUnisex {
    private static final int BANY_BUIT = 0;
    private static final int BANY_AMB_HOMES = 1;
    private static final int BANY_AMB_DONES = 2;
    private static final int CAPACITAT_MAX = 3;
    
    private int estatActual = BANY_BUIT;
    private int ocupants = 0;
    private final Semaphore capacitat = new Semaphore(CAPACITAT_MAX, true);
    private final ReentrantLock lockEstat = new ReentrantLock(true);

    public void entraHome(String nom) {
        while (true) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_HOMES) {
                    if (capacitat.tryAcquire()) {
                        estatActual = BANY_AMB_HOMES;
                        ocupants++;
                        System.out.println(nom + " entra al bany. Ocupants: " + ocupants);
                        break;
                    }
                }
            } finally {
                lockEstat.unlock();
            }
        }
    }

    public void entraDona(String nom) {
        while (true) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_DONES) {
                    if (capacitat.tryAcquire()) {
                        estatActual = BANY_AMB_DONES;
                        ocupants++;
                        System.out.println(nom + " entra en el bany. Ocupants: " + ocupants);
                        break;
                    }
                }
            } finally {
                lockEstat.unlock();
            }
        }
    }

    public void surtHome(String nom) {
        lockEstat.lock();
        try {
            ocupants--;
            capacitat.release();
            System.out.println(nom + " surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
                System.out.println("El bany està buit");
            }
        } finally {
            lockEstat.unlock();
        }
    }

    public void surtDona(String nom) {
        lockEstat.lock();
        try {
            ocupants--;
            capacitat.release();
            System.out.println(nom + " surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
                System.out.println("El bany està buit");
            }
        } finally {
            lockEstat.unlock();
        }
    }

    public static void main(String[] args) {
        
        BanyUnisex bany = new BanyUnisex();
        Thread[] persones = new Thread[10];
        
        for (int i = 0; i < 5; i++) {
            persones[i] = new Home("Home-" + i, bany);
            persones[i + 5] = new Dona("Dona-" + i, bany);
        }
        
        for (Thread t : persones) {
            t.start();
        }
        
        for (Thread t : persones) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}