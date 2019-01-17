package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;

@Service
public class ConnexionServiceImp implements ConnexionService  {

    @Autowired
    private ConnexionDao connexionDao = new Connexiondaoimpl();


    @Override
    public boolean save(Connexion connexion) {

        if( connexionDao.save(connexion) ){
            return true;
        }
        return false;
    }

    @Override
    public Connexion get(int id) {

        return connexionDao.get(id);

    }

    @Override
    public List<Connexion> list() {

        return connexionDao.list();

    }

    @Override
    public List<Connexion> list_amis(int id) {

        return connexionDao.list_amis(id);

    }

    @Override
    public List<Connexion> list_amis2(int id) {

        return connexionDao.list_amis2(id);

    }

    @Override
    public List<Connexion> friends_recommended(int id) {

        return connexionDao.friends_recommended(id);

    }

    @Override
    public boolean update(Connexion connexion) {

        if( connexionDao.update(connexion) ){
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Connexion connexion) {

        if( connexionDao.delete(connexion) ){
            return true;
        }
        return false;
    }

    @Override
    public List<Connexion> getByIds(int id1, int id2){
        System.out.println("Service Impl");
        System.out.println("id1 "+id1);
        System.out.println("id2 "+id2);
        return connexionDao.getByIds(id1,id2);
    }
}

