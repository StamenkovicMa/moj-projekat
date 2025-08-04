/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Marko
 */
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
public class Klijent implements ApstraktniDomenskiObjekat{
    private int idKlijenta;
    private String ime;
    private String prezime;
    private Mesto mesto;
   public Klijent() {
    }

    public Klijent(int idKlijenta, String ime, String prezime, Mesto mesto) {
        this.idKlijenta = idKlijenta;
        this.ime = ime;
        this.prezime = prezime;
        this.mesto = mesto;
    }

    public int getIdKlijenta() {
        return idKlijenta;
    }

    public void setIdKlijenta(int idKlijenta) {
        this.idKlijenta = idKlijenta;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " (" + mesto.getNaziv() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Klijent other = (Klijent) obj;
        return idKlijenta == other.idKlijenta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKlijenta);
    }

    @Override
    public String vratiNazivTabele() {
        return "klijent";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("klijent.idKlijenta");
            String ime = rs.getString("klijent.ime");
            String prezime = rs.getString("klijent.prezime");

            int idMesta = rs.getInt("klijent.idMesta");
            String nazivMesta = rs.getString("mesto.naziv"); // ako radiš JOIN
            int brojStanovnika = rs.getInt("mesto.brojStanovnika");

            Mesto mesto = new Mesto(idMesta, nazivMesta, brojStanovnika);
            Klijent k = new Klijent(id, ime, prezime, mesto);
            lista.add(k);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,idMesta";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "','" + prezime + "'," + mesto.getIdMesta();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "klijent.idKlijenta=" + idKlijenta;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("idKlijenta");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");

            int idMesta = rs.getInt("idMesta");
            String naziv = rs.getString("naziv");
            int brojStanovnika = rs.getInt("brojStanovnika");

            Mesto mesto = new Mesto(idMesta, naziv, brojStanovnika);
            return new Klijent(id, ime, prezime, mesto);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime + "', prezime='" + prezime + "', idMesta=" + mesto.getIdMesta();
    }

    
}
