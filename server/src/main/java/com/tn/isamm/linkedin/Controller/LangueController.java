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
@RequestMapping("api/langue")
public class LangueController {
    @Autowired
    private LangueService langueService;
    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping("/{id}")
    public ResponseEntity<Langue> getById(@PathVariable("id") Integer id) {
        Langue langue = langueService.get(id);
        return new ResponseEntity<Langue>(langue, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<Langue>> getAll() {
        List<Langue> list = langueService.list();
        return new ResponseEntity<List<Langue>>(list, HttpStatus.OK);
    }

    @GetMapping("/get/{id_user}")
    public ResponseEntity<List<Langue>> getUserById(@PathVariable("id_user") Integer id) {

        Utilisateur user = utilisateurService.get(id);
        List <Langue> langue = langueService.getUserId(user);
        return new ResponseEntity<List<Langue>>(langue, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Langue> addlangue(@RequestBody Langue langue, UriComponentsBuilder builder) {
        langueService.save(langue);
        return new ResponseEntity<Langue>(langue, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Langue> updatelangue(@RequestBody Langue langue) {
        langueService.update(langue);
        return new ResponseEntity<Langue>(langue, HttpStatus.OK);
    }


    @DeleteMapping("/delete}")
    public ResponseEntity<Void> deletelangue(@RequestBody Langue langue) {
        langueService.delete(langue);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
