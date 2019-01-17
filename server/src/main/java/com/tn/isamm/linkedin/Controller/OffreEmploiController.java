package com.tn.isamm.linkedin.Controller;

import java.util.*;
import com.tn.isamm.linkedin.entity.*;
import com.tn.isamm.linkedin.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.*;

@Controller
@RequestMapping("api/offreEmploi")
public class OffreEmploiController {

    @Autowired
    private OffreEmploiService offreEmploiService;


    @Autowired
    private OffreUtilisateurService offreUtilisateurService;


    @GetMapping("get/{id}")
    public ResponseEntity<OffreEmploi> getById(@PathVariable("id") Integer id) {
        OffreEmploi offreEmploi = offreEmploiService.get(id);
        return new ResponseEntity<OffreEmploi>(offreEmploi, HttpStatus.OK);
    }

    @GetMapping("/getlastid")
    public ResponseEntity<OffreEmploi> getLastID() {
        OffreEmploi offreEmploi = offreEmploiService.getlastid();
        return new ResponseEntity<OffreEmploi>(offreEmploi, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<OffreEmploi>> getAll(@PathVariable("id") Integer id) {
        List<OffreEmploi> list = offreEmploiService.listOffre(id);
        return new ResponseEntity<List<OffreEmploi>>(list, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<OffreEmploi> addOffreEmploi(@RequestBody OffreEmploi offreEmploi, UriComponentsBuilder builder) {
        System.out.println(offreEmploi.gethashtag1());
        System.out.println(offreEmploi.gethashtag2());
        System.out.println(offreEmploi.gethashtag3());
        offreEmploiService.save(offreEmploi);
        return new ResponseEntity<OffreEmploi>(offreEmploi, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<OffreEmploi> updateOffreEmploi(@RequestBody OffreEmploi offreEmploi) {
        offreEmploiService.update(offreEmploi);
        return new ResponseEntity<OffreEmploi>(offreEmploi, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOffreEmploi(@PathVariable("id") Integer id) {
        offreEmploiService.delete(id);
        offreUtilisateurService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
