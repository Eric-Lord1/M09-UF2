public class Fumador extends Thread {
    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;
    private int numFumades = 0;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }

    public void compraTabac() {
        try {
            tabac = estanc.venTabac();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void compraPaper() {
        try {
            paper = estanc.venPaper();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void compraLlumi() {
        try {
            llumi = estanc.venLlumi();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fuma() {
        synchronized (estanc) {
            if (tabac != null && paper != null && llumi != null) {
                System.out.println("Fumador " + id + " està fumant...");
                tabac = null;
                paper = null;
                llumi = null;
                numFumades++;
                estanc.notifyAll();  
            }

            try {
                Thread.sleep(500 + new java.util.Random().nextInt(500)); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        while (numFumades < 3) {
            compraTabac();
            compraPaper();
            compraLlumi();
            fuma();
        }
    }
}

