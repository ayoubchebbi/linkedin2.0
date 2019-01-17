package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface FormationService {

    boolean save(Formation formation);

    Formation get(int id);

    List <Formation> getUserId (Utilisateur user);

    List<Formation> list();

    Formation  getFromIdUtilisateur(Utilisateur user);

    boolean update(Formation formation);

    boolean delete(Formation formation);
}
