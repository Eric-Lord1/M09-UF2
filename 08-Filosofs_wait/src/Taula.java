import java.util.ArrayList;

public class Taula {

    ArrayList<Filosof> comensals = new ArrayList<>();
    ArrayList<Forquilla> forquilles = new ArrayList<>();

    public Taula(int numeroFilosofs, int numeroForquilles) {

        for (int i = 0; i < numeroForquilles; i++) {
            forquilles.add(new Forquilla(i));
        }

        for (int i = 0; i < numeroFilosofs; i++) {
            if (i == numeroFilosofs - 1) {
                comensals.add(new Filosof("fil" + i, forquilles.get(i), forquilles.get(0)));
            } else {
                comensals.add(new Filosof("fil" + i, forquilles.get(i), forquilles.get(i + 1)));
            }
        }

    }

    public void showTaula() {

        for (int i = 0; i < comensals.size(); i++) {
            System.out.print("Comensal:" + comensals.get(i).toString());
            if (i == comensals.size() - 1) {
                System.out.println(" esq: " + forquilles.get(i).toString() + " dret: " + forquilles.get(0).toString());
            } else {
                System.out.println(
                        " esq: " + forquilles.get(i).toString() + " dret: " + forquilles.get(i + 1).toString());
            }
        }

    }

    public void cridaATaula() {
        for (int i = 0; i < comensals.size(); i++) {
            comensals.get(i).start();
        }
    }

    public static void main(String[] args) {

        Taula taula = new Taula(4, 4);

        taula.showTaula();
        taula.cridaATaula();

    }

}
