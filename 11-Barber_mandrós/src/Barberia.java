import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread {

    Queue<Client> salaDeEspera = new LinkedList<>();
    public Object condBarber = new Object();
    int numCadires;

    public static Barberia barberia;

    public Barberia(int cadires) {
        numCadires = cadires;
    }

    public Client seguentClient() {
        synchronized (salaDeEspera) {
            return salaDeEspera.poll();
        }
    }

    public void entrarClient(Client client) {
        
        synchronized (salaDeEspera) {

            synchronized (condBarber) {
                condBarber.notify();  
            }

            if (salaDeEspera.size() < numCadires) {

                salaDeEspera.offer(client);
                System.out.println(client.getNom() + " en espera");
                
            } else {
                System.out.println("No queden cadires, " + client.getNom() + " se'n va");
            }
        }
    }

    @Override
    public void run() {
        try {

            for (int i = 1; i <= 20; i++) {
                entrarClient(new Client(i));
                Thread.sleep(500);
                if (i == 10) Thread.sleep(10000);
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        barberia = new Barberia(3);
        Barber barber = new Barber("Pepe");
        barber.start();
        barberia.start();
    }

}
