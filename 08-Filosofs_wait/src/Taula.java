import java.util.ArrayList;

public class Taula {
    private final ArrayList<Filosof> comensals = new ArrayList<>();
    private final ArrayList<Forquilla> forquilles = new ArrayList<>();

    public Taula(int numeroFilosofs) {
        for (int i = 0; i < numeroFilosofs; i++) {
            forquilles.add(new Forquilla(-1));
        }

        for (int i = 0; i < numeroFilosofs; i++) {
            Filosof filosof = new Filosof("fil" + i, forquilles.get(i), forquilles.get((i + 1) % numeroFilosofs));
            comensals.add(filosof);
        }
    }

    public void cridaATaula() {
        for (Filosof filosof : comensals) {
            filosof.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.cridaATaula();
    }
}