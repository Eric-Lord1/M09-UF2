import java.util.Scanner;

public class Coet {

    Motor[] motors = new Motor[4];
    public static Scanner scanner = new Scanner(System.in);

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor();
            motors[i].setName(String.valueOf(i));
        }
    }

    public void passaAPotencia(int p) {

        if (p < 0 || p > 10) {
            System.out.println("ERROR, potencia no valida");
            return;
        }

        System.out.println("Passant a potencia " + p);

        for (Motor motor : motors) {
            motor.setTargetPower(p);
        }

    }

    public static void main(String[] args) {

        Coet coet = new Coet();

        for (Motor motor : coet.motors) {
            motor.start();
        }

        while (true) {

            int potencia = scanner.nextInt();
            coet.passaAPotencia(potencia);

            for (Motor motor : coet.motors) {
                if (motor.getPower() == 0) {
                    break;
                }
            }
            
        }
    }
}
