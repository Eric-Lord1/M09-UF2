import java.util.ArrayList;
import java.util.Random;

public class Estanc extends Thread {

    ArrayList<Tabac> tabacs;
    ArrayList<Paper> papers;
    ArrayList<Llumi> llumis;
    
    Random random = new Random();
    boolean tancat = false;

    public Estanc() {
        this.tabacs = new ArrayList<>();
        this.papers = new ArrayList<>();
        this.llumis = new ArrayList<>();
    }

    public void nouSubministrament() {
        switch (random.nextInt(3)) {
            case 0 -> addTabac();
            case 1 -> addPaper();
            case 2 -> addLlumi();
        }
    }

    public void addTabac() {
        tabacs.add(new Tabac());
        System.out.println("Afegint Tabac");
    }

    public void addPaper() {
        papers.add(new Paper());
        System.out.println("Afegint Paper");
    }

    public void addLlumi() {
        llumis.add(new Llumi());
        System.out.println("Afegint Llumins");
    }

    public Tabac venTabac() {
        if (!tabacs.isEmpty()) {
            Tabac tabac = tabacs.remove(tabacs.size() - 1);
            System.out.println("Venent Tabac");
            return tabac;
        } else {
            System.out.println("No hi ha tabac disponible.");
            return null;
        }
    }

    public Paper venPaper() {
        if (!papers.isEmpty()) {
            Paper paper = papers.remove(papers.size() - 1);
            System.out.println("Venent Paper");
            return paper;
        } else {
            System.out.println("No hi ha paper disponible.");
            return null;
        }
    }

    public Llumi venLlumi() {
        if (!llumis.isEmpty()) {
            Llumi llumi = llumis.remove(llumis.size() - 1);
            System.out.println("Venent Llumins");
            return llumi;
        } else {
            System.out.println("No hi ha llumins disponibles.");
            return null;
        }
    }

    public void tancarEstanc() {
        tancat = true;
        System.out.println("Estanc tancat.");
    }

    @Override
    public void run() {
        while (!tancat) {
            nouSubministrament();
            try {
                Thread.sleep(500 + random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
