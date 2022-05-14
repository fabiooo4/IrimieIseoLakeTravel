package com.irimie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Battello {

    private String nomeBattello;
    private int posti;
    private Date data;
    private ArrayList<Prenotazione> prenotazioni;

    public Battello(String nomeBattello, int posti, Date data) {
        prenotazioni = new ArrayList<>();
        this.nomeBattello = nomeBattello;
        this.posti = posti;
        this.data = data;
    }

    public Battello() {
        prenotazioni = new ArrayList<>();
    }


    public String getNomeBattello() {
        return nomeBattello;
    }

    public void setNomeBattello(String nomeBattello) {
        this.nomeBattello = nomeBattello;
    }

    public int getPosti() {
        return posti;
    }

    public void setPosti(int posti) {
        this.posti = posti;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    public static Battello creaBattello(Scanner scanner) throws ParseException {
        Battello battello = new Battello();
        System.out.println("Inserisci il nome del battello");
        battello.nomeBattello = scanner.nextLine();

        System.out.println("Inserisci i posti massimi del battello");
        battello.posti = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisci data e l'ora di partenza nel formato dd/mm/yyyy hh:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm", java.util.Locale.ITALY);
        battello.data = formatter.parse(scanner.nextLine());
        System.out.println("Il battello è stato aggiunto alla flotta \n");

        return battello;
    }

    public void aggiungiPrenotazione(Flotta flotta, String nome) {
        Scanner scanner = new Scanner(System.in);
        Prenotazione p = new Prenotazione();

        if (flotta.controllaNomeBattello(nome)) {
            p.setNomeBattelloPrenotato(nome);
            p.creaPrenotazione(scanner);
        } else {
            System.out.println("Battello non disponibile");
        }

        prenotazioni.add(p);
    }

    public void rimuoviPrenotazione(Flotta flotta, Scanner scanner) {
        System.out.println("Inserisci il codice fiscale del prenotatore");
        String codiceFiscale = scanner.nextLine();
        for(Prenotazione p: prenotazioni) {
            if(p.getCodiceFiscale().equals(codiceFiscale)) {
                // TODO stampa battelli prenotati dal prenotatore
                flotta.getBattello(p.getNomeBattelloPrenotato());
            } else {
                System.out.println("Nessuna prenotazione trovata");
            }
        }
    }

    public void listaPrenotazioni(String nome) {
        int i = 1;
        if (Flotta.controllaNomeBattello(nome)) {
            for (Prenotazione p : prenotazioni) {
                System.out.println("\nPrenotazione" + i + ": ");
                String s = p.toString();
                System.out.println(s);
                i++;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battello battello = (Battello) o;
        return nomeBattello == battello.nomeBattello &&
                posti == battello.posti &&
                Objects.equals(data, battello.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeBattello, posti, data);
    }

    @Override
    public String toString() {
        return "Nome = " + nomeBattello + "\n" +
                "Posti = " + posti + "\n" +
                "Data e ora di partenza = " + data + "\n";
    }
}
