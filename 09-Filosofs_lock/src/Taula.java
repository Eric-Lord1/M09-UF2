import java.util.ArrayList;

public class Taula {
    
    public ArrayList<Filosof> filosofs;
    public ArrayList<Forquilla> forquilles;

    public Taula(int numeroFilosofs, int numeroForquilles) {
        
        filosofs = new ArrayList<>();
        forquilles = new ArrayList<>();
        
        for (int i = 0; i < numeroForquilles; i++) {
            forquilles.add(new Forquilla(i));
        }

        for (int i = 0; i < numeroFilosofs; i++) {
            if (i >= numeroFilosofs - 1) {
                filosofs.add(new Filosof("fil"+i, forquilles.get(i), forquilles.get(0)));                
            } else {
                filosofs.add(new Filosof("fil"+i, forquilles.get(i), forquilles.get(i+1)));
            }
        }
    }

    public void showTaula() {
        for (int i = 0; i < filosofs.size(); i++) {
            System.out.print("Comensal:" + filosofs.get(i).toString());
            if (i == filosofs.size() - 1) {
                System.out.println(" esq: " + forquilles.get(i).toString() +" dret: "+ forquilles.get(0).toString());
            } else {
                System.out.println(" esq: " + forquilles.get(i).toString() +" dret: "+ forquilles.get(i+1).toString());
            }
        }
    }

    public void cridaATaula() {
        for (int i = 0; i < filosofs.size(); i++) {
            filosofs.get(i).start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(5, 5);
        taula.showTaula();
        taula.cridaATaula();
    }

}
