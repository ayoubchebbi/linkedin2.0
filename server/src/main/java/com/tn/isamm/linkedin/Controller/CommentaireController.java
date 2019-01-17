package com.tn.isamm.linkedin.Controller;


import com.tn.isamm.linkedin.entity.*;
import com.tn.isamm.linkedin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping({"api/commentaire"})
public class CommentaireController {


    @Autowired
    private CommentaireService commentaireService;


    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getById(@PathVariable("id") Integer id) {
        Commentaire commentaire = commentaireService.get(id);
        return new ResponseEntity<Commentaire>(commentaire, HttpStatus.OK);
    }


    @GetMapping("/commentairepub/{id}")
    public ResponseEntity<List<Commentaire>> getByIdPublication(@PathVariable("id") Integer id) {
        List<Commentaire> list = commentaireService.getByIdPublication(id);
        return new ResponseEntity<List<Commentaire>>(list, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Commentaire>> getAll() {
        List<Commentaire> list = commentaireService.list();
        return new ResponseEntity<List<Commentaire>>(list, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Commentaire> addCommentaire(@RequestBody Commentaire commentaire, UriComponentsBuilder builder) {
        commentaireService.save(commentaire);
        return new ResponseEntity<Commentaire>(commentaire, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Commentaire> updateCommentaire(@RequestBody Commentaire commentaire) {
        commentaireService.update(commentaire);
        return new ResponseEntity<Commentaire>(commentaire, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable("id") Integer id) {
        commentaireService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
