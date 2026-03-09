package org.example.esystem.DAO;
import org.example.esystem.Model.Declaration;
import org.example.esystem.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import java.util.List;
public class DeclarationDAO {

    public void ajouterDeclaration(Declaration declaration){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction=em.getTransaction();
        try {
            transaction.begin();
            em.persist(declaration);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive())transaction.rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public Declaration findById(int id){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Declaration.class, id);
        }finally {
            em.close();
        }
    }

    public List<Declaration> findAll(){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT d FROM Declaration d", Declaration.class).getResultList();
        }finally {
            em.close();
        }
    }

    public boolean exister(int EmployeurId, int mois, int anne){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Declaration declaration = em.createQuery(
                            "SELECT d FROM Declaration d WHERE d.employeur.id =:empId AND d.mois =:mois AND d.annee = :annee", Declaration.class)
                    .setParameter("empId", EmployeurId).setParameter("mois", mois).setParameter("annee", anne).getSingleResult();
            return true;
         } catch (NoResultException e) {
                return false;
            } finally {
                em.close();
            }
        }

    public List<Declaration> findByEmployeur(int employeurId){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT d FROM Declaration  d where d.employeur.id=:empId", Declaration.class).setParameter("empId",employeurId).getResultList();
        } finally {
            em.close();
        }
    }







    }
