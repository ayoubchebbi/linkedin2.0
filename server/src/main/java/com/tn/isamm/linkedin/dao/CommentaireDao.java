package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;

import java.util.*;

public interface CommentaireDao {

    boolean save(Commentaire commentaire);

    Commentaire get(int id);

    List<Commentaire> getByIdPublication(int id);

    List<Commentaire> list();

    boolean update(Commentaire commentaire);

    boolean delete(Commentaire commentaire);
}
