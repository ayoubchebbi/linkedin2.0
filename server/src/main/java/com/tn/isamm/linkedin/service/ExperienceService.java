package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface ExperienceService {

    boolean save(Experience experience);

    Experience get(int id);

    List <Experience> getUserId (Utilisateur user);

    List<Experience> list();

    Experience getFromIdUtilisateur(Utilisateur user);

    boolean update(Experience experience);

    boolean delete(Experience experience);
}
