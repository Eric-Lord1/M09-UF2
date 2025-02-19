class Forquilla {
    
    public final int LLIURE = -1;
    private int propietari;

    public Forquilla(int propietari) {
        this.propietari = propietari;
    }

    public synchronized int getPropietari() {
        return propietari;
    }

    public synchronized void setPropietari(int propietari) {
        this.propietari = propietari;
    }

    @Override
    public String toString() {
        return "Forquilla";
    }
}