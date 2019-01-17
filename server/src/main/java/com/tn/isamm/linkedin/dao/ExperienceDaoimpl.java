package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import javax.persistence.*;
import java.util.*;

@Transactional
@Repository
public class ExperienceDaoimpl implements ExperienceDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Experience experience) {

        try{

            entityManager.persist(experience);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public Experience get(int id) {

        try {
            return entityManager.find(Experience.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Experience> list() {

        try {
            String sql = "FROM Experience as experience ORDER BY experience.id";
            return (List<Experience>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List <Experience> getUserById (Utilisateur user) {
        try {
            String sql = "FROM Experience as experience WHERE experience.utilisateur LIKE :user";
            return (List<Experience>)entityManager.createQuery(sql).setParameter("user",user).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public Experience getUser(Utilisateur user) {

        try {
            String sql = "FROM experience as exp WHERE user.utilisateur="+user;
            return (Experience) entityManager.createQuery(sql);

        } catch (Exception ex) {
            return null;
        }

    }


    @Override
    public boolean update(Experience experience) {

        try{

            Experience exp = entityManager.find(Experience.class,experience.getId());
            exp.setCause(experience.getCause());
            exp.setDescription(experience.getDescription());
            exp.setDateDebut(experience.getDateDebut());
            exp.setDateFin(experience.getDateFin());
            exp.setUtilisateur(experience.getUtilisateur());
            exp.setRole(experience.getRole());

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(Experience experience) {

        try{
            entityManager.remove(experience);

        }catch(Exception ex){
            return false;
        }
        return true;    }
}
