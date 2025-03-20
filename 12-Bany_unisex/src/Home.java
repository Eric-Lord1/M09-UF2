class Home extends Thread {
    private final String nom;
    private final BanyUnisex bany;
    
    public Home(String nom, BanyUnisex bany) {
        this.nom = nom;
        this.bany = bany;
    }
    
    public void run() {
        System.out.println(nom + " vol entrar al bany");
        bany.entraHome(nom);
        try {
            Thread.sleep((long) (Math.random() * 1000 + 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bany.surtHome(nom);
        System.out.println(nom + " ha acabat d'usar el bany");
    }
}