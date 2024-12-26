public class MainDemoFil {

    public static void main(String[] args) {
        
        Thread currentThread = Thread.currentThread();

        System.out.println("Prioritat -> " + currentThread.getPriority() + ", Nom -> " + currentThread.getName());
        System.out.println("toString() -> " + currentThread.toString());

    }

}
