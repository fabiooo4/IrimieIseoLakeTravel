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

    public Battello() {}


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

        System.out.println("Lista battelli nella flotta:");

        return battello;
    }

    public void aggiungiPrenotazione(String nome, Prenotazione p) {
        Scanner scanner = new Scanner(System.in);
        while(!Flotta.controllaNomeBattello(nome)) {
            if (Flotta.controllaNomeBattello(nome)) {
                Battello bAggiornato = Flotta.getBattello(nome);
                p.setNomeBattelloPrenotato(nome);
                p.creaPrenotazione(scanner);
                bAggiornato.aggiungiPrenotazione(nome, p);
            } else {
                System.out.println("Battello non disponibile");
            }
        }

        Flotta.decrementaPosti(nome, p);
        prenotazioni.add(p);
    }

    public void listaPrenotazioni(String nome) {

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
