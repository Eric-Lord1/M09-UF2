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

    }
}
