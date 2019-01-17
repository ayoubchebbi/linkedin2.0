package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface LangueService {


    boolean save(Langue langue);

    Langue get(int id);

    List<Langue> list();

    List <Langue> getUserId (Utilisateur user);

    Langue  getFromIdUtilisateur(Utilisateur user);

    boolean update(Langue langue);

    boolean delete(Langue langue);
}
