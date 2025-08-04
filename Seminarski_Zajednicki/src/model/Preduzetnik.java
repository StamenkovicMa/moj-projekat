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
public class Preduzetnik implements ApstraktniDomenskiObjekat{
    private int idPreduzetnika;
    private String ime;
    private String prezime;
    private int pib;
    private String sifra;
     public Preduzetnik() {
    }

    public Preduzetnik(int idPreduzetnika, String ime, String prezime, int pib, String sifra) {
        this.idPreduzetnika = idPreduzetnika;
        this.ime = ime;
        this.prezime = prezime;
        this.pib = pib;
        this.sifra = sifra;
    }

    public int getIdPreduzetnika() {
        return idPreduzetnika;
    }

    public void setIdPreduzetnika(int idPreduzetnika) {
        this.idPreduzetnika = idPreduzetnika;
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

    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "preduzetnik"; // ime tabele u bazi
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new LinkedList<>();
        while (rs.next()) {
            int idPreduzetnika1 = rs.getInt("preduzetnik.idPreduzetnika");
            String ime1 = rs.getString("preduzetnik.ime");
            String prezime1 = rs.getString("preduzetnik.prezime");
            int pib1 = rs.getInt("preduzetnik.pib");
            String sifra1 = rs.getString("preduzetnik.sifra");
            Preduzetnik p = new Preduzetnik(idPreduzetnika1, ime1, prezime1, pib1, sifra1);
            lista.add(p);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,pib,sifra";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "','" + prezime + "'," + pib + ",'" + sifra + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "preduzetnik.idPreduzetnika=" + idPreduzetnika;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("idPreduzetnika");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            int pib = rs.getInt("pib");
            String sifra = rs.getString("sifra");
            return new Preduzetnik(id, ime, prezime, pib, sifra);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime + "', prezime='" + prezime + "', pib=" + pib + ", sifra='" + sifra + "'";
    }
   
   
}
