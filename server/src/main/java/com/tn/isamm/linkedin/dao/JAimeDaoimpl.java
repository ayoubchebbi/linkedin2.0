package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.Experience;
import com.tn.isamm.linkedin.entity.JAime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class JAimeDaoimpl implements JAimeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(JAime jaime) {

        try{

            entityManager.persist(jaime);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public JAime get(int id) {

        try {
            return entityManager.find(JAime.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<JAime> getByIdPublication(int id) {

        try {
            String sql = "FROM JAime as jaime WHERE jaime.publication = "+id ;
            return (List<JAime>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<JAime> list() {

        try {
            String sql = "FROM JAime as jaime ORDER BY jaime.id";
            return (List<JAime>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(JAime jaime) {

        try{


            this.delete(jaime);
            this.save(jaime);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(JAime jaime) {

        try{
            entityManager.remove(jaime);

        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
