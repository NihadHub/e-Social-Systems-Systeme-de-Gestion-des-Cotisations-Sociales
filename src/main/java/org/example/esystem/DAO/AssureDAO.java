package org.example.esystem.DAO;
import org.example.esystem.Model.Assure;
import org.example.esystem.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
public class AssureDAO {
    EntityManager em = JPAUtil.getEntityManager();
    EntityTransaction transaction = em.getTransaction();
     public void ajouterAssure(Assure assure) {
          try {
               transaction.begin();
               em.persist(assure);
               transaction.commit();
          } catch (Exception e) {
               if (transaction.isActive()) transaction.rollback();
               throw e;
          } finally {
               em.close();
          }
     }

     public Assure findById(long id){
         try{
              return em.find(Assure.class, id);
         }   finally {
              em.close();
         }
     }

     public List<Assure> findAll(){
          try {
               return em.createQuery("SELECT a FROM Assure a", Assure.class).getResultList();
          }   finally {
          em.close();
     }
     }

     public List<Assure> findEmployeur(int employeurId){
          try{
               return em.createQuery(
                       "SELECT a FROM Assure a WHERE a.employeur.id=:empId", Assure.class)
                       .setParameter("empId", employeurId).getResultList();
           } finally {
               em.close();
          }
     }

     public void UpdateSalary(int id, double nouveauSalaire){
          try {
               transaction.begin();
               Assure assure = em.find(Assure.class, id);
               if(assure != null){
                    assure.setSalaireMensuel(nouveauSalaire);
                    em.merge(assure);
               }
               transaction.commit();
          }catch(Exception e){
               if(transaction.isActive()) transaction.rollback();
               throw e;
          }finally {
               em.close();
          }
     }

}
