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
@RequestMapping("api/formation")
public class FormationController {
    @Autowired
    private FormationService formationService;
    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping("/{id}")
    public ResponseEntity<Formation> getById(@PathVariable("id") Integer id) {
        Formation formation = formationService.get(id);
        return new ResponseEntity<Formation>(formation, HttpStatus.OK);
    }




    @GetMapping("/get/{id_user}")
    public ResponseEntity<List<Formation>> getUserById(@PathVariable("id_user") Integer id) {

        Utilisateur user = utilisateurService.get(id);
        System.out.println(user);
        List <Formation> formation = formationService.getUserId(user);
        return new ResponseEntity<List<Formation>>(formation, HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<Formation>> getAll() {
        List<Formation> list = formationService.list();
        return new ResponseEntity<List<Formation>>(list, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Formation> addformation(@RequestBody Formation formation, UriComponentsBuilder builder) {
        formationService.save(formation);
        return new ResponseEntity<Formation>(formation, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Formation> updateformation(@RequestBody Formation formation) {
        formationService.update(formation);
        return new ResponseEntity<Formation>(formation, HttpStatus.OK);
    }


    @DeleteMapping("/delete}")
    public ResponseEntity<Void> deleteFormation(@RequestBody Formation formation) {
        formationService.delete(formation);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
