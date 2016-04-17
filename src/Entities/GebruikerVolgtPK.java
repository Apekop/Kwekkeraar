package Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by bram_ on 14-4-2016.
 */
public class GebruikerVolgtPK implements Serializable {
    private int gebruiker;
    private int volgtGebruiker;

    @Column(name = "gebruiker")
    @Id
    public int getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(int gebruiker) {
        this.gebruiker = gebruiker;
    }

    @Column(name = "volgt_gebruiker")
    @Id
    public int getVolgtGebruiker() {
        return volgtGebruiker;
    }

    public void setVolgtGebruiker(int volgtGebruiker) {
        this.volgtGebruiker = volgtGebruiker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GebruikerVolgtPK that = (GebruikerVolgtPK) o;

        if (gebruiker != that.gebruiker) return false;
        if (volgtGebruiker != that.volgtGebruiker) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gebruiker;
        result = 31 * result + volgtGebruiker;
        return result;
    }
}
