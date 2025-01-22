import java.util.Random;

public class Treballador extends Thread {

    private final float sou_anual_brut;
    private final int edat_inici_treball;
    private final int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private final Random rnd;

    public Treballador(String nom, float sou_anual_brut, int edat_inici_treball, int edat_fi_treball) {
        super(nom);
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    public void cobra() {
        cobrat += (sou_anual_brut / 12);
    }

    public void pagaImpostos() {
        cobrat -= ((sou_anual_brut / 12f) * 0.24f);
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edat_actual;
    }

    @Override
    public void run() {
        edat_actual = edat_inici_treball;
        while (edat_actual < edat_fi_treball) {
            try {
                for (int i = 0; i < 12; i++) {
                    cobra();
                    pagaImpostos();
                    Thread.sleep(rnd.nextInt(100));
                }
                edat_actual++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
