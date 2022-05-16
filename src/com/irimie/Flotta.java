package com.irimie;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void rimuoviBattello(String nome) {
        for(Battello b: battelli) {
            if(b.getNomeBattello().equals(nome)) {
                battelli.remove(b);
                System.out.println("Battello rimosso");
                return;
            }
        }
        System.out.println("Battello non trovato");
    }

    public static boolean decrementaPosti(String nome) {

        for(Battello b: battelli) {
            if(b.getNomeBattello().equals(nome)) {
                if (b.getPosti() > 0) {
                    b.setPosti(b.getPosti() - 1);
                    float numeroPosti = b.getPosti();
                    float numeroPostiMax = b.getPostiMax();
                    b.setOccupazione((numeroPosti / numeroPostiMax)*100);
                    return true;
                }
            }
        }
        return false;
    }

    public static void stampaBattelli() {
        int i = 1;
        for(Battello b: battelli) {
            System.out.println("\nBattello " + i + ": ");
            String s = b.toString();
            System.out.println(s);
            i++;
        }
    }

    public void stampaPrenotazioni(Scanner scanner) {
        System.out.println("Inserisci il nome del battello");
        String nome = scanner.nextLine();
        Battello battello = getBattello(nome);

        int i = 1;
        System.out.println("Prenotazioni del battello " + nome + ":");
        if(battello.getPrenotazioni().size() == 0) {
            System.out.println("Nessuna prenotazione");
        } else {
            for(Prenotazione p: battello.getPrenotazioni()) {
                System.out.println("\nPrenotazione " + i + ":\n" + p.toString());
                i++;
            }
        }
    }

    public static void rimuoviPrenotazione(Scanner scanner) {
        System.out.println("Inserisci il nome del battello di cui si vuole eliminare la prenotazione:");
        String nome = scanner.nextLine();
        Battello battello = getBattello(nome);

        System.out.println("Inserisci il codice fiscale del cliente");
        String codice = scanner.nextLine();
        for(Prenotazione p: battello.getPrenotazioni()) {
            if(p.getCodiceFiscale().equals(codice)) {
                battello.setPosti(battello.getPosti() + 1);
                float numeroPosti = battello.getPosti();
                float numeroPostiMax = battello.getPostiMax();
                battello.setOccupazione((numeroPosti / numeroPostiMax)*100);
                battello.getPrenotazioni().remove(p);
                System.out.println("Prenotazione rimossa");
                return;
            }
        }
        System.out.println("Prenotazione non trovata");
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


