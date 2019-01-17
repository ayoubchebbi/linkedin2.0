package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface PublicationService {

    boolean save(Publication publication);

    Publication get(int id);

    List <Publication> getUserId (Utilisateur user);

    List<Publication> list();

    boolean update(Publication publication);

    boolean delete(int id);
}


