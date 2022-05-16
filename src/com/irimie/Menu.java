package com.irimie;

import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Flotta flotta = new Flotta();

    public void run() throws ParseException {
        while(true) {
            System.out.print("-----------------------");
            System.out.println("\n0: Esci \n" +
                    "1: Aggiungi battello \n" +
                    "2: Rimuovi battello \n" +
                    "3: Lista batetlli \n" +
                    "4: Prenota battello \n" +
                    "5: Rimuovi prenotazione \n" +
                    "6: Lista prenotazioni");
            System.out.println("-----------------------");

            int scelta = scanner.nextInt();
            scanner.nextLine();
            switch (scelta) {
                case 0: // Esci
                    return;
                case 1: // Aggiungi battello
                    Battello b = Battello.creaBattello(scanner);

                    flotta.aggiungiBattello(b);
                    break;

                case 2: // Rimuovi battello
                    System.out.println("Battelli disponibili:");
                    Flotta.stampaBattelli();
                    System.out.println("Inserisci il nome del battello");
                    flotta.rimuoviBattello(scanner.nextLine());
                    break;

                case 3: // Lista battelli
                    System.out.println("Lista battelli:");
                    Flotta.stampaBattelli();
                    break;

                case 4: // Prenota battello
                    System.out.println("Lista battelli disponibili:");
                    Flotta.stampaBattelli();

                    System.out.println("Inserisci il nome del battello da prenotare");
                    String nomeBattelloPrenotato = scanner.nextLine();

                    Battello b2 = Flotta.getBattello(nomeBattelloPrenotato);
                    if (Flotta.decrementaPosti(nomeBattelloPrenotato)) {
                        b2.aggiungiPrenotazione(flotta, nomeBattelloPrenotato);
                    } else {
                        System.out.println("Battello non disponibile");
                    }
                    break;
                case 5: // Rimuovi prenotazione
                    System.out.println("Lista battelli:");
                    Flotta.stampaBattelli();
                    Flotta.rimuoviPrenotazione(scanner);
                    break;
                case 6: // Lista prenotazioni
                    System.out.println("Lista battelli disponibili:");
                    Flotta.stampaBattelli();
                    flotta.stampaPrenotazioni(scanner);
                    break;
            }
        }
    }
}
