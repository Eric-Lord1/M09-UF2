class Dona extends Thread {
    private final String nom;
    private final BanyUnisex bany;
    
    public Dona(String nom, BanyUnisex bany) {
        this.nom = nom;
        this.bany = bany;
    }
    
    public void run() {
        System.out.println(nom + " vol entrar al bany");
        bany.entraDona(nom);
        try {
            Thread.sleep((long) (Math.random() * 1000 + 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bany.surtDona(nom);
        System.out.println(nom + " ha acabat d'usar el bany");
    }
}