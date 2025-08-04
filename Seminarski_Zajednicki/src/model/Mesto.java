/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Marko
 */
public class Mesto implements ApstraktniDomenskiObjekat{
    private int idMesta;
    private String naziv;
    private int brojStanovnika;

  public Mesto() {
    }

    public Mesto(int idMesta, String naziv, int brojStanovnika) {
        this.idMesta = idMesta;
        this.naziv = naziv;
        this.brojStanovnika = brojStanovnika;
    }

    public int getIdMesta() {
        return idMesta;
    }

    public void setIdMesta(int idMesta) {
        this.idMesta = idMesta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMesta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mesto other = (Mesto) obj;
        return idMesta == other.idMesta;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("mesto.idMesta");
            String naziv = rs.getString("mesto.naziv");
            int brojStanovnika = rs.getInt("mesto.brojStanovnika");
            Mesto m = new Mesto(id, naziv, brojStanovnika);
            lista.add(m);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,brojStanovnika";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "'," + brojStanovnika;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "mesto.idMesta=" + idMesta;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("idMesta");
            String naziv = rs.getString("naziv");
            int brojStanovnika = rs.getInt("brojStanovnika");
            return new Mesto(id, naziv, brojStanovnika);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', brojStanovnika=" + brojStanovnika;
    }
}
