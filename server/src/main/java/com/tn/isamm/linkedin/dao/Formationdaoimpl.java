package com.tn.isamm.linkedin.dao;


import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import javax.persistence.*;
import javax.persistence.*;
import java.util.*;

@Transactional
@Repository
public class Formationdaoimpl implements FormationDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Formation formation) {

        try{

            entityManager.persist(formation);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public Formation get(int id) {

        try {
            return entityManager.find(Formation.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public Formation getUser(Utilisateur user) {

        try {
            String sql = "FROM formation as for WHERE user.utilisateur="+user;
            return (Formation) entityManager.createQuery(sql);

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List <Formation> getUserById (Utilisateur user) {
        try {
            String sql = "FROM Formation as formation WHERE formation.utilisateur LIKE :user";
            return (List<Formation>)entityManager.createQuery(sql).setParameter("user",user).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Formation> list() {

        try {
            String sql = "FROM Formation as formation ORDER BY formation.id";
            return (List<Formation>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(Formation formation) {


        try{
            Formation forma = entityManager.find(Formation.class,formation.getId());
            forma.setEcole(formation.getEcole());
            forma.setDiplome(formation.getDiplome());
            forma.setDiscipline(formation.getDiscipline());
            forma.setDescription(formation.getDescription());
            forma.setDateDebut(formation.getDateDebut());
            forma.setDateFin(formation.getDateFin());
            forma.setUtilisateur(formation.getUtilisateur());



        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(Formation formation) {

        try{
            entityManager.remove(formation);

        }catch(Exception ex){
            return false;
        }
        return true;    }
}
