package oo.jogodavelha.models;

public class Coordenada {
    private int x;
    private int y;

    public Coordenada(int x, int y) {
        setCoordenadaX(x);
        setCoordenadaY(y);
    }

    public void setCoordenadaX(int x) {
        this.x = x;
    }

    public int getCoordenadaX() {
        return this.x;
    }

    public void setCoordenadaY(int y) {
        this.y = y;
    }

    public int getCoordenadaY() {
        return this.y;
    }

    @Override
    public String toString() {
        return getCoordenadaX()+", "+getCoordenadaY();
    }
}
