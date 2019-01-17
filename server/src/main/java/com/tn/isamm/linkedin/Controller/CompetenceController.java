package com.tn.isamm.linkedin.Controller;

import com.tn.isamm.linkedin.entity.*;
import com.tn.isamm.linkedin.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.*;
import java.util.*;

@Controller
@RequestMapping("api/competence")
public class CompetenceController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private CompetenceService competenceService;


    @GetMapping("/{id}")
    public ResponseEntity<Competence> getById(@PathVariable("id") Integer id) {
        Competence competence = competenceService.get(id);
        return new ResponseEntity<Competence>(competence, HttpStatus.OK);
    }

    @GetMapping("/get/{id_user}")
    public ResponseEntity<List<Competence>> getUserById(@PathVariable("id_user") Integer id) {
        Utilisateur user = utilisateurService.get(id);
        System.out.println("*** comp controller before user");
        System.out.println(user);
        System.out.println("*** comp controller after user");
        List <Competence> competence = competenceService.getUserId(user);
        System.out.println("*** comp controller after list comp");
        return new ResponseEntity<List<Competence>>(competence, HttpStatus.OK);

    }


    @GetMapping("/")
    public ResponseEntity<List<Competence>> getAll() {
        List<Competence> list = competenceService.list();
        return new ResponseEntity<List<Competence>>(list, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Competence> addCompetence(@RequestBody Competence competence, UriComponentsBuilder builder) {
        competenceService.save(competence);
        return new ResponseEntity<Competence>(competence, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Competence> updateCompetence(@RequestBody Competence competence) {
        competenceService.update(competence);
        return new ResponseEntity<Competence>(competence, HttpStatus.OK);
    }


    @DeleteMapping("/delete}")
    public ResponseEntity<Void> deleteCompetence(@RequestBody Competence competence) {
        competenceService.delete(competence);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
