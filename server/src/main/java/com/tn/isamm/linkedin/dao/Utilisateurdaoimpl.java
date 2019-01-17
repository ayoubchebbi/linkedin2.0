package com.tn.isamm.linkedin.dao;


import com.tn.isamm.linkedin.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import javax.persistence.*;
import java.util.*;

@Transactional
@Repository
public class Utilisateurdaoimpl implements UtilisateurDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Utilisateur utilisateur) {

        try{

            entityManager.persist(utilisateur);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public Utilisateur get(int id) {

        try {
            return entityManager.find(Utilisateur.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public Utilisateur getByEmail(String email) {

        try {
            String sql = "FROM Utilisateur as user WHERE user.email="+email;
            return (Utilisateur)entityManager.createQuery(sql);

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Utilisateur> list() {

        try {
            String sql = "FROM Utilisateur as user ORDER BY user.id";
            return (List<Utilisateur>)entityManager.createQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(Utilisateur utilisateur) {

        try{

            Utilisateur u = entityManager.find(Utilisateur.class,utilisateur.getId());
            u.setDescription(utilisateur.getDescription());


        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(Utilisateur utilisateur) {

        try{
            entityManager.remove(utilisateur);

        }catch(Exception ex){
            return false;
        }
        return true;    }

    public List<Utilisateur> findByEmailAndMotDePasse(String email, String password) {

        try {
            String sql = "FROM Utilisateur as user where user.email LIKE :email and user.motDePasse LIKE :password";
            return (List<Utilisateur>)entityManager.createQuery(sql)
                    .setParameter("email", email)
                    .setParameter("password",password)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    public List<Utilisateur> findUserByEmail(String email) {

        try {
            String sql = "FROM Utilisateur as user where user.email LIKE :email";
            return (List<Utilisateur>)entityManager.createQuery(sql)
                    .setParameter("email", email)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }

    }
}
