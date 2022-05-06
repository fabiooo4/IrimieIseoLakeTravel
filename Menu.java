package com.irimie;

import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Flotta flotta = new Flotta();

    public void run() throws ParseException {
        while(true) {
            System.out.println("\n0: Esci \n" +
                    "1: Aggiungi battello \n" +
                    "2: Rimuovi battello \n" +
                    "3: Prenota battello \n");

            int scelta = scanner.nextInt();
            scanner.nextLine();
            switch (scelta) {
                case 0: // Esci
                    return;
                case 1: // Aggiungi battello
                    Battello b = Battello.creaBattello(scanner);

                    flotta.aggiungiBattello(b);
                    flotta.stampaBattelli();
                    break;
                case 2: // Rimuovi battello
                    System.out.println("Inserisci il nome del battello");
                    flotta.rimuoviBattelloDaTitolo(scanner.nextLine());
                    break;
                case 3: // Prenota battello
                    Prenotazione p = new Prenotazione();

                    System.out.println("Lista battelli disponibili");
                    flotta.stampaBattelli();

                    System.out.println("Inserisci il nome del battello da prenotare");
                    String nomeBattelloPrenotato = "";
                    while(!flotta.controllaNomeBattello(nomeBattelloPrenotato)) {
                        nomeBattelloPrenotato = scanner.nextLine();
                        if (flotta.controllaNomeBattello(nomeBattelloPrenotato)) {
                            p.setNomeBattelloPrenotato(nomeBattelloPrenotato);
                            p.creaPrenotazione(scanner);
                            .setPosti(b.getPosti() - 1); // TODO: Decremento il numero di posti disponibili e aggiorno la flotta

                        } else {
                            System.out.println("Battello non disponibile");
                        }
                    }
            }
        }
    }
}
