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
    private int postiMax;
    private float occupazione;
    private Date data;
    private ArrayList<Prenotazione> prenotazioni;

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

    public float getOccupazione() {
        return occupazione;
    }

    public void setOccupazione(float occupazione) {
        this.occupazione = occupazione;
    }

    public int getPostiMax() {
        return postiMax;
    }

    public void setPostiMax(int postiMax) {
        this.postiMax = postiMax;
    }

    public ArrayList<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }


    public static Battello creaBattello(Scanner scanner) throws ParseException {
        Battello battello = new Battello();
        System.out.println("Inserisci il nome del battello");
        battello.nomeBattello = scanner.nextLine();

        System.out.println("Inserisci i posti massimi del battello");
        battello.posti = scanner.nextInt();
        battello.postiMax = battello.posti;
        scanner.nextLine();

        System.out.println("Inserisci data e l'ora di partenza nel formato dd/mm/yyyy hh:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm", java.util.Locale.ITALY);
        battello.data = formatter.parse(scanner.nextLine());
        System.out.println("Il battello è stato aggiunto alla flotta \n");

        battello.occupazione = (float) (battello.posti / battello.postiMax)*100;

        return battello;
    }

    public void aggiungiPrenotazione(Flotta flotta, String nome) {
        Scanner scanner = new Scanner(System.in);
        Prenotazione p = new Prenotazione();

        if (Flotta.controllaNomeBattello(nome)) {
            p.setNomeBattelloPrenotato(nome);
            p.creaPrenotazione(scanner);
        } else {
            System.out.println("Battello non disponibile");
        }

        prenotazioni.add(p);
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
                "Posti = " + posti + "/" + postiMax + "\n" +
                "Occupazione = " + occupazione + "%" + "\n" +
                "Data e ora di partenza = " + data + "\n";
    }
}
