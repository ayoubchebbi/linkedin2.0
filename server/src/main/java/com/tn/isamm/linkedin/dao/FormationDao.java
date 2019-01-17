package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface FormationDao {

    boolean save(Formation formation);

    Formation get(int id);

    List <Formation> getUserById(Utilisateur user);

    List<Formation> list();

    Formation getUser(Utilisateur user);

    boolean update(Formation formation);

    boolean delete(Formation formation);
}
