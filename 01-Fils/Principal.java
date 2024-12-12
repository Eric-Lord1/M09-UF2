


public class Principal {
    

    public static void main(String[] args) {
        
        Fil fil = new Fil();
        fil.setName("Juan");
        fil.setPriority(1);

        Fil fil2 = new Fil();
        fil2.setName("Pepe");
        fil2.setPriority(10);

        fil.start();
        fil2.start();
        

    }

}
