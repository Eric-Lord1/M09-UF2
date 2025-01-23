import java.util.Random;

public class Soci extends Thread {

    Random random = new Random();
    public static Compte compte;

    float aportacio;
    int esperaMax;

    private static int maxAnys = 10;

    public Soci(String name) {
        super(name);
        aportacio = 10f;
        esperaMax = 100;
        compte = Compte.getInstance();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < maxAnys; i++) {
                for (int j = 0; j < 12; j++) {
                    sleep(random.nextInt(100));
                    if (i % 2 == 0) {
                        compte.setSaldo(compte.getSaldo() + 10);
                    } else {
                        compte.setSaldo(compte.getSaldo() - 10);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
