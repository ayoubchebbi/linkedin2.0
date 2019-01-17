package com.tn.isamm.linkedin.dao;

import com.tn.isamm.linkedin.entity.*;
import java.util.*;

public interface OffreEmploiDao {
    boolean save(OffreEmploi offreEmploi);

    OffreEmploi getlastid();

    OffreEmploi get(int id);

    List<OffreEmploi> list();

    List<OffreEmploi> listOffre(int id);

    boolean update(OffreEmploi offreEmploi);

    boolean delete(OffreEmploi offreEmploi);
}
