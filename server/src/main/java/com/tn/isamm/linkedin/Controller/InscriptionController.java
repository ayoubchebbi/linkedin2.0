package com.tn.isamm.linkedin.Controller;

import com.tn.isamm.linkedin.entity.Utilisateur;
import com.tn.isamm.linkedin.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("inscription")
public class InscriptionController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/add")
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur, UriComponentsBuilder builder) {
        utilisateurService.save(utilisateur);
        return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.CREATED);
    }

}


