/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marko
 */
public class KvalifikacijaPreduzetnika implements ApstraktniDomenskiObjekat{
    private LocalDate datumIzdavanja;
    private Preduzetnik preduzetnik;
    private Kvalifikacija kvalifikacija;

   public KvalifikacijaPreduzetnika() {
    }

    public KvalifikacijaPreduzetnika(LocalDate datumIzdavanja, Preduzetnik preduzetnik, Kvalifikacija kvalifikacija) {
        this.datumIzdavanja = datumIzdavanja;
        this.preduzetnik = preduzetnik;
        this.kvalifikacija = kvalifikacija;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Preduzetnik getPreduzetnik() {
        return preduzetnik;
    }

    public void setPreduzetnik(Preduzetnik preduzetnik) {
        this.preduzetnik = preduzetnik;
    }

    public Kvalifikacija getKvalifikacija() {
        return kvalifikacija;
    }

    public void setKvalifikacija(Kvalifikacija kvalifikacija) {
        this.kvalifikacija = kvalifikacija;
    }

    @Override
    public int hashCode() {
        return Objects.hash(datumIzdavanja, preduzetnik, kvalifikacija);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        KvalifikacijaPreduzetnika other = (KvalifikacijaPreduzetnika) obj;
        return Objects.equals(datumIzdavanja, other.datumIzdavanja)
                && Objects.equals(preduzetnik, other.preduzetnik)
                && Objects.equals(kvalifikacija, other.kvalifikacija);
    }

    @Override
    public String toString() {
        return "IzdavanjeSertifikata{" + "datumIzdavanja=" + datumIzdavanja + ", preduzetnik=" + preduzetnik + ", kvalifikacija=" + kvalifikacija + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "izdavanjesertifikata";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new LinkedList<>();
        while (rs.next()) {
            LocalDate datum = rs.getDate("datumIzdavanja").toLocalDate();
            int idPreduzetnika = rs.getInt("idPreduzetnika");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            int pib = rs.getInt("pib");
            String sifra = rs.getString("sifra");
            Preduzetnik p = new Preduzetnik(idPreduzetnika, ime, prezime, pib, sifra);

            int idKvalifikacije = rs.getInt("idKvalifikacije");
            String naziv = rs.getString("naziv");
            String institucija = rs.getString("institucija");
            Kvalifikacija k = new Kvalifikacija(idKvalifikacije, naziv, institucija);

            KvalifikacijaPreduzetnika is = new KvalifikacijaPreduzetnika(datum, p, k);
            lista.add(is);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumIzdavanja, idPreduzetnika, idKvalifikacije";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + datumIzdavanja + "', " + preduzetnik.getIdPreduzetnika() + ", " + kvalifikacija.getIdKvalifikacije();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "datumIzdavanja='" + datumIzdavanja + "' AND idPreduzetnika=" + preduzetnik.getIdPreduzetnika() + " AND idKvalifikacije=" + kvalifikacija.getIdKvalifikacije();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            LocalDate datum = rs.getDate("datumIzdavanja").toLocalDate();
            Preduzetnik p = new Preduzetnik(
                rs.getInt("idPreduzetnika"),
                rs.getString("ime"),
                rs.getString("prezime"),
                rs.getInt("pib"),
                rs.getString("sifra")
            );
            Kvalifikacija k = new Kvalifikacija(
                rs.getInt("idKvalifikacije"),
                rs.getString("naziv"),
                rs.getString("institucija")
            );
            return new KvalifikacijaPreduzetnika(datum, p, k);
        }
        return null;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "datumIzdavanja='" + datumIzdavanja + "', idPreduzetnika=" + preduzetnik.getIdPreduzetnika() + ", idKvalifikacije=" + kvalifikacija.getIdKvalifikacije();
    }
}
