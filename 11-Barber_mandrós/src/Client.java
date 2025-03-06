

public class Client {

    String nom;

    public Client(int id){
        nom = "Client-" + id;
    }

    public String getNom() {
        return nom;
    }

    public void tallarseElCabell() {
        System.out.println("Tallant el cabell del client: " + nom);
    }
    
}
