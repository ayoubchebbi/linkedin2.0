package com.tn.isamm.linkedin.service;


import com.tn.isamm.linkedin.entity.OffreUtilisateur;


public interface OffreUtilisateurService {
    boolean save(OffreUtilisateur offreUtilisateur);
    boolean delete(int id);
}
