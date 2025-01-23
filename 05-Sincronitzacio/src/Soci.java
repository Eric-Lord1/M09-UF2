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
        float currentSaldo = 0f;
        try {
            for (int i = 0; i < maxAnys; i++) {
                for (int j = 0; j < 12; j++) {
                    sleep(random.nextInt(esperaMax));
                    synchronized (compte) { 
                        currentSaldo = compte.getSaldo();
                        if (j % 2 == 0) {
                            compte.setSaldo(currentSaldo + aportacio); // Modifica el saldo
                        } else {
                            compte.setSaldo(currentSaldo - aportacio); // Modifica el saldo
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
