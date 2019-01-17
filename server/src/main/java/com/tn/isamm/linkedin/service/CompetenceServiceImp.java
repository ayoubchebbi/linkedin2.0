package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;

@Service
public class CompetenceServiceImp implements CompetenceService {
    @Autowired
    private CompetenceDao competenceDao = new Competencedaoimpl();


    @Override
    public boolean save(Competence competence) {

        if( competenceDao.save(competence) ){
            return true;
        }
        return false;
    }

    @Override
    public Competence get(int id) {

        return competenceDao.get(id);

    }
    @Override
    public List <Competence> getUserId(Utilisateur user) {
        System.out.println("service***");
        return competenceDao.getUserById(user);

    }

    @Override
    public Competence getFromIdUtilisateur(Utilisateur user){

        return competenceDao.getUser(user);
    }

    @Override
    public List<Competence> list() {

        return competenceDao.list();

    }

    @Override
    public boolean update(Competence competence) {

        if( competenceDao.update(competence) ){
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Competence competence) {

        if( competenceDao.delete(competence) ){
            return true;
        }
        return false;
    }
}
