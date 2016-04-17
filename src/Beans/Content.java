package Beans;

import Entities.Gebruiker;
import Entities.Kwek;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
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

    public List<Kwek> getKweksVanVrienden() {
        return kweksVanVrienden;
    }

    public List<Kwek> getKweksVanIedereen() {

        return kweksVanIedereen;
    }

    public List<Gebruiker> getVrienden() {
        return vrienden;
    }

    public List<Gebruiker> getIedereen() {
        return iedereen;
    }
}
