import java.util.ArrayList;

public class Organitzador {
    
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5);
        ArrayList<Assistent> assistents = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Assistent assistent = new Assistent("Assistent-" + i, esdeveniment);
            assistents.add(assistent);
        }
        
        for (Assistent assistent : assistents) {
            assistent.start();
        }

        
    }

}
