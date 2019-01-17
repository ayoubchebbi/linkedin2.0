package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface ExperienceDao {
    boolean save(Experience experience);

    Experience get(int id);

    List <Experience> getUserById(Utilisateur user);

    Experience getUser(Utilisateur user);

    List<Experience> list();

    boolean update(Experience experience);

    boolean delete(Experience experience);
}
