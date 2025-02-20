import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {

    private int numeroForquilla;

    ReentrantLock bloqueig;

    public Forquilla(int numeroForquilla) {
        this.numeroForquilla = numeroForquilla;
        bloqueig = new ReentrantLock(true);
    }

    public int getNumeroForquilla() {
        return numeroForquilla;
    }

    public void agafar() {
        if (bloqueig.isHeldByCurrentThread()) bloqueig.lock();
    }

    public void deixar() {
        if (bloqueig.isHeldByCurrentThread()) bloqueig.unlock();
    }

    @Override
    public String toString() {
        return "Forquilla -> " + numeroForquilla;
    }

}