package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;

@Service
public class ExperienceServiceImp  implements ExperienceService{

    @Autowired
    private ExperienceDao experienceDao = new ExperienceDaoimpl();


    @Override
    public boolean save(Experience experience) {

        if( experienceDao.save(experience) ){
            return true;
        }
        return false;
    }

    @Override
    public Experience get(int id) {

        return experienceDao.get(id);

    }

    @Override
    public List <Experience> getUserId(Utilisateur user) {
        System.out.println("Service");
        return experienceDao.getUserById(user);
    }


    @Override
    public Experience getFromIdUtilisateur(Utilisateur user) {
        return experienceDao.getUser(user);
    }

    @Override
    public List<Experience> list() {

        return experienceDao.list();

    }

    @Override
    public boolean update(Experience experience) {

        if( experienceDao.update(experience) ){
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Experience experience) {

        if( experienceDao.delete(experience) ){
            return true;
        }
        return false;
    }
}
