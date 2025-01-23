public class Compte {

    private static Compte compte;
    private int saldo;

    private Compte() {
        saldo = 0;
        if (compte != null) throw new RuntimeException("No pots fer una instancia de un singelton.");
    }

    public static Compte getInstance() {
        if (compte == null) {
            compte = new Compte();
        }
        return compte;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
