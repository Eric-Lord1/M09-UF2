import java.util.Random;

public class Assistent extends Thread {

    Random random = new Random();
    public Esdeveniment esdeveniment;
    public String nom;

    public Assistent(String nom, Esdeveniment esdeveniment) {
        super(nom);
        this.nom = nom;
        this.esdeveniment = esdeveniment;
    }

    public void gestorReserva() {
        synchronized (esdeveniment) {
            try {
                if (Math.random() < 0.3) {
                    if (this.esdeveniment.ferReserva(this)) {
                        System.out.println(this.getName() + " ha fet una reserva. Places disponibles: "
                                + this.esdeveniment.placesDisponibles);
                        esdeveniment.notifyAll();
                    } else {
                        System.out.println(
                                this.getName()
                                        + " no s'ha pogut fer la reserva per falta de capacitat. Places disponibles: "
                                        + this.esdeveniment.placesDisponibles);
                        esdeveniment.wait();
                    }
                } else {
                    if (this.esdeveniment.cancelarReserva(this)) {
                        System.out.println(this.getName() + " s'ha cancelat una reserva. Places disponibles: "
                                + this.esdeveniment.placesDisponibles);
                        esdeveniment.notifyAll();
                    } else {
                        System.out.println(
                                this.getName() + " no s'ha pogut cancelar una reserva inexsistent. Places disponibles: "
                                        + this.esdeveniment.placesDisponibles);
                        esdeveniment.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {
        while (true) {
            gestorReserva();
        }
    }

}
