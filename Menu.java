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
                    System.out.println("Inserisci il nome del battello");
                    flotta.rimuoviBattelloDaTitolo(scanner.nextLine());
                    break;

                case 3: // Lista battelli
                    System.out.println("Lista battelli:");
                    flotta.stampaBattelli();
                    break;

                case 4: // Prenota battello
                    System.out.println("Lista battelli disponibili");
                    flotta.stampaBattelli();

                    System.out.println("Inserisci il nome del battello da prenotare");
                    String nomeBattelloPrenotato = scanner.nextLine();

                    Battello b2 = flotta.getBattello(nomeBattelloPrenotato);
                    if (flotta.decrementaPosti(nomeBattelloPrenotato)) {
                        b2.aggiungiPrenotazione(flotta, nomeBattelloPrenotato);
                    } else {
                        System.out.println("Posti esauriti");
                    }
                    break;
                case 5: // Rimuovi prenotazione

                    break;
                case 6: // Lista prenotazioni
                    break;
            }
        }
    }
}
