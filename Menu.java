package com.irimie;

import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    private int scelta;
    Scanner scanner = new Scanner(System.in);
    Flotta flotta = new Flotta();

    public void run() throws ParseException {
        while(true) {
            System.out.println("0: Esci \n" +
                    "1: Aggiungi battello \n" +
                    "2: Rimuovi battello \n" +
                    "3: ");

            scelta = scanner.nextInt();
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
            }
        }
    }
}
