package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.JAime;

import java.util.List;

public interface JAimeService {


    boolean save(JAime jaime);

    JAime get(int id);

    List<JAime> list();

    List<JAime> getByIdPublication(int id);

    boolean update(JAime jaime);

    boolean delete(int id);
}