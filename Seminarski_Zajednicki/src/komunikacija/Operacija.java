/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class Operacija implements Serializable{
    
    public static final int LOGIN=1;
    public static final int UCITAJ_UGOVORE=2;
    public static final int UCITAJ_KLIJENTE=3;
    public static final int UCITAJ_AUTOMOBILE=4;
    public static final int UCITAJ_DISPECERE=5;
    public static final int PRETRAZI_UGOVORE_PO_KRITERIJUMU=6;
    public static final int OBRISI_UGOVOR=7;
    public static final int UCITAJ_LICNADOK=8;
    public static final int PRETRAZI_KLIJENTE_PO_KRITERIJUMU=9;
    public static final int PRETRAZI_AUTOMOBILE_PO_KRITERIJUMU=10;
    public static final int KREIRAJ_AUTOMOBIL=11;
    public static final int KREIRAJ_KLIJENTA=12;
    public static final int KREIRAJ_LICNIDOK=13;
    public static final int KREIRAJ_UGOVOR=14;
    
}
