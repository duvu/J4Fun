package be.vdab.personeel;

import be.vdab.exception.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

/**
 * @author beou on 3/12/19 17:51
 */
public class Arbeider extends Werknemer {
    private static final BigDecimal MINIMUM_WAGE = BigDecimal.valueOf(9.76);

    BigDecimal hourlyWage;

    public Arbeider(int personeelsnummer, String naam, Gelacht geslach, WerknemersDatum datumInDienst, BigDecimal hourlyWage) throws WerknemerException {
        super(personeelsnummer, naam, geslach, datumInDienst);
        if (hourlyWage.compareTo(MINIMUM_WAGE) < 0) throw new WerknemerException("Hourly wage must be above the MINIMUM");
        this.hourlyWage = hourlyWage;
    }

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(BigDecimal hourlyWage) {
        if (hourlyWage.compareTo(MINIMUM_WAGE) < 0) throw new WerknemerException("Hourly wage must be above the MINIMUM");
        this.hourlyWage = hourlyWage;
    }

    @Override
    public BigDecimal getVerloning() {
        return hourlyWage.multiply(BigDecimal.valueOf(7.6).multiply(BigDecimal.valueOf(65))).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_HALF_UP) ;
    }
}
