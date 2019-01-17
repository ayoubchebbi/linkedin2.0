package com.tn.isamm.linkedin.dao;


import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import javax.persistence.*;
import java.util.*;

@Transactional
@Repository
public class Languedaoimpl implements LangueDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Langue langue) {

        try{

            entityManager.persist(langue);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public Langue get(int id) {

        try {
            return entityManager.find(Langue.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Langue> list() {

        try {
            String sql = "FROM Langue as langue ORDER BY langue.idPb";
            return (List<Langue>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public Langue getUser(Utilisateur user) {

        try {
            String sql = "FROM langue as lang WHERE user.utilisateur="+user;
            return (Langue) entityManager.createQuery(sql);

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List <Langue> getUserById (Utilisateur user) {
        try {
            String sql = "FROM Langue as langue WHERE langue.utilisateur LIKE :user";
            return (List<Langue>)entityManager.createQuery(sql).setParameter("user",user).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(Langue langue) {

        try{
            Langue lang = entityManager.find(Langue.class,langue.getId());
            lang.setLang(langue.getLang());
            lang.setNiveau(langue.getNiveau());
            lang.setUtilisateur(langue.getUtilisateur());


        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(Langue langue) {

        try{
            entityManager.remove(langue);

        }catch(Exception ex){
            return false;
        }
        return true;    }
}
