package frontend.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;

import backend.HibernateUtil;
import backend.entity.Rolle;


@ManagedBean
@RequestScoped
public class RolleBean {

    private String bezeichnung = "Administrator"; // Default role name, can be changed via the UI if needed

    // Method to add a new Rolle
    public void addRolle() {
        Rolle neueRolle = new Rolle();
        neueRolle.setBezeichnung(bezeichnung);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(neueRolle);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace(); // For debugging
        } finally {
            session.close();
        }
    }

    // Getters and Setters
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
}