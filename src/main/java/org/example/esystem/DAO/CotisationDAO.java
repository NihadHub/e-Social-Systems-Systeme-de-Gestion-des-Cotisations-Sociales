package org.example.esystem.DAO;
import org.example.esystem.Model.Cotisation;
import org.example.esystem.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
public class CotisationDAO {
    EntityManager em = JPAUtil.getEntityManager();
    EntityTransaction transaction=em.getTransaction();

    public void ajouterCotisation(Cotisation cotisation){
        try {
            transaction.begin();
            em.persist(cotisation);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive())transaction.rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public List<Cotisation> findByAssure(int idAssure){
        try {
            return em.createQuery("SELECT c FROM Cotisation c WHERE c.assure.id = :aId", Cotisation.class).setParameter("aId",idAssure).getResultList();
        }finally {
            em.close();
        }
    }

    public List<Cotisation> findByDeclaration(int declarationId){
        try {
            return em.createQuery("SELECT c FROM Cotisation c WHERE c.declaration.id =:dId", Cotisation.class).setParameter("dId",declarationId).getResultList();
        }finally {
            em.close();
        }
    }

    public double getTotalByEmployeur(int employeurId){
        try {
            Double Total = em.createQuery(
                    "SELECT SUM(c.cotisationSalariale+ c.cotisationPatronale )FROM Cotisation c WHERE c.declaration.employeur.id=:empId", Double.class
            ).setParameter("empId",employeurId).getSingleResult();
            return Total != null ? Total:0.0;
        } finally {
            em.close();
        }
    }
    public long getNombreMoisDeclares(Long assureId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Long count = em.createQuery(
                            "SELECT COUNT(DISTINCT c.declaration.id) " +
                                    "FROM Cotisation c WHERE c.assure.id = :aId",
                            Long.class)
                    .setParameter("aId", assureId)
                    .getSingleResult();
            return count != null ? count : 0;
        } finally {
            em.close();
        }
    }

    public double getTotalCotisationsByAssure(Long assureId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Double total = em.createQuery(
                            "SELECT SUM(c.cotisationSalariale + c.cotisationPatronale) "
                                    + "FROM Cotisation c WHERE c.assure.id = :aId",
                            Double.class)
                    .setParameter("aId", assureId)
                    .getSingleResult();
            return total != null ? total : 0.0;
        } finally {
            em.close();
        }
    }
}
