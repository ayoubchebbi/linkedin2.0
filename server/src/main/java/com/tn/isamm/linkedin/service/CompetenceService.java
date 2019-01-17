package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface CompetenceService {


    boolean save(Competence competence);

    Competence get(int id);

    List <Competence> getUserId (Utilisateur user);

    List<Competence> list();

    Competence getFromIdUtilisateur(Utilisateur user);

    boolean update(Competence competence);

    boolean delete(Competence competence);
}
