package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;


@Service
public class LangueServiceImp  implements LangueService {
    @Autowired
    private LangueDao langueDao = new Languedaoimpl();


    @Override
    public boolean save(Langue langue) {

        if( langueDao.save(langue) ){
            return true;
        }
        return false;
    }

    @Override
    public Langue get(int id) {

        return langueDao.get(id);

    }

    @Override
    public List<Langue> list() {

        return langueDao.list();

    }

    @Override
    public List <Langue> getUserId(Utilisateur user) {

        return langueDao.getUserById(user);
    }

    @Override
    public Langue getFromIdUtilisateur(Utilisateur user) {

        return langueDao.getUser(user);
    }

    @Override
    public boolean update(Langue langue) {

        if( langueDao.update(langue) ){
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Langue langue) {

        if( langueDao.delete(langue) ){
            return true;
        }
        return false;
    }
}
