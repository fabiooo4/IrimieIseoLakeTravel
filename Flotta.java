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

    public void stampaBattelli() {
        int i = 1;
        for(Battello b: battelli) {
            System.out.println("\nBattello" + i + ": ");
            String s = b.toString();
            System.out.println(s);
            i++;
        }
    }

    public boolean controllaNomeBattello(String nome) {
        for (Battello b : battelli) {
            if (b.getNomeBattello().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}


