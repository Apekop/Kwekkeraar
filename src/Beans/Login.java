package Beans;

import Entities.Gebruiker;
import Util.GebruikerCrud;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by bram_ on 16-4-2016.
 */
@ManagedBean
@SessionScoped
public class Login {
    String gebruikersnaam;
    String wachtwoord;

    public String CheckValidUser(){
        Gebruiker gebruiker = GebruikerCrud.getGebruiker(gebruikersnaam);
        if(wachtwoord.equals(gebruiker.getWachtwoord())){
            return "index.xhtml";
        }
        else{
            gebruikersnaam = null;
            return "/register.xhtml";
        }
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
