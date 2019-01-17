package com.tn.isamm.linkedin.dao;


import com.tn.isamm.linkedin.entity.OffreUtilisateur;

public interface OffreUtilisateurDao {
    boolean save(OffreUtilisateur offreUtilisateur);
    boolean delete(int id);
}
