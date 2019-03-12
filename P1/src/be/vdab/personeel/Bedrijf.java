package be.vdab.personeel;

import be.vdab.personeel.kader.Kaderlid;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author beou on 3/12/19 18:03
 */
public class Bedrijf {
    List<Werknemer> bedrijfslist;

    public Bedrijf() {
        this.bedrijfslist = new ArrayList<>();
    }

    public void voegWerknemerToe(Werknemer werk) {
        if (!bedrijfslist.contains(werk)) {
            bedrijfslist.add(werk);
        }
    }

    public List<Werknemer> gesorteertdeList () {
        List<Werknemer> sortedList = new ArrayList<>(bedrijfslist);
        Collections.sort(sortedList);
        return sortedList;
    }

    public List<Werknemer> gesorteertdeLijstOpNaam() {
        List<Werknemer> sortedList = new ArrayList<>(bedrijfslist);
        Collections.sort(sortedList, Werknemer.sorteerOpNaam());
        return sortedList;
    }

    public List<Werknemer> lijstVanArbeiders () {
        return bedrijfslist;
    }

    public double percentageMannelijkeWerknemers() {
        if (bedrijfslist != null && bedrijfslist.size() > 0) {
            List<Werknemer> maleList = bedrijfslist.stream().filter(werknemer -> werknemer.getGeslacht() == Gelacht.M).collect(Collectors.toList());
            return (double)maleList.size() / (double)bedrijfslist.size();
        } else {
            return 0.0;
        }
    }

    public List<Werknemer> lijstVanManagers() {
        if (bedrijfslist != null && bedrijfslist.size() > 0) {
            return bedrijfslist.stream().filter(werknemer -> werknemer instanceof Kaderlid).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public static void printLijst(List<Werknemer> werknemerList) {
        if (werknemerList != null && werknemerList.size() > 0) {
            werknemerList.forEach(werk -> {
                System.out.println(werk);
            });
        }
    }

    public void exportList() {
        try {
            FileWriter fileWriter = new FileWriter("personnel.dat");
            BufferedWriter out = new BufferedWriter(fileWriter);

            if (bedrijfslist != null && bedrijfslist.size() > 0 ) {
                for (Werknemer werk : bedrijfslist) {
                    out.write(werk.toString());
                    out.write("\n");
                }
            }

            out.close();

        } catch (IOException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
    }
}
