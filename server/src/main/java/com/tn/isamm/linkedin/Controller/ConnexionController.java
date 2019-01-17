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
@RequestMapping("api/connexion")
public class ConnexionController {

    @Autowired
    private ConnexionService connexionService;


    @GetMapping("/get/{id}")
    public ResponseEntity<Connexion> getById(@PathVariable("id") Integer id) {
        Connexion connexion = connexionService.get(id);
        System.out.println(connexion);
        return new ResponseEntity<Connexion>(connexion, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<Connexion>> getAll() {
        /*List<Connexion> list = connexionService.list();
        return new ResponseEntity<List<Connexion>>(list, HttpStatus.OK);*/
        List<Connexion> list = connexionService.list();
        return new ResponseEntity<List<Connexion>>(list, HttpStatus.OK);
    }

    @GetMapping("/GetByIds/{id1}/{id2}")
    public ResponseEntity<Connexion> getConnexion(@PathVariable("id1") Integer id1,@PathVariable("id2") Integer id2) {
        List<Connexion> connexion = null;
        Connexion conn = null;
        connexion = connexionService.getByIds(id1,id2);
        System.out.println("connexion  "+connexion);
        if(connexion == null){
            System.out.println("controller cnx  = null");
            System.out.println("controller conn " +conn);
            return new ResponseEntity<Connexion>(conn, HttpStatus.OK);
        }else{
            System.out.println("controller cnx  != null");
            return new ResponseEntity<Connexion>(connexion.get(0), HttpStatus.OK);
        }

    }

    @GetMapping("/List_amis/{id}")
    public ResponseEntity<List<Connexion>> getAllFriends(@PathVariable("id") Integer id) {
        List<Connexion> list = connexionService.list_amis(id);
        return new ResponseEntity<List<Connexion>>(list, HttpStatus.OK);
    }

    @GetMapping("/List_amis2/{id}")
    public ResponseEntity<List<Connexion>> getAllFriends2(@PathVariable("id") Integer id) {
        List<Connexion> list = connexionService.list_amis2(id);
        return new ResponseEntity<List<Connexion>>(list, HttpStatus.OK);
    }

    @GetMapping("/recommended_friends/{id}")
    public ResponseEntity<List<Connexion>> getAllRecommendations(@PathVariable("id") Integer id) {
        List<Connexion> list = connexionService.friends_recommended(id);
        return new ResponseEntity<List<Connexion>>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Connexion> addConnexion(@RequestBody Connexion connexion, UriComponentsBuilder builder) {
        connexionService.save(connexion);
        return new ResponseEntity<Connexion>(connexion, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Connexion> updateConnexion(@RequestBody Connexion connexion) {
        System.out.println("Controller ");
        System.out.println("id1 "+connexion.getUtilisateurByIdUtilisateur1().getId());
        System.out.println("id2 "+connexion.getUtilisateurByIdUtilisateur2().getId());
        connexionService.update(connexion);
        return new ResponseEntity<Connexion>(connexion, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteConnexion(@PathVariable("id") Integer id) {
        Connexion connexion = connexionService.get(id);
        connexionService.delete(connexion);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
