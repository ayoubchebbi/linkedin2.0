package com.tn.isamm.linkedin.service;


import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;


@Service
public class UtilisateurServiceImp implements UtilisateurService{

    @Autowired
    private UtilisateurDao utilisateurDao = new Utilisateurdaoimpl();
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public boolean save(Utilisateur utilisateur) {

        if( utilisateurDao.save(utilisateur) ){
            return true;
        }
        return false;
    }

    @Override
    public Utilisateur getByEmail(String email) {
        return utilisateurDao.getByEmail(email);
    }

    @Override
    public Utilisateur get(int id) {

        return utilisateurDao.get(id);

    }

    @Override
    public List<Utilisateur> list() {

        return utilisateurDao.list();

    }

    @Override
    public boolean update(Utilisateur utilisateur) {

        if( utilisateurDao.update(utilisateur) ){
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Utilisateur utilisateur) {

        if( utilisateurDao.delete(utilisateur) ){
            return true;
        }
        return false;
    }


    @Override
    public List<Utilisateur> findUserByEmailAndpassword(String email, String password) {
        return utilisateurDao.findByEmailAndMotDePasse(email,password);
    }

    @Override
    public List<Utilisateur> findUserByemail(String sqlQuery) {
        return utilisateurDao.findUserByEmail(sqlQuery);
    }



}
