public class Administracio {

    private static int num_poblacio_activa = 50;
    private static Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public static void administracio() {
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + (i + 1), 25000, 20, 65);
        }
    }

    public static void mainMethod() {

        for (Treballador treballador : poblacio_activa) {
            treballador.start();
        }

        for (Treballador treballador : poblacio_activa) {
            try {
                treballador.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (Treballador treballador : poblacio_activa) {
            System.out.printf("%s -> edat: %d / total: %.2f%n", treballador.getName(), treballador.getEdat(), treballador.getCobrat());
        }
    }

    public static void main(String[] args) {
        administracio(); 
        mainMethod();   
    }
}