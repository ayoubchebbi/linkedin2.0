package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.JAime;

import java.util.List;

public interface JAimeDao {

    boolean save(JAime jaime);

    JAime get(int id);

    List<JAime> getByIdPublication(int id);

    List<JAime> list();

    boolean update(JAime jaime);

    boolean delete(JAime jaime);
}