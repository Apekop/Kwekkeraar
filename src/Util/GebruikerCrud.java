package Util;

import Entities.Gebruiker;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
}
