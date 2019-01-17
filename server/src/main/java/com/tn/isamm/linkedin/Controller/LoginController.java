package com.tn.isamm.linkedin.Controller;

import java.util.List;

import com.tn.isamm.linkedin.service.UtilisateurService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.efive.visitormanagement.model.LoginModel;
import com.tn.isamm.linkedin.entity.Utilisateur;
import com.tn.isamm.linkedin.security.JwtGenerator;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/login")
public class LoginController {
	private JSONObject result = null;
	private JSONArray array = null;
	private String token="false";

	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private JwtGenerator jwt;

	@PostMapping
	public String login(@RequestBody Utilisateur loginuser) throws JSONException {
		String jwtToken="";
		if(loginuser!=null)
			if (StringUtils.isEmpty(loginuser.getEmail())||loginuser.getEmail()==null || StringUtils.isEmpty(loginuser.getMotDePasse())||loginuser.getMotDePasse()==null) {
				token="why";
			}
		if (utilisateurService.findUserByemail(loginuser.getEmail()) == null||utilisateurService.findUserByemail(loginuser.getEmail()).isEmpty()){
			token="yes";
		}
		else
		{
			token="where";
			List list  = utilisateurService.findUserByEmailAndpassword(loginuser.getEmail(),loginuser.getMotDePasse());
			System.out.println("list");
			System.out.println(list);
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
		}
		return token;
	}
}