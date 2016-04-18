package Beans;

import Entities.Gebruiker;
import Entities.Kwek;
import Util.GebruikerCrud;
import Util.KwekCrud;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bram_ on 17-4-2016.
 */
@ManagedBean
@SessionScoped
public class Content {
    private List<Kwek> kweksVanVrienden;
    private List<Kwek> kweksVanIedereen;
    private List<Gebruiker> vrienden;
    private List<Gebruiker> iedereen;

    @ManagedProperty(value = "#{login}")
    private Login login;

    public List<Kwek> getKweksVanVrienden()
    {
        List<Kwek> kweksVanVrienden = new ArrayList<Kwek>();
        Gebruiker g = GebruikerCrud.getGebruiker(login.getGebruiker().getId());
        for (Gebruiker vriend :
                GebruikerCrud.getVrienden(g.getId())) {
            kweksVanVrienden.addAll(KwekCrud.getKweksVanGebruiker(vriend.getId()));
        }
        return kweksVanVrienden;
    }

    public List<Kwek> getKweksVanIedereen() {
        return KwekCrud.getAlleKweks();
    }

    public List<Gebruiker> getVrienden() {
        return vrienden;
    }

    public List<Gebruiker> getIedereen()
    {
        return GebruikerCrud.getAlleGebruikers();
    }

    public void setLogin(Login login){ this.login = login; }
}
