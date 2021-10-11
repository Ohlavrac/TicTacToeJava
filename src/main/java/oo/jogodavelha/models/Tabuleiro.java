package oo.jogodavelha.models;

import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {
    private Map<Coordenada, Character> tabuleiroMap;

    public Tabuleiro() {
        tabuleiroMap = new HashMap<Coordenada, Character>();
    }

    public boolean isEmpty() {
        return tabuleiroMap.isEmpty();
    }

    public void marcaTabuleiroMap(Coordenada coordenada, Character marca) {
        this.tabuleiroMap.put(coordenada, marca);
    }
}
