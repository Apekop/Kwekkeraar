package Util;

import Entities.Gebruiker;
import Entities.Kwek;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
