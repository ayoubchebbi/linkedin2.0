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
@RequestMapping("api/message")
public class MessageController {
    @Autowired
    private MessageService messageService;


    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") Integer id) {
        Message message = messageService.get(id);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<Message>> getAll() {
        List<Message> list = messageService.list();
        return new ResponseEntity<List<Message>>(list, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Message> addmessage(@RequestBody Message message, UriComponentsBuilder builder) {
        messageService.save(message);
        return new ResponseEntity<Message>(message, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Message> updatemessage(@RequestBody Message message) {
        messageService.update(message);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }


    @DeleteMapping("/delete}")
    public ResponseEntity<Void> deletemessage(@RequestBody Message message) {
        messageService.delete(message);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
