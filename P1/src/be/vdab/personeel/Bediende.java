package be.vdab.personeel;

import be.vdab.exception.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

/**
 * @author beou on 3/12/19 17:57
 */
public class Bediende extends Werknemer {
    private final BigDecimal MINIMUM_MONTHY_WAGE = BigDecimal.valueOf(1129.47);

    private BigDecimal maandwedde;

    public Bediende(int personeelsnummer, String naam, Gelacht geslach, WerknemersDatum datumInDienst, BigDecimal maandwedde) throws WerknemerException {
        super(personeelsnummer, naam, geslach, datumInDienst);
        if (maandwedde.compareTo(MINIMUM_MONTHY_WAGE) < 0) throw new WerknemerException("Monthy wage must be greater than the MINIMUM");
        this.maandwedde = maandwedde;
    }

    public BigDecimal getMaandwedde() {
        return maandwedde;
    }

    public void setMaandwedde(BigDecimal maandwedde) {
        this.maandwedde = maandwedde;
    }

    @Override
    public BigDecimal getVerloning() {
        return maandwedde;
    }
}
