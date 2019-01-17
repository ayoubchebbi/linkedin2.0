package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.OffreUtilisateurDao;
import com.tn.isamm.linkedin.dao.OffreUtilisateurDaoimpl;
import com.tn.isamm.linkedin.entity.OffreUtilisateur;
import com.tn.isamm.linkedin.entity.OffreUtilisateurId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffreUtilisateurServiceImp implements  OffreUtilisateurService{
    @Autowired
    private OffreUtilisateurDao offreUtilisateurDao;

    @Override
    public boolean save(OffreUtilisateur offreUtilisateur) {
        if( offreUtilisateurDao.save(offreUtilisateur) ){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {


        if( offreUtilisateurDao.delete(id) ){
            return true;
        }
        return false;
    }
}
