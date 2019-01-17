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
@RequestMapping("api/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping("/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") Integer id) {
        Experience experience = experienceService.get(id);
        return new ResponseEntity<Experience>(experience, HttpStatus.OK);
    }


    @GetMapping("/get/{id_user}")
    public ResponseEntity<List<Experience>> getUserById(@PathVariable("id_user") Integer id) {

        Utilisateur user = utilisateurService.get(id);
        List <Experience> experience = experienceService.getUserId(user);
        return new ResponseEntity<List<Experience>>(experience, HttpStatus.OK);

    }


    @GetMapping("/")
    public ResponseEntity<List<Experience>> getAll() {
        List<Experience> list = experienceService.list();
        return new ResponseEntity<List<Experience>>(list, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience, UriComponentsBuilder builder) {
        experienceService.save(experience);
        return new ResponseEntity<Experience>(experience, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Experience> updateExperience(@RequestBody Experience experience) {
        experienceService.update(experience);
        return new ResponseEntity<Experience>(experience, HttpStatus.OK);
    }


    @DeleteMapping("/delete}")
    public ResponseEntity<Void> deleteExperience(@RequestBody Experience experience) {
        experienceService.delete(experience);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
