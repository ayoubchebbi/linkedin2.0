package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotificationServiceImp implements NotificationService {
    @Autowired
    private NotificationDao notificationDao = new NotificationDaoimpl();


    @Override
    public boolean save(Notification notification) {

        if( notificationDao.save(notification) ){
            return true;
        }
        return false;
    }

    @Override
    public Notification get(int id) {

        return notificationDao.get(id);

    }

    @Override
    public List<Notification> list() {

        return notificationDao.list();

    }

    @Override
    public List<Notification> getbyuser(int id) {

        return notificationDao.getbyuser(id);

    }

    @Override
    public boolean update(Notification notification) {

        if( notificationDao.update(notification) ){
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Notification notification) {

        if( notificationDao.delete(notification) ){
            return true;
        }
        return false;
    }
}
