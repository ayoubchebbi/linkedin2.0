package com.tn.isamm.linkedin.dao;


import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import javax.persistence.*;
import java.util.*;

@Transactional
@Repository
public class OffreEmploiDaoimpl implements OffreEmploiDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(OffreEmploi offreEmploi) {

        try{
                entityManager.persist(offreEmploi);
                entityManager.flush();
        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public OffreEmploi get(int id) {

        try {

            return entityManager.find(OffreEmploi.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public OffreEmploi getlastid() {

        try {
            String sql = "FROM OffreEmploi as offreEmploi WHERE id LIKE MAX(id)";
            return (OffreEmploi)entityManager.createQuery(sql);
        } catch (Exception ex) {
            return null;
        }

    }


    @Override
    public List<OffreEmploi> listOffre(int id) {
        System.out.println(id);
        try {
            String sql = "FROM OffreEmploi offreEmploi WHERE offreEmploi.id NOT IN(SELECT offreUtilisateur.offreEmploi.id From OffreUtilisateur "+
                    "offreUtilisateur WHERE offreUtilisateur.utilisateur.id LIKE :id)  ORDER BY offreEmploi.id DESC";
            return (List<OffreEmploi>)entityManager.createQuery(sql)
                    .setParameter("id", id)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }

    }



    @Override
    public List<OffreEmploi> list() {

        try {
            String sql = "FROM OffreEmploi as offreEmploi ORDER BY offreEmploi.id DESC";
            return (List<OffreEmploi>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(OffreEmploi offreEmploi) {

        try{
            OffreEmploi of =  entityManager.find(OffreEmploi.class,offreEmploi.getId());
            of.setDescOffre(offreEmploi.getDescOffre());
        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(OffreEmploi offreEmploi) {

        try{
            entityManager.remove(offreEmploi);

        }catch(Exception ex){
            return false;
        }
        return true;    }
}
