package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.CommentaireDao;
import com.tn.isamm.linkedin.dao.CommentaireDaoimpl;
import com.tn.isamm.linkedin.dao.CompetenceDao;
import com.tn.isamm.linkedin.dao.Competencedaoimpl;
import com.tn.isamm.linkedin.entity.Commentaire;
import com.tn.isamm.linkedin.entity.JAime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireDao commentaireDao = new CommentaireDaoimpl();


    @Override
    public boolean save(Commentaire commentaire) {

        if( commentaireDao.save(commentaire) ){
            return true;
        }
        return false;
    }

    @Override
    public List<Commentaire> getByIdPublication(int id) {
        return commentaireDao.getByIdPublication(id);
    }

    @Override
    public Commentaire get(int id) {
        return commentaireDao.get(id);
    }

    @Override
    public List<Commentaire> list() {
        return commentaireDao.list();
    }

    @Override
    public boolean update(Commentaire commentaire) {

        if( commentaireDao.update(commentaire) ){
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(int id) {

        Commentaire com=commentaireDao.get(id);

        if( commentaireDao.delete(com) ){
            return true;
        }
        return false;
    }
}
