/*
 * Filosof
 */

import java.util.Random;

public class Filosof extends Thread {

    Random random = new Random();

    public long iniciGana;
    public long fiGana;
    public long gana;

    public Forquilla forquillaDreta;
    public Forquilla forquillaEsquerra;

    public int comptadorGana;

    public Filosof(String name, Forquilla forquillaDreta, Forquilla forquillaEsquerra) {
        super(name);
        iniciGana = 0;
        fiGana = 0;
        gana = 0;
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public void menjar() {
        try {
            fiGana = System.currentTimeMillis() / 1000;
            System.out.println(getName() + " menjant");
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    public void agafarForquillaDreta() {
        forquillaDreta.agafar();
        System.out.println(currentThread().getName() + " - Ha afagat la forquilla dreta");
    }

    public void agafarForquillaEsquerra() {
        forquillaEsquerra.agafar();
        System.out.println(currentThread().getName() + " - Ha afagat la forquilla esquerra");
    }

    public void dixarForquilles() {
        forquillaDreta.deixar();
        System.out.println(currentThread().getName() + " - Ha deixat la forquilla dreta");
        forquillaEsquerra.deixar();
        System.out.println(currentThread().getName() + " - Ha deixat la forquilla esquerra");
    }

    public void pensar() {
        try {
            iniciGana = System.currentTimeMillis() / 1000;
            System.out.println(getName() + " pensant");
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calcularGana() {
        gana = fiGana - iniciGana;
        System.out.println(getName() + " -> Ha tingut una gana de " + gana + " segons");
    }

    public void resetGana() {
        gana = 0;
    }

    @Override
    public void run() {

        while (true) {
            pensar();
            agafarForquilles();
            menjar();
            calcularGana();
            dixarForquilles();
            resetGana();
        }

    }

    @Override
    public String toString() {
        return getName();
    }

}
