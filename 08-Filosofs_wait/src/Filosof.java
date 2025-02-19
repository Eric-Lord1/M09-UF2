import java.util.Random;

class Filosof extends Thread {
    
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private final Random random = new Random();
    private int gana = 0;
    private static final int MAX_GANA = 5;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        super(nom);
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pensar() {
        try {
            System.out.println(getName() + " pensant");
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void menjar() {
        System.out.println(getName() + " menja");
        try {
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " ha acabat de menjar");
        gana = 0;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            boolean menjar = false;
            while (!menjar) {
                synchronized (esquerra) {

                    if (esquerra.getPropietari() == esquerra.LLIURE) {
                        esquerra.setPropietari(Integer.parseInt(getName().substring(3)));
                        System.out.println(getName() + " agafa la forquilla esquerra ");
                        
                        synchronized (dreta) {
                            if (dreta.getPropietari() == dreta.LLIURE) {
                                dreta.setPropietari(Integer.parseInt(getName().substring(3)));
                                System.out.println(getName() + " agafa la forquilla dreta ");
                                menjar();
                                dreta.setPropietari(dreta.LLIURE);
                                System.out.println(getName() + " solta la forquilla dreta ");
                                menjar = true;
                            }
                        }
                        
                        esquerra.setPropietari(esquerra.LLIURE);
                        if (!menjar) {
                            System.out.println(getName() + " solta la forquilla esquerra i espera");
                            gana++;
                            System.out.println(getName() + " gana=" + gana);
                            if (gana >= MAX_GANA) {
                                System.out.println(getName() + " ha mort de gana!");
                                return;
                            }
                        }
                    }
                }
                
                try {
                    Thread.sleep(500 + random.nextInt(500));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
