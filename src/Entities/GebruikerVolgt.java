package Entities;

import javax.persistence.*;

/**
 * Created by bram_ on 14-4-2016.
 */
@Entity
@Table(name = "gebruiker_volgt", schema = "kwekkeraar", catalog = "")
@IdClass(GebruikerVolgtPK.class)
public class GebruikerVolgt {
    private int gebruiker;
    private int volgtGebruiker;

    @Id
    @Column(name = "gebruiker")
    public int getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(int gebruiker) {
        this.gebruiker = gebruiker;
    }

    @Id
    @Column(name = "volgt_gebruiker")
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

        GebruikerVolgt that = (GebruikerVolgt) o;

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
