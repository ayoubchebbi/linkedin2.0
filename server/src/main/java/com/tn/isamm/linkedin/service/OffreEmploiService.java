package com.tn.isamm.linkedin.service;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface OffreEmploiService {
    boolean save(OffreEmploi offreEmploi);

    OffreEmploi get(int id);
    OffreEmploi getlastid();

    List<OffreEmploi> list();

    List<OffreEmploi> listOffre(int id);


    boolean update(OffreEmploi offreEmploi);

    boolean delete(int id);

}
