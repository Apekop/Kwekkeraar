package Entities;

import Util.KwekCrud;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bram_ on 14-4-2016.
 */
@Entity
public class Gebruiker {
    private int id;
    private String gebruikersnaam;
    private String wachtwoord;
    private String privilege;
    private boolean geblokkeerd;
    //private List<Kwek> kweks = new ArrayList<>();

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gebruikersnaam")
    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    @Basic
    @Column(name = "wachtwoord")
    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    @Basic
    @Column(name = "privilege")
    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Basic
    @Column(name = "geblokkeerd")
    public boolean isGeblokkeerd() {
        return geblokkeerd;
    }

    public void setGeblokkeerd(boolean geblokkeerd) {
        this.geblokkeerd = geblokkeerd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gebruiker gebruiker = (Gebruiker) o;

        if (id != gebruiker.id) return false;
        if (geblokkeerd != gebruiker.geblokkeerd) return false;
        if (gebruikersnaam != null ? !gebruikersnaam.equals(gebruiker.gebruikersnaam) : gebruiker.gebruikersnaam != null)
            return false;
        if (wachtwoord != null ? !wachtwoord.equals(gebruiker.wachtwoord) : gebruiker.wachtwoord != null) return false;
        if (privilege != null ? !privilege.equals(gebruiker.privilege) : gebruiker.privilege != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (gebruikersnaam != null ? gebruikersnaam.hashCode() : 0);
        result = 31 * result + (wachtwoord != null ? wachtwoord.hashCode() : 0);
        result = 31 * result + (privilege != null ? privilege.hashCode() : 0);
        result = 31 * result + (geblokkeerd ? 1 : 0);
        return result;
    }
}
