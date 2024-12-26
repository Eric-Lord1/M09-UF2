
public class Futbolista extends Thread {

    private int NUM_JUGADORS = 11;
    private int NUM_TIRADES = 20;
    private double PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista() {
        this.ngols = 0;
        this.ntirades = 0;
    }
    
    @Override
    public void run() {
        for (int i = ntirades; i < NUM_TIRADES; i++) {
            if (Math.random() > PROBABILITAT) ngols++;
        }
    }

    public String getGols() {
        return this.getName() + "  ->  " + this.ngols + " gols";
    }

    
}
