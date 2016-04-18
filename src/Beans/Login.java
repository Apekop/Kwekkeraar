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
    private Gebruiker gebruiker = new Gebruiker();

    public String CheckValidUser(){
        Gebruiker inlog = GebruikerCrud.getGebruiker(gebruiker.getGebruikersnaam());
        if(gebruiker.getWachtwoord().equals(inlog.getWachtwoord())){
            setGebruiker(inlog);
            return "index.xhtml";
        }
        else{
            gebruiker = null;
            return "/register.xhtml";
        }
    }

    public Gebruiker getGebruiker(){ return gebruiker; }

    public void setGebruiker(Gebruiker gebruiker){ this.gebruiker = gebruiker; }
}
