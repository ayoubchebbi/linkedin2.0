package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import javax.persistence.*;
import java.util.*;



@Transactional
@Repository
public class Connexiondaoimpl  implements ConnexionDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Connexion connexion) {

        try{

            entityManager.persist(connexion);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public Connexion get(int id) {

        try {
            return entityManager.find(Connexion.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Connexion> list() {

        try {
           String sql = "FROM Connexion as connexion ORDER BY connexion.id";
           return (List<Connexion>)entityManager.createQuery(sql).getResultList();


        } catch (Exception ex) {
            return null;
        }
    }
    @Override
    public List<Connexion> list_amis(int id) {
        System.out.println("hahahah" + id);
        int x=1;
        try {
            String sql = "FROM Connexion as connexion WHERE connexion.utilisateurByIdUtilisateur1.id LIKE :id AND connexion.ajout LIKE :x ORDER BY connexion.id";
            return (List<Connexion>)entityManager.createQuery(sql)
                    .setParameter("id", id)
                    .setParameter("x", x)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }

    }
    @Override
    public List<Connexion> list_amis2(int id) {
        int x=1;
        try {
            String sql = "FROM Connexion as connexion WHERE connexion.utilisateurByIdUtilisateur2.id LIKE :id AND connexion.ajout LIKE :x ORDER BY connexion.id";
            return (List<Connexion>)entityManager.createQuery(sql)
                    .setParameter("id", id)
                    .setParameter("x", x)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Connexion> friends_recommended(int id) {
        try {
            String sql = "FROM Utilisateur user WHERE user.id NOT LIKE :id AND " +
                    "user.id NOT IN (SELECT connexion.utilisateurByIdUtilisateur2.id FROM Connexion as connexion WHERE connexion.utilisateurByIdUtilisateur1.id LIKE :id) " +
                    "AND " +
                    "user.id NOT IN (SELECT connexion.utilisateurByIdUtilisateur1.id FROM Connexion as connexion WHERE connexion.utilisateurByIdUtilisateur2.id LIKE :id) " +
                    "ORDER BY user.id ASC";

            return (List<Connexion>)entityManager.createQuery(sql)
                    .setParameter("id", id)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(Connexion connexion) {
             System.out.println("Update DAO ");

        try{
            Connexion con = entityManager.find(Connexion.class,connexion.getId());
            con.setAjout(1);


        }catch(Exception ex){
            System.out.println("Update Exception ");
            return false;

        }
        return true;
    }

    @Override
    public boolean delete(Connexion connexion) {

        try{
            entityManager.remove(connexion);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public List<Connexion> getByIds(int id1, int id2) {
        System.out.println("DAO Impl");
        System.out.println("id1 "+id1);
        System.out.println("id2 "+id2);
        List<Connexion> list = null;
        try {
            String sql = "FROM Connexion as connexion WHERE " +
                    "(connexion.utilisateurByIdUtilisateur1.id LIKE :id1 AND connexion.utilisateurByIdUtilisateur2.id LIKE :id2) OR " +
                    "(connexion.utilisateurByIdUtilisateur1.id LIKE :id2 AND connexion.utilisateurByIdUtilisateur2.id LIKE :id1) ORDER BY connexion.id";
            list = (List<Connexion>)entityManager.createQuery(sql)
                    .setParameter("id1", id1)
                    .setParameter("id2", id2)
                    .getResultList();
            System.out.println("list " +list);
            if(list.isEmpty()){
                System.out.println("DAO Impl list null");
                return  null;
            }else{
                System.out.println("DAO Impl list not null");
                return list;
            }


        } catch (Exception ex) {
            System.out.println("exception");
            return null;
        }
    }
}