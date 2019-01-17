import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ConnexionService} from '../../_services/connexion/connexion.service';
import {UserService} from '../../_services/user/user.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Formation} from '../../_model/Formation';
import {FormationService} from '../../_services/formation/formation.service';
import {Utilisateur} from '../../_model/utilisateur.model';
import {Competence} from '../../_model/Competence';
import {CompetenceService} from '../../_services/competence/competence.service';
import {Experience} from '../../_model/Experience';
import {ExperienceService} from '../../_services/experience/experience.service';
import {Langue} from '../../_model/Langue';
import {LangueService} from '../../_services/langue/langue.service';
import {Publication} from '../../_model/Publication';
import {PublicationService} from '../../_services';
import {NotificationService} from '../../_services/notification/notification.service';
import {Connexion} from '../../_model/Connexion';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  id_user=0 ;
  cli=false;
  cli2=false;
  idupdate: Number;
  show = false;
  current_user=JSON.parse(localStorage.getItem('currentUser'))[1].id;
  user_id_profile=null;
  postForm: FormGroup;
  postForm2: FormGroup;
  clickedFormEdit=false;
  clickedFormAdd=false;
  clickedFormAddFirst=false;
  formation_clicked=null;
  clickedExpAdd=false;
  clickedExpEdit=false;
  clickedExpAddFirst=false;
  experience_clicked=null;
  clickedCompAdd=false;
  clickedCompEdit=false;
  clickedCompAddFirst=false;
  competence_clicked=null;
  clickedLangAdd=false;
  clickedLangEdit=false;
  clickedLangAddFirst=false;
  langue_clicked=null;
  user: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  competence: Competence[];
  formation: Formation[];
  experience: Experience[];
  langue: Langue[];
  publications: Publication[];
  connexions: Connexion[];
  connexions2: Connexion[];
  connexion: Connexion = null;
  number_follwers=0;
  number_follwing=0;
  user2: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];

  constructor(private router: Router, private activatedRoute: ActivatedRoute,
              private formationService: FormationService, private competenceService: CompetenceService, private experienceService: ExperienceService,
              private langueService: LangueService,private notificationService: NotificationService,
              private publicationService: PublicationService, private userService: UserService, private connexionService: ConnexionService, private formBuilder: FormBuilder)
  { }


  ngOnInit() {

    this.activatedRoute.params.subscribe(params => {
      this.user_id_profile = Number.parseInt(params['id']);
    });

   //this.activatedRoute.queryParams.subscribe(params => { this.user_id_profile = params['id']; })

   // const following = this.connexions.length + this.connexions2.length;

    this.postForm2 = this.formBuilder.group({
      contenu: ['', Validators.required]
    });


    this.postForm = this.formBuilder.group({
      ecole: ['', Validators.required],
      diplome: ['', Validators.required],
      discipline: ['', Validators.required],
      description: ['', Validators.required],
      dateDebut: ['', Validators.required],
      dateFin: ['', Validators.required],
      Newecole: ['', Validators.required],
      Newdiplome: ['', Validators.required],
      Newdiscipline: ['', Validators.required],
      Newdescription: ['', Validators.required],
      Newdatedebut: ['', Validators.required],
      Newdatefin: ['', Validators.required],
      Firstecole: ['', Validators.required],
      Firstdiscipline: ['', Validators.required],
      Firstdiplome: ['', Validators.required],
      Firstdescription: ['', Validators.required],
      FirstdateDebut: ['', Validators.required],
      FirstdateFin: ['', Validators.required],
      cause: ['', Validators.required],
      role: ['', Validators.required],
      descriptionExp: ['', Validators.required],
      dateDebutExp: ['', Validators.required],
      dateFinExp: ['', Validators.required],
      Newrole: ['', Validators.required],
      Newcause: ['', Validators.required],
      NewdescriptionExp: ['', Validators.required],
      NewdatedebutExp: ['', Validators.required],
      NewdatefinExp: ['', Validators.required],
      Firstcause: ['', Validators.required],
      Firstrole: ['', Validators.required],
      FirstdescriptionExp: ['', Validators.required],
      FirstdateDebutExp: ['', Validators.required],
      FirstdateFinExp: ['', Validators.required],
      skill: ['', Validators.required],
      Newskill: ['', Validators.required],
      Firstskill: ['', Validators.required],
      lang: ['', Validators.required],
      niveau: ['', Validators.required],
      Newlang: ['', Validators.required],
      Newniveau: ['', Validators.required],
      Firstlang: ['', Validators.required],
      Firstniveau: ['', Validators.required]
    });



    if (this.user_id_profile){
      this.id_user=parseInt(this.user_id_profile);
    }
   else
      this.id_user=JSON.parse(localStorage.getItem('currentUser'))[1].id;

    console.log(this.id_user);
    this.userService.getUserById(this.id_user).subscribe( (data:any) => {
     this.user = data;
    });

    this.formationService.getFormationUser(this.id_user)
      .subscribe( data => {
        this.formation = data;
      });
    this.competenceService.getCompetenceUser(this.id_user)
      .subscribe( data => {
        this.competence = data;
      });
    this.experienceService.getExperienceUser(this.id_user)
      .subscribe( data => {
        this.experience = data;
      });
    this.langueService.getLangueUser(this.id_user)
      .subscribe( data => {
        this.langue = data;
      });

    this.publicationService.getPublicationUser(this.id_user)
      .subscribe( data => {
        this.publications = data;
      });

    this.connexionService.getConnexionByIds(JSON.parse(localStorage.getItem('currentUser'))[1].id, this.id_user)
      .subscribe( data => {
        this.connexion = data;
      });
    this.connexionService.getConnexions(this.id_user)
      .subscribe( data => {
        console.log(data);
        this.connexions = data;
      });
    this.connexionService.getConnexions2(this.id_user)
      .subscribe( data => {
        console.log(data);
        this.connexions2 = data;
      });
    console.log(this.connexions);
    console.log(this.connexions2);
  }



  get f() { return this.postForm.controls; }

  get f2() { return this.postForm2.controls; }


  formation_cli(forma){
    this.formation_clicked=forma;
    return null;
  }
  experience_cli(exp){
    this.experience_clicked=exp;
    return null;
  }
  competence_cli(comp){
    this.competence_clicked=comp;
    return null;
  }
  langue_cli(lang){
    this.langue_clicked=lang;
    return null;
  }
  number_follwers_fun(connexions2?){
    if(connexions2)
    this.number_follwers=connexions2.length;
    else
      this.number_follwers=0;
    return this.number_follwers;
  }
  number_follwing_fun(connexions?){
    if(connexions)
    this.number_follwing=connexions.length;
    else
      this.number_follwing=0;
    return this.number_follwing;
  }




  create_formation() {

    const id_user=parseInt(this.current_user);
    const format = {'utilisateur': this.user, 'ecole': this.f.ecole.value,
      'diplome': this.f.diplome.value, 'discipline': this.f.discipline.value,'description': this.f.description.value,
      'dateDebut': this.f.dateDebut.value, 'dateFin': this.f.dateFin.value};
    this.formationService.createFormation(format).subscribe();
    this.formation.push(format);
    this.postForm.reset();
    console.log(format);

    setTimeout(() => this.formationService.getFormationUser(id_user)
      .subscribe( data => {
        this.formation =data;
      }), 500)


  }
  First_create_formation() {

    //const id = JSON.parse(localStorage.getItem('currentUser'))[1].id;
    const id_user=parseInt(this.current_user);
    const format = {'utilisateur': this.user, 'ecole': this.f.Firstecole.value,
      'diplome': this.f.Firstdiplome.value, 'discipline': this.f.Firstdiscipline.value,'description': this.f.Firstdescription.value,
      'dateDebut': this.f.FirstdateDebut.value, 'dateFin': this.f.FirstdateFin.value};
    this.formationService.createFormation(format).subscribe();
    this.formation.push(format);
    this.postForm.reset();
    console.log(format);

    setTimeout(() => this.formationService.getFormationUser(id_user)
      .subscribe( data => {
        this.formation =data;
      }), 500)


  }

  update_formation(formatio) {
    const id_user=parseInt(this.current_user);
    console.log(this.formation);
    console.log(formatio.id);
    const format={'id':formatio.id,  'utilisateur': formatio.utilisateur,'ecole':this.f.Newecole.value,'diplome':this.f.Newdiplome.value,
                  'discipline':this.f.Newdiscipline.value, 'description':this.f.Newdescription.value,'dateDebut':this.f.Newdatedebut.value,
                  'dateFin':this.f.Newdatefin.value};
    this.formationService.updateFormation(format).subscribe();
    const i = this.formation.indexOf(formatio);
    this.formation.splice(i,1);
    //this.formation.push(format);
    this.formation.splice(i,0,format);

  }

  First_create_experience() {


    const id_user=parseInt(this.current_user);
    const exper = {'utilisateur': this.user, 'cause': this.f.Firstcause.value,'role': this.f.Firstrole.value,
      'description': this.f.FirstdescriptionExp.value, 'dateDebut': this.f.FirstdateDebutExp.value, 'dateFin': this.f.FirstdateFinExp.value};
    this.experienceService.createExperience(exper).subscribe();
    this.experience.push(exper);
    this.postForm.reset();
    console.log(exper);

    setTimeout(() => this.experienceService.getExperienceUser(id_user)
      .subscribe( data => {
        this.experience =data;
      }), 500)


  }


  create_experience() {


    const id_user=parseInt(this.current_user);
    const exper = {'utilisateur': this.user, 'cause': this.f.cause.value,'role': this.f.role.value, 'description': this.f.descriptionExp.value,
                   'dateDebut': this.f.dateDebutExp.value, 'dateFin': this.f.dateFinExp.value};
    this.experienceService.createExperience(exper).subscribe();
    this.experience.push(exper);
    this.postForm.reset();
    console.log(exper);

    setTimeout(() => this.experienceService.getExperienceUser(id_user)
      .subscribe( data => {
        this.experience =data;
      }), 500)


  }

  update_experience(exper) {
    console.log(exper);
    console.log(this.f.Newrole.value);
    const id_user=parseInt(this.user_id_profile);
    const exp={'id':exper.id,  'utilisateur': exper.utilisateur,'role':this.f.Newrole.value,'cause':this.f.Newcause.value,
               'dateDebut':this.f.NewdatedebutExp.value,'dateFin':this.f.NewdatefinExp.value,'description':this.f.NewdescriptionExp.value};
    this.experienceService.updateExperience(exp).subscribe();
    const i = this.experience.indexOf(exper);
    this.experience.splice(i,1);
    //this.experience.push(exp);
    this.experience.splice(i,0,exp);

  }
  First_create_competence() {


    const id_user=parseInt(this.current_user);
    const comp = {'utilisateur': this.user, 'nomCompetence': this.f.Firstskill.value};
    this.competenceService.createCompetence(comp).subscribe();
    this.competence.push(comp);
    this.postForm.reset();
    console.log(comp);

    setTimeout(() => this.competenceService.getCompetenceUser(id_user)
      .subscribe( data => {
        this.competence =data;
      }), 500)


  }

  create_competence() {


    const id_user=parseInt(this.current_user);
    const comp = {'utilisateur': this.user, 'nomCompetence': this.f.skill.value};
    this.competenceService.createCompetence(comp).subscribe();
    this.competence.push(comp);
    this.postForm.reset();
    console.log(comp);

    setTimeout(() => this.competenceService.getCompetenceUser(id_user)
      .subscribe( data => {
        this.competence =data;
      }), 500)


  }

  update_competence(compt) {
    const id_user=parseInt(this.current_user);
    const comp={'id':compt.id,  'utilisateur': compt.utilisateur,'nomCompetence':this.f.Newskill.value};
    this.competenceService.updateCompetence(comp).subscribe();
    const i = this.competence.indexOf(compt);
    this.competence.splice(i,1);
    //this.competence.push(comp);
    this.competence.splice(i,0,comp);

  }

  First_create_langue() {


    const id_user=parseInt(this.current_user);
    const langu = {'utilisateur': this.user, 'lang': this.f.Firstlang.value, 'niveau': this.f.Firstniveau.value};
    this.langueService.createLangue(langu).subscribe();
    this.langue.push(langu);
    this.postForm.reset();
    console.log(langu);

    setTimeout(() => this.langueService.getLangueUser(id_user)
      .subscribe( data => {
        this.langue =data;
      }), 500)


  }

  create_langue() {


    const id_user=parseInt(this.current_user);
    const langu = {'utilisateur': this.user, 'lang': this.f.lang.value,'niveau': this.f.niveau.value};
    this.langueService.createLangue(langu).subscribe();
    this.langue.push(langu);
    this.postForm.reset();
    console.log(langu);

    setTimeout(() => this.langueService.getLangueUser(id_user)
      .subscribe( data => {
        this.langue =data;
      }), 500)


  }

  toggle(commentaire) {
    this.show = false;
    this.show = true;
    this.idupdate = commentaire.id;
  }

  delete_postulation(publication: Publication) {
    this.publicationService.deletePublication(publication.id)
      .subscribe( data => {
        this.publications = this.publications.filter(u => u !== publication);
      });
  }

  update_langue(language) {
    const id_user=parseInt(this.current_user);
    const langu={'id':language.id,  'utilisateur': language.utilisateur,'lang':this.f.Newlang.value,'niveau':this.f.Newniveau.value};
    this.langueService.updateLangue(langu).subscribe();
    const i = this.langue.indexOf(language);
    this.langue.splice(i,1);
    //this.langue.push(langu);
    this.langue.splice(i,0,langu);

  }



  delete_connexion() {
    const id = JSON.parse(localStorage.getItem('currentUser'))[1].id;
    const connexion = { 'utilisateurByIdUtilisateur1': {'id': id}  , 'utilisateurByIdUtilisateur2': {'id': 6}};
    this.connexionService.deleteConnexion(connexion).subscribe();
  }


  update_Connexion() {
    console.log('profile.component.ts');
    const id = JSON.parse(localStorage.getItem('currentUser'))[1].id;
    const connexion = { 'id': this.connexion.id , 'utilisateurByIdUtilisateur1': {'id': id}  , 'utilisateurByIdUtilisateur2': {'id': this.id_user}};
    this.connexionService.updateConnexion(connexion).subscribe();
    //window.location.reload();
  }

  create_connexion(user) {

    const date = new Date();
    const user2: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
    const id = JSON.parse(localStorage.getItem('currentUser'))[1].id;
    const connexion = { 'utilisateurByIdUtilisateur1': {'id': id}  , 'utilisateurByIdUtilisateur2': {'id': this.id_user}};
    this.connexionService.createConnexion(connexion).subscribe();
    const notification = { 'utilisateur' : JSON.parse(localStorage.getItem('currentUser'))[1], 'utilisateur1' : this.user , 'date': date , 'lien' : 'invitation envoyée' , 'objet' : ' vous a envoyé une invitation'};
    this.notificationService.createNotification(notification).subscribe();
    //window.location.reload();
  }
}
