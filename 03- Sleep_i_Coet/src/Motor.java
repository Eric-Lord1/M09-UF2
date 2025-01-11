import java.util.Random;

public class Motor extends Thread {

    private int currentPower = 1;
    private int targetPower = 1;
    private boolean running = true;

    public int getPower() {
        return currentPower;
    }

    public void setTargetPower(int targetPower) {
        this.targetPower = targetPower;
    }

    @Override
    public void run() {

        Random random = new Random();

        while (running) {

            try {

                if (currentPower < targetPower) {
                    currentPower++;
                    System.out.printf("Motor %s: Incre. Objectiu: %d Actual: %d\n", this.getName(),
                            this.targetPower, this.currentPower);
                } else if (currentPower > targetPower) {
                    currentPower--;
                    System.out.printf("Motor %s: Decre. Objectiu: %d Actual: %d\n", this.getName(),
                            this.targetPower, this.currentPower);
                } else {
                    System.out.printf("Motor %s: FerRes. Objectiu: %d Actual: %d\n", this.getName(),
                            this.targetPower, this.currentPower);
                }

                if (currentPower == 0) {
                    break;
                }

                Thread.sleep(random.nextBoolean() ? 1000 : 2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}
