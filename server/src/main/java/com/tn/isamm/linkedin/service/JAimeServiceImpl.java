package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.dao.*;
import com.tn.isamm.linkedin.entity.*;
import com.tn.isamm.linkedin.entity.JAime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JAimeServiceImpl implements JAimeService{

    @Autowired
    private JAimeDao jaimeDao = new JAimeDaoimpl();


    @Override
    public boolean save(JAime jaime) {

        if( jaimeDao.save(jaime) ){
            return true;
        }
        return false;
    }

    @Override
    public JAime get(int id) {
        return jaimeDao.get(id);
    }

    @Override
    public List<JAime> list() {
        return jaimeDao.list();
    }

    @Override
    public List<JAime> getByIdPublication(int id) {
        return jaimeDao.getByIdPublication(id);
    }

    @Override
    public boolean update(JAime jaime) {
        return false;
    }

    @Override
    public boolean delete(int id) {

        JAime jm=jaimeDao.get(id);

        if( jaimeDao.delete(jm) ){
            return true;
        }
        return false;
    }
}
