package be.vdab.util;

import be.vdab.exception.DatumException;

/**
 * @author beou on 3/12/19 17:20
 */
public class WerknemersDatum extends Datum {
    private final Datum COMPANY_FOUNDED_DATE = new Datum(12, 2, 1977);
    public WerknemersDatum(int dag, int maand, int jaar) throws DatumException {
        super(dag, maand, jaar);
    }

    public boolean isValid() {
        return Datum.isValid(getDag(), getMaand(), getJaar()) && (compareTo(COMPANY_FOUNDED_DATE) >= 0);
    }
}
