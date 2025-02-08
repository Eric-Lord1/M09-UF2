class Forquilla {
    
    private final int numero;
    private boolean enUs = false;

    public Forquilla(int numero) {
        this.numero = numero;
    }

    public boolean agafar() {
        if (!enUs) {
            enUs = true;
            return true;
        }
        return false;
    }

    public void deixar() {
        enUs = false;
    }

    @Override
    public String toString() {
        return "Forquilla " + numero;
    }
}