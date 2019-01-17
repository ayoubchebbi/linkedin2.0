package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;


@Service
public class OffreEmploiServiceImp implements OffreEmploiService{
    @Autowired
    private OffreEmploiDao offreEmploiDao = new OffreEmploiDaoimpl();


    @Override
    public boolean save(OffreEmploi offreEmploi) {
        System.out.println("service");
        System.out.println(offreEmploi);
        if( offreEmploiDao.save(offreEmploi) ){
            return true;
        }
        return false;
    }

    @Override
    public OffreEmploi get(int id) {

        return offreEmploiDao.get(id);

    }

    @Override
    public OffreEmploi getlastid() {

        return offreEmploiDao.getlastid();

    }

    @Override
    public List<OffreEmploi> listOffre(int id) {

        return offreEmploiDao.listOffre(id);

    }

    @Override
    public List<OffreEmploi> list() {

        return offreEmploiDao.list();

    }

    @Override
    public boolean update(OffreEmploi offreEmploi) {

        if( offreEmploiDao.update(offreEmploi) ){
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(int id) {

        OffreEmploi offre=offreEmploiDao.get(id);

        if( offreEmploiDao.delete(offre) ){
            return true;
        }
        return false;
    }
}
