package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface ConnexionService {
    boolean save(Connexion connexion);

    Connexion get(int id);

    List<Connexion> list();

    List<Connexion> list_amis(int id);

    List<Connexion> list_amis2(int id);

    List<Connexion> friends_recommended(int id);

    boolean update(Connexion Connexion);

    boolean delete(Connexion Connexion);

    List<Connexion> getByIds(int id1, int id2);
}
