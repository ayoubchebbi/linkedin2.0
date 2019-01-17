package com.tn.isamm.linkedin.dao;


import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import javax.persistence.*;
import java.util.*;

@Transactional
@Repository
public class Publicationdaoimpl implements PublicationDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Publication publication) {

        try{

            entityManager.persist(publication);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public Publication get(int id) {

        try {
            return entityManager.find(Publication.class,id);
        } catch (Exception ex) {
            return null;
        }

    }


    @Override
    public List <Publication> getUserById (Utilisateur user) {
        try {
            String sql = "FROM Publication as publication WHERE publication.utilisateur LIKE :user";
            return (List<Publication>) entityManager.createQuery(sql).setParameter("user", user).getResultList();

        } catch (Exception ex) {
            return null;
        }


    }
    @Override
    public List<Publication> list() {

        try {
            String sql = "FROM Publication as publication ORDER BY publication.date DESC";
            return (List<Publication>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(Publication publication) {

        try{


        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(Publication publication) {

        try{

            entityManager.remove(publication);

        }catch(Exception ex){
            return false;
        }
        return true;    }


}
