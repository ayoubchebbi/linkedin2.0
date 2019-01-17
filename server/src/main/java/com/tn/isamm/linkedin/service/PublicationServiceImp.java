package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;


@Service
public class PublicationServiceImp  implements PublicationService  {

    @Autowired
    private PublicationDao publicationDao = new Publicationdaoimpl();


    @Override
    public boolean save(Publication publication) {

        if( publicationDao.save(publication) ){
            return true;
        }
        return false;
    }

    @Override
    public Publication get(int id) {

        return publicationDao.get(id);

    }


    @Override
    public List <Publication> getUserId(Utilisateur user) {

        return publicationDao.getUserById(user);
    }


    @Override
    public List<Publication> list() {

        return publicationDao.list();

    }

    @Override
    public boolean update(Publication publication) {

        if( publicationDao.update(publication) ){
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(int id) {

        Publication pub=publicationDao.get(id);

        if( publicationDao.delete(pub) ){
            return true;
        }
        return false;
    }
}
