package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;


@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    private MessageDao messageDao = new Messagedaoimpl();


    @Override
    public boolean save(Message message) {

        if( messageDao.save(message) ){
            return true;
        }
        return false;
    }

    @Override
    public Message get(int id) {

        return messageDao.get(id);

    }

    @Override
    public List<Message> list() {

        return messageDao.list();

    }

    @Override
    public boolean update(Message message) {

        if( messageDao.update(message) ){
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Message message) {

        if( messageDao.delete(message) ){
            return true;
        }
        return false;
    }
}
