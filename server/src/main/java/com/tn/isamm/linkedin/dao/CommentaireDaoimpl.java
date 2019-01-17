package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.Commentaire;
import com.tn.isamm.linkedin.entity.Competence;
import com.tn.isamm.linkedin.entity.JAime;
import com.tn.isamm.linkedin.repository.CommentaireRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CommentaireDaoimpl implements CommentaireDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Commentaire commentaire) {

        try{

            entityManager.persist(commentaire);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public Commentaire get(int id) {

        try {
            return entityManager.find(Commentaire.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Commentaire> getByIdPublication(int id) {

        try {
            String sql = "FROM Commentaire as commentaire WHERE commentaire.publication = "+id ;
            return (List<Commentaire>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Commentaire> list() {

        try {
            String sql = "FROM Commentaire as commentaire ORDER BY commentaire.date";
            System.out.println((List<Commentaire>)entityManager.createQuery(sql).getResultList());
            return (List<Commentaire>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(Commentaire commentaire) {

        CommentaireRepository repo = null;
        try{
            Commentaire comm = this.get(commentaire.getId());
            comm.setContenu(commentaire.getContenu());
            entityManager.remove(commentaire);
            entityManager.persist(comm);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Commentaire commentaire) {

        try{
            entityManager.remove(commentaire);

        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
