package com.irimie;

import java.util.ArrayList;

public class Flotta {

    private static ArrayList<Battello> battelli;

    public Flotta() {
        battelli = new ArrayList<>();
    }

    public static Battello getBattello(String nome) {
        Battello battello = new Battello();
        for(Battello b: battelli) {
            if(b.getNomeBattello().equals(nome)) {
                battello =  b;
            }
        }
        return battello;
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

    public static boolean decrementaPosti(String nome) {
        for(Battello b: battelli) {
            if(b.getNomeBattello().equals(nome)) {
                if (b.getPosti() > 0) {
                    b.setPosti(b.getPosti() - 1);
                    return true;
                }
            }
        }
        return false;
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

    public static boolean controllaNomeBattello(String nome) {
        for (Battello b : battelli) {
            if (b.getNomeBattello().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}


