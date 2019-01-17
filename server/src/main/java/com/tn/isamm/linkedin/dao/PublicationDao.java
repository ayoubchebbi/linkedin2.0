package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface PublicationDao {

    boolean save(Publication publication);

    Publication get(int id);

    List <Publication> getUserById(Utilisateur user);

    List<Publication> list();

    boolean update(Publication publication);

    boolean delete(Publication publication);
}
