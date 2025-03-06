import java.util.Random;

public class Barber extends Thread {

    public Random random = new Random();

    public Barber(String nom) {
        super(nom);
    }

    @Override
    public void run() {

        while (true) {

            Client client = Barberia.barberia.seguentClient();

            if (client != null) {

                client.tallarseElCabell();
                try {
                    Thread.sleep(900 + random.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    synchronized (Barberia.barberia.condBarber) {
                        Barberia.barberia.condBarber.wait();
                    }
                    System.out.println("Barber " + getName() + " dormint");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
