package Util;

import Entities.Gebruiker;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by bram_ on 18-4-2016.
 */
public class GebruikerCrud {
    public static Gebruiker getGebruiker(String gebruikersnaam){
        Session session = Main.getSession().getSessionFactory().openSession();
        try {
            Query q = session.createQuery("from Entities.Gebruiker as g where g.gebruikersnaam = :naam");
            q.setParameter("naam", gebruikersnaam);
            Gebruiker result = ((Gebruiker) q.uniqueResult());

            if(result != null){
                return result;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return new Gebruiker();
    }

    public static Gebruiker getGebruiker(int id){
        Session session = Main.getSession();
        try{
            Gebruiker gebruiker = (Gebruiker)session.get(Gebruiker.class, id);
            return gebruiker;
        }catch (HibernateException e){

        }finally {
            session.close();
        }
        return new Gebruiker();
    }

    public static List<Gebruiker> getAlleGebruikers(){
        Query query = Main.getSession().createQuery("from Entities.Gebruiker");
        List<Gebruiker> result = query.list();
        return result;
    }
}
