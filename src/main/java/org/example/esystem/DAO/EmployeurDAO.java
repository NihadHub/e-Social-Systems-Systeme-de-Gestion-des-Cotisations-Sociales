package org.example.esystem.DAO;
import org.example.esystem.Model.Employeur;
import org.example.esystem.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
public class EmployeurDAO {

    public void ajouterEmployeur(Employeur emp){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction=em.getTransaction();
        try{
            transaction.begin();
            em.persist(emp);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive()) transaction.rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public List<Employeur> findAll(){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT DISTINCT e FROM Employeur e LEFT JOIN FETCH e.declarations",
                    Employeur.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public Employeur findById(int id) {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Employeur.class, id);
        } finally {
            em.close();
        }
    }
    public void Update(Employeur emp){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction=em.getTransaction();
        try {
            transaction.begin();
            em.merge(emp);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive())transaction.rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void Supprimer(int id){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction=em.getTransaction();
        try {
            transaction.begin();
            Employeur emp=em.find(Employeur.class,id);
            if(emp!=null)em.remove(emp);
            transaction.commit();
        }catch (Exception e){
            if (transaction.isActive())transaction.rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
