

public class Associacio {
    
    int numSocis;
    Soci[] soci;

    public Associacio() {
        numSocis = 1000;
        soci = new Soci[numSocis];
    }

    public void iniciaCompteTempsSocis() {
        for (int i = 0; i < numSocis; i++) {
            soci[i] = new Soci("Soci->" + i);
            soci[i].start();
        }
    }

    public void esperarPeriodeSocis() {
        try {
            for (int i = 0; i < soci.length; i++) {
                soci[i].join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void mostraBalancComptes() {
        float balanc = 0f;

        for (int i = 0; i < soci.length; i++) {
            balanc = soci[i].compte.getSaldo();
        }

        System.out.println("Saldo: " + balanc);
    }

    public static void main(String[] args) {
        
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.esperarPeriodeSocis();
        associacio.mostraBalancComptes();

    }

}
