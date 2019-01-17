package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;

import java.util.List;

public interface CommentaireService {

    boolean save(Commentaire commentaire);

    Commentaire get(int id);

    List<Commentaire> list();

    List<Commentaire> getByIdPublication(int id);

    boolean update(Commentaire commentaire);

    boolean delete(int id);
}


