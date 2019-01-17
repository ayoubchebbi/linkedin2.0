package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;

import java.util.*;

public interface UtilisateurDao {



    boolean save(Utilisateur utilisateur);

    Utilisateur get(int id);

    Utilisateur getByEmail(String email);

    List<Utilisateur> list();

    boolean update(Utilisateur utilisateur);

    boolean delete(Utilisateur utilisateur);

    List<Utilisateur> findByEmailAndMotDePasse(String email, String password);

    List<Utilisateur> findUserByEmail(String email);


}
