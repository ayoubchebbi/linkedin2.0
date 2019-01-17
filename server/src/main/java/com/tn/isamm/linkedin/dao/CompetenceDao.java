package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface CompetenceDao {


    boolean save(Competence competence);

    Competence get(int id);

    List <Competence> getUserById(Utilisateur user);

    Competence getUser(Utilisateur user);

    List<Competence> list();

    boolean update(Competence competence);

    boolean delete(Competence competence);
}
