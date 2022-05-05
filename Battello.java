package com.irimie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Battello {

    private String nomeBattello;
    private int posti;
    private Date data;
    private String ora;


    public Battello(String nomeBattello, int posti, Date data, String ora) {
        this.nomeBattello = nomeBattello;
        this.posti = posti;
        this.data = data;
        this.ora = ora;
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

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }


    public static Battello creaBattello(Scanner scanner) throws ParseException {
        Battello battello = new Battello();
        System.out.println("Inserisci il nome del battello");
        battello.nomeBattello = scanner.nextLine();

        System.out.println("Inserisci i posti massimi del battello");
        battello.posti = scanner.nextInt();

        System.out.println("Inserisci data di partenza nel formato dd/MM/yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        battello.data = formatter.parse(scanner.nextLine());

        System.out.println("Inserisci l'ora di partenza");
        battello.ora = scanner.nextLine();
        scanner.nextLine();
        return battello;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battello battello = (Battello) o;
        return nomeBattello == battello.nomeBattello &&
                posti == battello.posti &&
                Objects.equals(data, battello.data) &&
                Objects.equals(ora, battello.ora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeBattello, posti, data, ora);
    }

    @Override
    public String toString() {
        return "Battello{" +
                "nomeBattello=" + nomeBattello +
                ", posti=" + posti +
                ", data=" + data +
                ", ora='" + ora + '\'' +
                '}';
    }

}
