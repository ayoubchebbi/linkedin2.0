package com.tn.isamm.linkedin.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.*;
import com.tn.isamm.linkedin.entity.*;

@RepositoryRestResource(exported = false)
public interface PublicationRepository extends JpaRepository<Publication, Integer> {

}