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

    public synchronized void nouSubministrament() {
        switch (random.nextInt(3)) {
            case 0 -> addTabac();
            case 1 -> addPaper();
            case 2 -> addLlumi();
        }
        notifyAll();
    }

    public synchronized void addTabac() {
        tabacs.add(new Tabac());
        System.out.println("Afegint Tabac");
    }

    public synchronized void addPaper() {
        papers.add(new Paper());
        System.out.println("Afegint Paper");
    }

    public synchronized void addLlumi() {
        llumis.add(new Llumi());
        System.out.println("Afegint Llumins");
    }

    public synchronized Tabac venTabac() throws InterruptedException {
        while (tabacs.isEmpty()) {
            wait();
        }
        Tabac tabac = tabacs.remove(tabacs.size() - 1);
        System.out.println("Venent Tabac");
        return tabac;
    }

    public synchronized Paper venPaper() throws InterruptedException {
        while (papers.isEmpty()) {
            wait();
        }
        Paper paper = papers.remove(papers.size() - 1);
        System.out.println("Venent Paper");
        return paper;
    }

    public synchronized Llumi venLlumi() throws InterruptedException {
        while (llumis.isEmpty()) {
            wait();
        }
        Llumi llumi = llumis.remove(llumis.size() - 1);
        System.out.println("Venent Llumins");
        return llumi;
    }

    public synchronized void tancarEstanc() {
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

