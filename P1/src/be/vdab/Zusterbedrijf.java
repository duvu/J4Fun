package be.vdab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author beou on 3/12/19 19:00
 */
public class Zusterbedrijf {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("personnel.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String sLine = null;
            while ((sLine = bufferedReader.readLine()) != null) {
                System.out.println(String.format("data: %s", sLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
