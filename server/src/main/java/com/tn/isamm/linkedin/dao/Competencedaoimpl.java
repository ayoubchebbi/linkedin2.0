package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import javax.persistence.*;
import java.util.*;



@Transactional
@Repository
public class Competencedaoimpl implements CompetenceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Competence competence) {

        try{

            entityManager.persist(competence);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public Competence get(int id) {

        try {
            return entityManager.find(Competence.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public Competence getUser(Utilisateur user) {

        try {
            System.out.println("**** compdaoimpl error 1");
            String sql = "FROM competence as comp WHERE user.utilisateur="+user;
            return (Competence) entityManager.createQuery(sql);

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List <Competence> getUserById (Utilisateur user) {
        try {
            System.out.println(user.getId());
            String sql = "FROM Competence  competence WHERE competence.utilisateur LIKE :user";
            System.out.println("after query");
            return (List<Competence>)entityManager.createQuery(sql).setParameter("user",user).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Competence> list() {

        try {
            String sql = "FROM Competence as competence ORDER BY competence.id";
            System.out.println((List<Competence>)entityManager.createQuery(sql).getResultList());
            return (List<Competence>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(Competence competence) {

        try{

            Competence comp= entityManager.find(Competence.class,competence.getId());
            comp.setNomCompetence(competence.getNomCompetence());
            comp.setUtilisateur(competence.getUtilisateur());


        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(Competence competence) {

        try{
            entityManager.remove(competence);

        }catch(Exception ex){
            return false;
        }
        return true;    }
}
