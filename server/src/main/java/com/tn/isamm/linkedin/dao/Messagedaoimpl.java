package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import javax.persistence.*;
import java.util.*;



@Transactional
@Repository
public class Messagedaoimpl implements MessageDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Message message) {

        try{

            entityManager.persist(message);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public Message get(int id) {

        try {
            return entityManager.find(Message.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Message> list() {

        try {
            String sql = "FROM Message as message ORDER BY message.id";
            return (List<Message>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(Message message) {

        try{


        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(Message message) {

        try{
            entityManager.remove(message);

        }catch(Exception ex){
            return false;
        }
        return true;    }
}
