package be.vdab.personeel;

import be.vdab.exception.WerknemerException;
import be.vdab.util.Datum;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author beou on 3/12/19 17:16
 */
public abstract class Werknemer implements Comparable<Werknemer> {
    private final int personeelsnummer; //employee number/ID

    private WerknemersDatum datumInDienst;
    private String naam;
    private Gelacht geslacht;

    public Werknemer(int personeelsnummer, String name) throws WerknemerException {
        if (personeelsnummer <= 0) throw new WerknemerException("Invalid data");
        this.personeelsnummer = personeelsnummer;
        this.naam = name;
    }

    public Werknemer(int personeelsnummer, String name, WerknemersDatum datumInDienst) {
        if (!datumInDienst.isValid() || personeelsnummer <= 0) throw new WerknemerException("Invalid data");
        this.personeelsnummer = personeelsnummer;
        this.naam = name;
        this.datumInDienst = datumInDienst;
    }

    public Werknemer(int personeelsnummer, String naam, Gelacht geslach, WerknemersDatum datumInDienst) throws WerknemerException {
        if (!datumInDienst.isValid() || personeelsnummer <= 0) throw new WerknemerException("Invalid data");

        this.personeelsnummer = personeelsnummer;
        this.naam = naam;
        this.geslacht = geslach;
        this.datumInDienst = datumInDienst;
    }

    public int getPersoneelsnummer() {
        return personeelsnummer;
    }

    public WerknemersDatum getDatumInDienst() {
        return datumInDienst;
    }

    public void setDatumInDienst(WerknemersDatum datumInDienst) {
        this.datumInDienst = datumInDienst;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Gelacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Gelacht geslacht) {
        this.geslacht = geslacht;
    }

    @Override
    public int compareTo(Werknemer o) {
        return Integer.compare(this.personeelsnummer, o.getPersoneelsnummer());
    }

    public static Comparator<Werknemer> sorteerOpNaam() {
        return (o1, o2) -> o1.getNaam().compareTo(o2.getNaam());
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\t%s\t%s\t%s", personeelsnummer, datumInDienst, naam, geslacht, getVerloning().toPlainString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Werknemer werknemer = (Werknemer) o;
        return personeelsnummer == werknemer.personeelsnummer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personeelsnummer);
    }

    public abstract BigDecimal getVerloning();
}
