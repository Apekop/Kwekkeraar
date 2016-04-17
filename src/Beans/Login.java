package Beans;

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
        if(gebruikersnaam.equals("Bram") &&
                wachtwoord.equals("Bram")){
            System.out.println("success");
            return "success.jsp";
        }
        else{
            System.out.println("fail");
            return "/fail.jsp";
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
