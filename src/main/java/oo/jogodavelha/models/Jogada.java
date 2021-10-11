package oo.jogodavelha.models;

public class Jogada {
    private Character marca;
    private Coordenada coordenada;

    public Jogada(Character marca, Coordenada coordenada) {
        setMarca(marca);
        setCoordenada(coordenada);
    }

    public void setMarca(Character marca) {
        this.marca = marca;
    }

    public Character getMarca() {
        return this.marca;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Coordenada getCoordenada() {
        return this.coordenada;
    }
}
