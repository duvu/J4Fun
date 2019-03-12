package be.vdab;

import be.vdab.personeel.*;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

/**
 * @author beou on 3/12/19 18:27
 */
public class BedrijfApp {
    public static void main(String[] args) {
        Bedrijf bedrijf = new Bedrijf();

        Werknemer w1 = new Arbeider(1, "Werknemer 1", Gelacht.M, new WerknemersDatum(17, 3, 2019), BigDecimal.TEN);
        Werknemer w2 = new Arbeider(2, "Werknemer 2", Gelacht.M, new WerknemersDatum(17, 3, 2019), BigDecimal.TEN);
        Werknemer w3 = new Arbeider(4, "Werknemer 3", Gelacht.V, new WerknemersDatum(17, 3, 2019), BigDecimal.TEN);
        Werknemer w4 = new Arbeider(4, "Werknemer 4", Gelacht.V, new WerknemersDatum(17, 3, 2019), BigDecimal.TEN);
        Werknemer w5 = new Arbeider(5, "Werknemer 5", Gelacht.V, new WerknemersDatum(17, 3, 2019), BigDecimal.TEN);
        Werknemer w6 = new Arbeider(6, "Arbeider 6", Gelacht.M, new WerknemersDatum(17, 3, 2019), BigDecimal.TEN);
        Werknemer w7 = new Arbeider(7, "Arbeider 7", Gelacht.M, new WerknemersDatum(18, 3, 2019), BigDecimal.valueOf(100));
        Werknemer w8 = new Bediende(8, "Bediende", Gelacht.M, new WerknemersDatum(18, 3, 2019), BigDecimal.valueOf(4906));
        Werknemer w9 = new Bediende(9, "Bediende 9", Gelacht.M, new WerknemersDatum(18, 3, 2019), BigDecimal.valueOf(5000));
        Werknemer w10 = new Kaderlid(10, "Bediende 9", Gelacht.M, new WerknemersDatum(18, 3, 2019), BigDecimal.valueOf(5000), Kaderlid.JobTitle.CEO);
        Werknemer w11 = new Kaderlid(11, "Bediende 9", Gelacht.M, new WerknemersDatum(18, 3, 2019), BigDecimal.valueOf(5000), Kaderlid.JobTitle.DIRECTEUR);
        Werknemer w12 = new Kaderlid(12, "Bediende 9", Gelacht.M, new WerknemersDatum(18, 3, 2019), BigDecimal.valueOf(5000), Kaderlid.JobTitle.MANAGER);

        bedrijf.voegWerknemerToe(w1);
        bedrijf.voegWerknemerToe(w2);
        bedrijf.voegWerknemerToe(w3);
        bedrijf.voegWerknemerToe(w4);
        bedrijf.voegWerknemerToe(w5);
        bedrijf.voegWerknemerToe(w6);
        bedrijf.voegWerknemerToe(w7);
        bedrijf.voegWerknemerToe(w8);
        bedrijf.voegWerknemerToe(w9);
        bedrijf.voegWerknemerToe(w10);
        bedrijf.voegWerknemerToe(w11);
        bedrijf.voegWerknemerToe(w12);

        System.out.println("gesorteertdeList() --> ");
        Bedrijf.printLijst(bedrijf.gesorteertdeList());

        System.out.println("gesorteertdeLijstOpNaam() --> ");
        Bedrijf.printLijst(bedrijf.gesorteertdeLijstOpNaam());

        System.out.println("lijstVanArbeiders() --> ");
        Bedrijf.printLijst(bedrijf.lijstVanArbeiders());

        System.out.print("percentageMannelijkeWerknemers() --> ");
        System.out.println(bedrijf.percentageMannelijkeWerknemers());

        System.out.println("lijstVanManagers() --> ");
        Bedrijf.printLijst(bedrijf.lijstVanManagers());

        bedrijf.exportList();

    }
}
