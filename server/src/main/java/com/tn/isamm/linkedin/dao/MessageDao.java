package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface MessageDao {
    boolean save(Message message);

    Message get(int id);

    List<Message> list();

    boolean update(Message message);

    boolean delete(Message message);
}
