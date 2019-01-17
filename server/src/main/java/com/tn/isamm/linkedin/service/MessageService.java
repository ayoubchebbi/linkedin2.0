package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface MessageService {


    boolean save(Message message);

    Message get(int id);

    List<Message> list();

    boolean update(Message message);

    boolean delete(Message message);
}
