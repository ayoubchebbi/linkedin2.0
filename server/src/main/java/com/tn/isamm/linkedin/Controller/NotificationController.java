package com.tn.isamm.linkedin.Controller;

import com.tn.isamm.linkedin.entity.*;
import com.tn.isamm.linkedin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @GetMapping("/{id}")
    public ResponseEntity<Notification> getById(@PathVariable("id") Integer id) {
        Notification notification = notificationService.get(id);
        return new ResponseEntity<Notification>(notification, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<Notification>> getAll() {
        List<Notification> list = notificationService.list();
        System.out.println(list);
        return new ResponseEntity<List<Notification>>(list, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Notification>> getAllbyuser(@PathVariable("id") Integer id) {
        List<Notification> list = notificationService.getbyuser(id);
        return new ResponseEntity<List<Notification>>(list, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Notification> addNotification(@RequestBody Notification notification, UriComponentsBuilder builder) {
        System.out.println(notification);
        notificationService.save(notification);
        return new ResponseEntity<Notification>(notification, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Notification> updateNotification(@RequestBody Notification notification) {
        notificationService.update(notification);
        return new ResponseEntity<Notification>(notification, HttpStatus.OK);
    }


    @DeleteMapping("/delete}")
    public ResponseEntity<Void> deleteNotification(@RequestBody Notification notification) {
        notificationService.delete(notification);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
