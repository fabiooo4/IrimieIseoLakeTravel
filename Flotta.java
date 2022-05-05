package com.irimie;

import java.util.ArrayList;

public class Flotta {

    private ArrayList<Battello> battelli;

    public Flotta() {
        battelli = new ArrayList<>();
    }

    public void aggiungiBattello(Battello battello) {
        battelli.add(battello);
    }

    public void rimuoviBattelloDaTitolo(String nome) {
        for(Battello b: battelli) {
            if(b.getNomeBattello().equals(nome)) {
                battelli.remove(b);
                return;
            }
        }
    }

}
