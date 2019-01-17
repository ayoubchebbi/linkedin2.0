package com.tn.isamm.linkedin.dao;


import com.tn.isamm.linkedin.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class NotificationDaoimpl implements NotificationDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Notification notification) {

        try{
            entityManager.persist(notification);

        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public Notification get(int id) {

        try {
            return entityManager.find(Notification.class,id);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Notification> list() {

        try {
            String sql = "FROM Notification as notification ORDER BY notification.id";
            return (List<Notification>)entityManager.createQuery(sql).getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Notification> getbyuser(int id) {
        System.out.println(id);
        try {
            String sql = "FROM Notification as notification WHERE notification.utilisateur1.id LIKE :id ORDER BY notification.id";
            return (List<Notification>)entityManager.createQuery(sql)
            .setParameter("id", id)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public boolean update(Notification notification) {

        try{


        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean delete(Notification notification) {

        try{
            entityManager.remove(notification);

        }catch(Exception ex){
            return false;
        }
        return true;    }
}
