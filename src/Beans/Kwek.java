package Beans;

import Entities.Gebruiker;
import Util.GebruikerCrud;
import Util.KwekCrud;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by bram_ on 18-4-2016.
 */
@ManagedBean
@RequestScoped
public class Kwek {
    private Entities.Kwek kwek = new Entities.Kwek();

    @ManagedProperty(value = "#{login}")
    private Login login;

    public String plaatsKwek(){
        Gebruiker plaatser = login.getGebruiker();
        kwek.setAfzender(plaatser.getId());
        KwekCrud.plaatsKwek(kwek);
        return "/index.xhtml";
    }

    public String volgKwekkeraar(int id){
        GebruikerCrud.volgGebruiker(login.getGebruiker().getId(), id);
        return "/index.xhtml";
    }

    public Entities.Kwek getKwek() {
        return kwek;
    }

    public void setKwek(Entities.Kwek kwek) {
        this.kwek = kwek;
    }

    public void setLogin(Login login){
        this.login = login;
    }
}
