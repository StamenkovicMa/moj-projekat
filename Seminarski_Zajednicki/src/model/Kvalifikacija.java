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
public class Kvalifikacija implements ApstraktniDomenskiObjekat{
    private int idKvalifikacije;
    private String naziv;
    private String institucija;
    public Kvalifikacija() {
    }

    public Kvalifikacija(int idKvalifikacije, String naziv, String institucija) {
        this.idKvalifikacije = idKvalifikacije;
        this.naziv = naziv;
        this.institucija = institucija;
    }

    public int getIdKvalifikacije() {
        return idKvalifikacije;
    }

    public void setIdKvalifikacije(int idKvalifikacije) {
        this.idKvalifikacije = idKvalifikacije;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getInstitucija() {
        return institucija;
    }

    public void setInstitucija(String institucija) {
        this.institucija = institucija;
    }

    @Override
    public String toString() {
        return naziv + " (" + institucija + ")";
    }

    @Override
    public String vratiNazivTabele() {
        return "kvalifikacija";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("kvalifikacija.idKvalifikacije");
            String naziv = rs.getString("kvalifikacija.naziv");
            String institucija = rs.getString("kvalifikacija.institucija");
            Kvalifikacija k = new Kvalifikacija(id, naziv, institucija);
            lista.add(k);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,institucija";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "','" + institucija + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "kvalifikacija.idKvalifikacije=" + idKvalifikacije;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("idKvalifikacije");
            String naziv = rs.getString("naziv");
            String institucija = rs.getString("institucija");
            return new Kvalifikacija(id, naziv, institucija);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', institucija='" + institucija + "'";
    }
    
}
