package com.tn.isamm.linkedin.repository;

import com.tn.isamm.linkedin.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
}
