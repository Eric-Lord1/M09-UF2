import java.util.Random;

public class DormAleatori extends Thread { 

    long bornTime;
    Random random = new Random();

    public DormAleatori() {
        this.bornTime = System.currentTimeMillis();
    }

    public DormAleatori(String name) {
        super(name);
        this.bornTime = System.currentTimeMillis();
    }

    @Override
    public void run() {

        try {

            for (int i = 0; i < 10; i++) {

                int sleepTime = random.nextInt(1000);
                long liveTime =  System.currentTimeMillis() - bornTime;
                
                sleep(sleepTime);
                
                System.out.printf("%s (%d) a dormir %d ms total     %d\n", this.getName(), i, sleepTime, liveTime);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }


    public static void main(String[] args) {

        DormAleatori fil1 = new DormAleatori("Joan");
        DormAleatori fil2 = new DormAleatori("Pep");

        fil1.start();;
        fil2.start();;

        
    }

}
