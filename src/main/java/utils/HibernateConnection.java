package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

public class HibernateConnection {

    private static SessionFactory sf;

    private static Logger log=Logger.getLogger(HibernateConnection.class.getName());

    static{
        try{
            Configuration cf=new Configuration();
            cf.configure("hibernate.cfg.xml");
            sf=cf.buildSessionFactory();
            log.info("SessionFactory CREADO CON ÉXITO");
        }catch(Exception e){
            log.severe("ERROR AL CREAR SessionFactory");
        }

    }
    public static SessionFactory getSessionFactory(){
        return sf;
    }

}
