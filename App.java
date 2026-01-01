package klu.Hibernate_crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        
        SessionFactory factory = config.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        //Create or insert
        Employee e = new Employee();
        e.setId(4);
        e.setFn("P");
        e.setLn("pavan");
        e.setSal(12.5);
        session.save(e);
        tx.commit();
        System.out.println("Record inserted Successfully!");
        
        
        //retrieve
        
        Employee e2 = session.find(Employee.class, 2);
        System.out.println("Record retrieved Successfully!"+" "+e2.sal);
        
        //update
        Employee e3 = session.find(Employee.class, 3);
        e3.setSal(2000);
        session.update(e3);
        Transaction tnx = session.beginTransaction();
        tx.commit();
        System.out.println("Record updated Successfully!");
        
        //delete
        Employee e4 = session.find(Employee.class, 4);
        session.delete(e3);
        Transaction trnx = session.beginTransaction();
        trnx.commit();
        System.out.println("Record deleted Successfully!");
        
        
        
        session.close();
    }
}
