package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface ConnexionDao {
    boolean save(Connexion connexion);

    Connexion get(int id);

    List<Connexion> list();

    List<Connexion> list_amis(int id);

    List<Connexion> list_amis2(int id);

    List<Connexion> friends_recommended(int id);

    boolean update(Connexion connexion);

    boolean delete(Connexion connexion);

    List<Connexion> getByIds(int id1, int id2);
}
