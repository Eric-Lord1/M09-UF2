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
            Thread.currentThread().interrupt();
        }
    }

    private void menjar() {
        System.out.println(getName() + " menja");
        try {
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
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
                if (esquerra.agafar()) {
                    System.out.println(getName() + " agafa la forquilla esquerra " + esquerra);
                    if (dreta.agafar()) {
                        System.out.println(getName() + " agafa la forquilla dreta " + dreta);
                        menjar();
                        dreta.deixar();
                        System.out.println(getName() + " solta la forquilla dreta " + dreta);
                        menjar = true;
                    }
                    esquerra.deixar();
                    if (!menjar) {
                        System.out.println(getName() + " solta la forquilla esquerra " + esquerra + " i espera");
                        gana++;
                        System.out.println(getName() + " gana=" + gana);
                        if (gana >= MAX_GANA) {
                            System.out.println(getName() + " ha mort de gana!");
                            return;
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
