package com.tn.isamm.linkedin.Controller;


import com.tn.isamm.linkedin.entity.OffreUtilisateur;
import com.tn.isamm.linkedin.entity.OffreUtilisateurId;
import com.tn.isamm.linkedin.service.OffreUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping(value="api/offreUtilisateur")
public class OffreUtilisateurController {

    @Autowired
    private OffreUtilisateurService offreUtilisateurService;

    @PostMapping("/add")
    public ResponseEntity<OffreUtilisateur> addUtilisateur(@RequestBody OffreUtilisateur offreUtilisateur, UriComponentsBuilder builder) {

        offreUtilisateurService.save(offreUtilisateur);
        return new ResponseEntity<OffreUtilisateur>(offreUtilisateur, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOffreUtilisateur(@PathVariable("id") Integer id) {
        offreUtilisateurService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
