package be.vdab;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Gelacht;
import be.vdab.personeel.Werknemer;
import be.vdab.util.Datum;
import be.vdab.exception.DatumException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

/**
 * @author beou on 3/12/19 17:06
 */
public class DatumTest {
    public static void main(String[] args) {
        Datum datum1 = new Datum(20, 12, 2000);
        Datum datum2 = new Datum(31, 12, 4099);
        Datum datum3 = new Datum(1, 1, 1584);

        System.out.println(datum1.toString());
        System.out.println(datum2.toString());
        System.out.println(datum3.toString());

        try {
            Datum datum4 = new Datum(1, 1, 4100);
        } catch (DatumException de) {
            //
            System.out.println(String.format("Exception: %s", de.getMessage()));
        }

        WerknemersDatum datum5 = new WerknemersDatum(21, 11, 2000);
        Werknemer w = new Arbeider(1, "name", Gelacht.M, datum5, BigDecimal.valueOf(30));
        System.out.println(String.format("Werknemer: %s", w));
    }
}
