/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marko
 */
public class Racun implements ApstraktniDomenskiObjekat{
    private int idRacuna;
    private LocalDate datum;
    private int brojKase;
    private Double ukupanIznos;
    private Klijent klijent;
    private Preduzetnik preduzetnik;
    
     public Racun() {
    }

    public Racun(int idRacuna, LocalDate datum, int brojKase, Double ukupanIznos, Klijent klijent, Preduzetnik preduzetnik) {
        this.idRacuna = idRacuna;
        this.datum = datum;
        this.brojKase = brojKase;
        this.ukupanIznos = ukupanIznos;
        this.klijent = klijent;
        this.preduzetnik = preduzetnik;
    }

    public int getIdRacuna() {
        return idRacuna;
    }

    public void setIdRacuna(int idRacuna) {
        this.idRacuna = idRacuna;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getBrojKase() {
        return brojKase;
    }

    public void setBrojKase(int brojKase) {
        this.brojKase = brojKase;
    }

    public Double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(Double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Preduzetnik getPreduzetnik() {
        return preduzetnik;
    }

    public void setPreduzetnik(Preduzetnik preduzetnik) {
        this.preduzetnik = preduzetnik;
    }

    @Override
    public String toString() {
        return "Račun br. " + idRacuna + ", datum: " + datum + ", ukupan iznos: " + ukupanIznos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Racun other = (Racun) obj;
        return idRacuna == other.idRacuna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRacuna);
    }

    @Override
    public String vratiNazivTabele() {
        return "racun";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datum,brojKase,ukupanIznos,klijent,preduzetnik";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + datum + "', " + brojKase + ", " + ukupanIznos + ", " + klijent.getIdKlijenta() + ", " + preduzetnik.getIdPreduzetnika();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "racun.idRacuna=" + idRacuna;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "datum='" + datum + "', brojKase=" + brojKase + ", ukupanIznos=" + ukupanIznos
                + ", klijent=" + klijent.getIdKlijenta() + ", preduzetnik=" + preduzetnik.getIdPreduzetnika();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("idRacuna");
            LocalDate datum = rs.getDate("datum").toLocalDate();
            int brojKase = rs.getInt("brojKase");
            Double ukupan = rs.getDouble("ukupanIznos");

            // Klijent
            int idKlijenta = rs.getInt("klijent");
            Klijent k = new Klijent();
            k.setIdKlijenta(idKlijenta);

            // Preduzetnik
            int idPred = rs.getInt("preduzetnik");
            Preduzetnik p = new Preduzetnik();
            p.setIdPreduzetnika(idPred);

            Racun racun = new Racun(id, datum, brojKase, ukupan, k, p);
            lista.add(racun);
        }
        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("idRacuna");
            LocalDate datum = rs.getDate("datum").toLocalDate();
            int brojKase = rs.getInt("brojKase");
            double ukupan = rs.getDouble("ukupanIznos");

            Klijent k = new Klijent();
            k.setIdKlijenta(rs.getInt("klijent"));

            Preduzetnik p = new Preduzetnik();
            p.setIdPreduzetnika(rs.getInt("preduzetnik"));

            return new Racun(id, datum, brojKase, ukupan, k, p);
        }
        return null;
    }
}
