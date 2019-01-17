package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface UtilisateurService {


    boolean save(Utilisateur utilisateur);

    Utilisateur getByEmail(String email);

    Utilisateur get(int id);

    List<Utilisateur> list();

    boolean update(Utilisateur utilisateur);

    boolean delete(Utilisateur utilisateur);

    List<Utilisateur> findUserByEmailAndpassword(String email, String password);

    List<Utilisateur> findUserByemail(String sqlQuery);

}
