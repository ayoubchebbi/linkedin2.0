package com.tn.isamm.linkedin.Controller;

import java.util.*;
import com.tn.isamm.linkedin.entity.*;
import com.tn.isamm.linkedin.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.*;


@RestController
@RequestMapping({"api/publication"})
public class PublicationController {

    @Autowired
    private PublicationService publicationService;
    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping("/{id}")
    public ResponseEntity<Publication> getById(@PathVariable("id") Integer id) {
        Publication publication = publicationService.get(id);
        return new ResponseEntity<Publication>(publication, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<Publication>> getAll() {
        List<Publication> list = publicationService.list();
        return new ResponseEntity<List<Publication>>(list, HttpStatus.OK);
    }


    @GetMapping("/get/{id_user}")
    public ResponseEntity<List<Publication>> getUserById(@PathVariable("id_user") Integer id) {

        Utilisateur user = utilisateurService.get(id);
        System.out.println(user);
        List <Publication> publication = publicationService.getUserId(user);
        return new ResponseEntity<List<Publication>>(publication, HttpStatus.OK);

    }


    @PostMapping("/add")
    public ResponseEntity<Publication> addPublication(@RequestBody Publication publication, UriComponentsBuilder builder) {
        publicationService.save(publication);
        return new ResponseEntity<Publication>(publication, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Publication> updatePublication(@RequestBody Publication publication) {
        publicationService.update(publication);
        return new ResponseEntity<Publication>(publication, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable("id") Integer id) {
        publicationService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
