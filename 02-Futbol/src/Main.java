


public class Main {

    public static void main(String[] args) {

        String[] names = {"CR7","Pique","Messi","Haaland","Jack Grealish","Lamine Yamal","Lewangolski","Xavi","Puyol", "Ronaldino", "Gavi"};

        Futbolista[] futbolistas = new Futbolista[11];
        
        for (int i = 0; i < futbolistas.length; i++) {
            futbolistas[i] = new Futbolista();
            futbolistas[i].setName(names[i]);
        }

        System.out.println("Inici dels xuts --------------------");
        for (int i = 0; i < futbolistas.length; i++) {
            futbolistas[i].start();
        }
        System.out.println("Fi dels xuts -----------------------");

        System.out.println("--- Estadístiques ------");
        for (int i = 0; i < futbolistas.length; i++) {
            System.out.println(futbolistas[i].getGols());
        }

    }

}