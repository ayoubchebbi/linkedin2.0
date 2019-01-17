package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.OffreEmploi;
import com.tn.isamm.linkedin.entity.OffreUtilisateur;
import com.tn.isamm.linkedin.entity.OffreUtilisateurId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class OffreUtilisateurDaoimpl implements OffreUtilisateurDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(OffreUtilisateur offreUtilisateur) {

        try{
            System.out.println(offreUtilisateur);
            entityManager.persist(offreUtilisateur);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(int id) {

        System.out.println("==================================>");
        System.out.println(id);
        try{
            String sql = "DELETE FROM OffreUtilisateur offreUtilisateur WHERE offreUtilisateur.offreEmploi.id LIKE :id";
            entityManager.createQuery(sql).setParameter("id", id).executeUpdate();
        }catch(Exception ex){
            return false;
        }
        return true;
    }

}
