package com.tn.isamm.linkedin.repository;

import com.tn.isamm.linkedin.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.*;


@RepositoryRestResource(exported = false)
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}