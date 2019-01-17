package com.tn.isamm.linkedin.Controller;

import java.util.*;
import com.tn.isamm.linkedin.entity.*;
import com.tn.isamm.linkedin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.*;

@CrossOrigin
@RestController
@RequestMapping("api/utilisateur")
public class UtilisateurController {


    @Autowired
    private UtilisateurService utilisateurService ;


    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getById(@PathVariable("id") Integer id) {
        Utilisateur utilisateur = utilisateurService.get(id);
        return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<Utilisateur>> getAll() {
        List<Utilisateur> list = utilisateurService.list();
        return new ResponseEntity<List<Utilisateur>>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur, UriComponentsBuilder builder) {
        utilisateurService.save(utilisateur);
        return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.update(utilisateur);
        return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
    }


    @DeleteMapping("/delete}")
    public ResponseEntity<Void> deleteUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.delete(utilisateur);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
