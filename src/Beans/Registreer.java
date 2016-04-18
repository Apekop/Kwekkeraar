package Beans;

import Entities.Gebruiker;
import Util.GebruikerCrud;
import Util.Main;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by bram_ on 18-4-2016.
 */
@ManagedBean
@RequestScoped
public class Registreer {
    private String gebruikersnaam;
    private String wachtwoord1;
    private String wachtwoord2;

    @ManagedProperty(value = "#{login}")
    private Login login;

    public String registreer(){
        if(wachtwoord1.equals(wachtwoord2)) {
            Session session = Main.getSession().getSessionFactory().openSession();
            Transaction tran = null;
            try {
                tran = session.beginTransaction();
                Gebruiker gebruiker = new Gebruiker();
                gebruiker.setGebruikersnaam(gebruikersnaam);
                gebruiker.setWachtwoord(wachtwoord1);
                gebruiker.setPrivilege("gebruiker");
                gebruiker.setGeblokkeerd(false);
                session.save(gebruiker);
                tran.commit();
                login.setGebruiker(GebruikerCrud.getGebruiker(gebruikersnaam));
                return "/index.xhtml";
            } catch (HibernateException e) {
                tran.rollback();
            } finally {
                session.close();
            }
        }
        return "/register.xhtml";
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord1() {
        return wachtwoord1;
    }

    public void setWachtwoord1(String wachtwoord1) {
        this.wachtwoord1 = wachtwoord1;
    }

    public String getWachtwoord2() {
        return wachtwoord2;
    }

    public void setWachtwoord2(String wachtwoord2) {
        this.wachtwoord2 = wachtwoord2;
    }

    public void setLogin(Login login){
        this.login = login;
    }
}
