package be.vdab.util;

import be.vdab.exception.DatumException;

import java.util.Objects;

/**
 * @author beou on 3/12/19 16:31
 */
public class Datum implements IDatum, Comparable<Datum> {
    private final static int MIN_YEAR = 1584;
    private final static int MAX_YEAR = 4099;

    private int dag;
    private int maand;
    private int jaar;

    public Datum(int dag, int maand, int jaar) throws DatumException {
        if (!isValid(dag, maand, jaar)) throw new DatumException("Invalid date");

        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }

    @Override
    public int getDag() {
        return dag;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }

    //--
    public static boolean isValid(int dag, int maand, int jaar) {
        if (jaar < MIN_YEAR || jaar > MAX_YEAR) {
            return false;
        }

        if (maand < 1 || maand > 12) {
            return false;
        }

        switch (maand) {
            case 1: return true;
            case 2: return (isLeap(jaar) ? dag <= 29 : dag <= 28);
            case 3: return true;
            case 4: return dag <= 30;
            case 5: return true;
            case 6: return dag <= 30;
            case 7: return true;
            case 8: return true;
            case 9: return dag <= 30;
            case 10: return true;
            case 11: return dag <= 30;
            default: return true;
        }
    }

    public static boolean isLeap(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int compareTo(Datum datum) {
        int dag1 = datum.getDag();
        int maand1 = datum.getMaand();
        int jaar = datum.getJaar();

        if (this.jaar < jaar) {
            return -1;
        } else if (this.jaar > jaar) {
            return 1;
        } else {
            // same year
            if (this.maand < maand1) {
                return -1;
            } else if (this.maand > maand1) {
                return 1;
            } else {
                // same month
                if (this.dag < dag1) {
                    return -1;
                } else if (this.dag > dag1) {
                    return 1;
                } else {
                    //same day
                    return 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        String leapYear = "(not a leap year)";
        if (isLeap(this.jaar)) {
            leapYear = "(a leap year)";
        }

        return String.format("%d/%d/%d %s", this.dag, this.maand, this.jaar, leapYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datum datum = (Datum) o;
        return dag == datum.dag &&
                maand == datum.maand &&
                jaar == datum.jaar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dag, maand, jaar);
    }
}
