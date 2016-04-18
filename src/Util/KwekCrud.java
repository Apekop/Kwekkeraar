package Util;

import Entities.Gebruiker;
import Entities.Kwek;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by bram_ on 18-4-2016.
 */
public class KwekCrud {
    public static void plaatsKwek(Kwek kwek){
        Session session = Main.getSession().getSessionFactory().openSession();
        Transaction tran = null;
        try {
            tran = session.beginTransaction();
            session.save(kwek);
            tran.commit();
        } catch (HibernateException e) {
            tran.rollback();
        } finally {
            session.close();
        }
    }

    public static List<Kwek> getAlleKweks(){
        Session session = Main.getSession().getSessionFactory().openSession();
        Query query = session.createQuery("from Entities.Kwek");
        List<Kwek> kweks = query.list();
        return kweks;
    }
}
