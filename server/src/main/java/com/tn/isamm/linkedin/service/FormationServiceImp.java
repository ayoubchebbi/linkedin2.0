package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;


@Service
public class FormationServiceImp implements FormationService {
    @Autowired
    private FormationDao formationDao = new Formationdaoimpl();


    @Override
    public boolean save(Formation formation) {

        if( formationDao.save(formation) ){
            return true;
        }
        return false;
    }

    @Override
    public Formation get(int id) {

        return formationDao.get(id);

    }

    @Override
    public List <Formation> getUserId(Utilisateur user) {

        return formationDao.getUserById(user);
    }

    @Override
    public Formation getFromIdUtilisateur(Utilisateur user) {

        return formationDao.getUser(user);
    }

    @Override
    public List<Formation> list() {

        return formationDao.list();

    }

    @Override
    public boolean update(Formation formation) {
        System.out.println("service formation1");
        if( formationDao.update(formation) ){
            System.out.println("service formation2");
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Formation formation) {

        if( formationDao.delete(formation) ){
            return true;
        }
        return false;
    }
}
