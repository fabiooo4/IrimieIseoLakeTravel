package com.irimie;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Scanner;

public class Prenotazione {

    private String nome;
    private String cognome;
    private String codiceFiscale;



    private String nomeBattelloPrenotato;

    public Prenotazione(String nome, String cognome, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }

    public Prenotazione() {}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNomeBattelloPrenotato() {
        return nomeBattelloPrenotato;
    }

    public void setNomeBattelloPrenotato(String nomeBattelloPrenotato) {
        this.nomeBattelloPrenotato = nomeBattelloPrenotato;
    }

    public void creaPrenotazione(Scanner scanner) {
        System.out.println("Inserisci il nome del passeggero");
        this.nome = scanner.nextLine();

        System.out.println("Inserisci il cognome del passeggero");
        this.cognome = scanner.nextLine();

        System.out.println("Inserisci il codice fiscale del passeggero");
        this.codiceFiscale = scanner.nextLine();

        System.out.println("La prenotazione è stata effettuata \n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Objects.equals(nome, that.nome) && Objects.equals(cognome, that.cognome) && Objects.equals(codiceFiscale, that.codiceFiscale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, codiceFiscale);
    }

    @Override
    public String toString() {
        return "Nome = " + nome + "\n" +
                "Cognome = " + cognome + "\n" +
                "Codice fiscale = " + codiceFiscale + "\n";
    }
}
