package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface NotificationService {


    boolean save(Notification notification);

    Notification get(int id);

    List<Notification> getbyuser(int id);

    List<Notification> list();

    boolean update(Notification notification);

    boolean delete(Notification notification);
}
