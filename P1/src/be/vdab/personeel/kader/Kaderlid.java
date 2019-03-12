package be.vdab.personeel.kader;

import be.vdab.exception.WerknemerException;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Gelacht;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

/**
 * @author beou on 3/12/19 18:00
 */

public class Kaderlid extends Bediende {
    private JobTitle jobTitle;

    public Kaderlid(int personeelsnummer, String naam, Gelacht geslach, WerknemersDatum datumInDienst, BigDecimal maandwedde, JobTitle jobTitle) throws WerknemerException {
        super(personeelsnummer, naam, geslach, datumInDienst, maandwedde);
        this.jobTitle = jobTitle;
    }

    public static enum JobTitle {
        DIRECTEUR, CEO, MANAGER
    }



}
