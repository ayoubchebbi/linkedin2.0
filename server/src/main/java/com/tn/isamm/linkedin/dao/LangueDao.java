package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface LangueDao {


    boolean save(Langue langue);

    Langue get(int id);

    List<Langue> list();

    List <Langue> getUserById(Utilisateur user);

    Langue getUser(Utilisateur user);

    boolean update(Langue langue);

    boolean delete(Langue langue);
}
