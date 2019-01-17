package com.tn.isamm.linkedin.Controller;

import com.tn.isamm.linkedin.entity.Commentaire;
import com.tn.isamm.linkedin.entity.JAime;
import com.tn.isamm.linkedin.service.CommentaireService;
import com.tn.isamm.linkedin.service.JAimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping({"api/jaime"})
public class JAimeController {


    @Autowired
    private JAimeService jaimeService;


    @GetMapping("/{id}")
    public ResponseEntity<JAime> getById(@PathVariable("id") Integer id) {
        JAime jaime = jaimeService.get(id);
        return new ResponseEntity<JAime>(jaime, HttpStatus.OK);
    }


    @GetMapping("/jaimepub/{id}")
    public ResponseEntity<List<JAime>> getByIdPublication(@PathVariable("id") Integer id) {
        List<JAime> list = jaimeService.getByIdPublication(id);
        return new ResponseEntity<List<JAime>>(list, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<JAime>> getAll() {
        List<JAime> list = jaimeService.list();
        return new ResponseEntity<List<JAime>>(list, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<JAime> addJAime(@RequestBody JAime jaime, UriComponentsBuilder builder) {
        jaimeService.save(jaime);
        return new ResponseEntity<JAime>(jaime, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<JAime> updateJAime(@RequestBody JAime jaime) {
        jaimeService.update(jaime);
        return new ResponseEntity<JAime>(jaime, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJAime(@PathVariable("id") Integer id) {
        jaimeService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

