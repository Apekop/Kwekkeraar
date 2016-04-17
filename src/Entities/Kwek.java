package Entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by bram_ on 14-4-2016.
 */
@Entity
public class Kwek {
    private int id;
    private int afzender;
    private String boodschap;
    private Timestamp moment;
    private Integer dmOntvanger;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "afzender")
    public int getAfzender() {
        return afzender;
    }

    public void setAfzender(int afzender) {
        this.afzender = afzender;
    }

    @Basic
    @Column(name = "boodschap")
    public String getBoodschap() {
        return boodschap;
    }

    public void setBoodschap(String boodschap) {
        this.boodschap = boodschap;
    }

    @Basic
    @Column(name = "moment")
    public Timestamp getMoment() {
        return moment;
    }

    public void setMoment(Timestamp moment) {
        this.moment = moment;
    }

    @Basic
    @Column(name = "dm_ontvanger")
    public Integer getDmOntvanger() {
        return dmOntvanger;
    }

    public void setDmOntvanger(Integer dmOntvanger) {
        this.dmOntvanger = dmOntvanger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kwek kwek = (Kwek) o;

        if (id != kwek.id) return false;
        if (afzender != kwek.afzender) return false;
        if (boodschap != null ? !boodschap.equals(kwek.boodschap) : kwek.boodschap != null) return false;
        if (moment != null ? !moment.equals(kwek.moment) : kwek.moment != null) return false;
        if (dmOntvanger != null ? !dmOntvanger.equals(kwek.dmOntvanger) : kwek.dmOntvanger != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + afzender;
        result = 31 * result + (boodschap != null ? boodschap.hashCode() : 0);
        result = 31 * result + (moment != null ? moment.hashCode() : 0);
        result = 31 * result + (dmOntvanger != null ? dmOntvanger.hashCode() : 0);
        return result;
    }
}
