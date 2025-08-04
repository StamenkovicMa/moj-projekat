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
public class StavkaRacuna implements ApstraktniDomenskiObjekat{
    private int sr;
    private Racun racun ;
    private double ukupnaCena;
    private double jedinicnaCena;
    private Usluga usluga;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int sr, Racun racun, double ukupnaCena, double jedinicnaCena, Usluga usluga) {
        this.sr = sr;
        this.racun = racun;
        this.ukupnaCena = ukupnaCena;
        this.jedinicnaCena = jedinicnaCena;
        this.usluga = usluga;
    }

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public double getJedinicnaCena() {
        return jedinicnaCena;
    }

    public void setJedinicnaCena(double jedinicnaCena) {
        this.jedinicnaCena = jedinicnaCena;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    // equals, hashCode, toString...

    @Override
    public String vratiNazivTabele() {
        return "stavkaracuna";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "sr, racun, ukupnaCena, jedinicnaCena, usluga";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return sr + ", " + racun.getIdRacuna() + ", " + ukupnaCena + ", " + jedinicnaCena + ", " + usluga.getIdUsluge();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavkaracuna.sr=" + sr + " AND stavkaracuna.racun=" + racun.getIdRacuna();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ukupnaCena=" + ukupnaCena + ", jedinicnaCena=" + jedinicnaCena + ", usluga=" + usluga.getIdUsluge();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new LinkedList<>();
        while (rs.next()) {
            int sr = rs.getInt("sr");
            int idRacuna = rs.getInt("racun");
            double ukupnaCena = rs.getDouble("ukupnaCena");
            double jedinicnaCena = rs.getDouble("jedinicnaCena");
            int idUsluge = rs.getInt("usluga");

            Racun r = new Racun(); r.setIdRacuna(idRacuna);
            Usluga u = new Usluga(); u.setIdUsluge(idUsluge);

            StavkaRacuna s = new StavkaRacuna(sr, r, ukupnaCena, jedinicnaCena, u);
            lista.add(s);
        }
        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int sr = rs.getInt("sr");
            int idRacuna = rs.getInt("racun");
            double ukupnaCena = rs.getDouble("ukupnaCena");
            double jedinicnaCena = rs.getDouble("jedinicnaCena");
            int idUsluge = rs.getInt("usluga");

            Racun r = new Racun(); r.setIdRacuna(idRacuna);
            Usluga u = new Usluga(); u.setIdUsluge(idUsluge);

            return new StavkaRacuna(sr, r, ukupnaCena, jedinicnaCena, u);
        }
        return null;
    }
    
}
