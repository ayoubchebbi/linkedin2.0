package com.tn.isamm.linkedin.Controller;

import com.tn.isamm.linkedin.security.JwtGenerator;
import com.tn.isamm.linkedin.service.UtilisateurService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tn.isamm.linkedin.entity.Utilisateur;

import java.util.List;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/register")
public class RegisterController {
    private String token="false";
    private JSONObject result = null;
    private JSONArray array = null;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private JwtGenerator jwt;

    @PostMapping
    public String register(@RequestBody Utilisateur registeruser) throws JSONException {
        utilisateurService.save(registeruser);

        token="where";
        String jwtToken="";
        List list  = utilisateurService.findUserByEmailAndpassword(registeruser.getEmail(),registeruser.getMotDePasse());
        if(list.size()>0) {
            Utilisateur obj=(Utilisateur)list.get(0);
            result = new JSONObject();
            array = new JSONArray();

            Utilisateur login =new Utilisateur();
            login.setId(Integer.parseInt(obj.getId().toString()));
            login.setEmail(obj.getEmail());

            if(login!=null){
                jwtToken = jwt.generate(login);
                array.put(jwtToken);
                JSONObject jo = new JSONObject();
                jo.put("id", obj.getId());
                jo.put("email", obj.getEmail());
                jo.put("nom", obj.getNom());
                jo.put("prenom", obj.getPrenom());
                jo.put("role", obj.getRole());
                jo.put("titre_profil", obj.getTitreProfil());
                jo.put("image_path", obj.getImage_path());
                jo.put("description", obj.getDescription());
                array.put(jo);
                result.put("data",array);
            }
            token=result.toString();
        }
        return token;
        //return new ResponseEntity<Utilisateur>(registeruser, HttpStatus.CREATED);
    }
}