/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marko
 */
public class Usluga implements ApstraktniDomenskiObjekat{
    private int idUsluge;
    private String naziv;
    private String tipUsluge;
    private double cena;

     public Usluga() {
    }

    public Usluga(int idUsluge, String naziv, String tipUsluge, double cena) {
        this.idUsluge = idUsluge;
        this.naziv = naziv;
        this.tipUsluge = tipUsluge;
        this.cena = cena;
    }

    public int getIdUsluge() {
        return idUsluge;
    }

    public void setIdUsluge(int idUsluge) {
        this.idUsluge = idUsluge;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTipUsluge() {
        return tipUsluge;
    }

    public void setTipUsluge(String tipUsluge) {
        this.tipUsluge = tipUsluge;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv + " (" + tipUsluge + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsluge);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usluga other = (Usluga) obj;
        return idUsluge == other.idUsluge;
    }

    @Override
    public String vratiNazivTabele() {
        return "usluga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("idUsluge");
            String naziv = rs.getString("naziv");
            String tip = rs.getString("tipUsluge");
            double cena = rs.getDouble("cena");
            Usluga u = new Usluga(id, naziv, tip, cena);
            lista.add(u);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, tipUsluge, cena";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', '" + tipUsluge + "', " + cena;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "usluga.idUsluge=" + idUsluge;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("idUsluge");
            String naziv = rs.getString("naziv");
            String tip = rs.getString("tipUsluge");
            double cena = rs.getDouble("cena");
            return new Usluga(id, naziv, tip, cena);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', tipUsluge='" + tipUsluge + "', cena=" + cena;
    }
   
    
}
