import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {

    public List<Assistent> llistaAssistents = new ArrayList<>();
    public int placesDisponibles;
    public int numMaximPlaces;

    public Esdeveniment(int numMaximPlaces) {
        this.numMaximPlaces = numMaximPlaces;
        placesDisponibles = numMaximPlaces;
    }

    public boolean ferReserva(Assistent assistent) {
        if (llistaAssistents.size() < numMaximPlaces) { 
            llistaAssistents.add(assistent);
            placesDisponibles--;
            return true; 
        }
        return false; 
    }
    
    public boolean cancelarReserva(Assistent assistent) {
        if (llistaAssistents.contains(assistent)) { 
            llistaAssistents.remove(assistent);
            placesDisponibles++;
            return true; 
        }
        return false; 
    }

}