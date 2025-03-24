package com.uca;

import com.uca.dao._Initializer;
import com.uca.gui.*;

import static spark.Spark.*;

public class StartServer {
	private int ID=-1;
	private String IDAdresse;
	private String IDAppartement;
	private int Numero;
	private int Etage;


	StartServer(){}

	public void setID(int id){
		this.ID=id;
	}
	public int getID(){
		return this.ID;
	}
	public void setIDAdresse(String idadresse){
		this.IDAdresse=idadresse;
	}
	public String getIDAdresse(){
		return this.IDAdresse;
	}
	public void setIDAppartement(String idappart){
		this.IDAppartement=idappart;
	}
	public String getIDAppartement(){
		return this.IDAppartement;
	}
	public void setNumero(int numero){
		this.Numero=numero;
	}
	public int getNumero(){
		return this.Numero;
	}

	public void setEtage(int etage){
		this.Etage=etage;
	}
	public int getEtage(){
		return this.Etage;
	}



    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);


        _Initializer.Init();

	StartServer Server = new StartServer();
        //Defining our routes
	get("/", (req, res) -> {

		int ID = Server.getID();
		if(ID!=-1){
			res.redirect("/"+ID+"/home", 301);
			return "";
		}
		res.redirect("/login", 301);
		return "";
	});

	get("/signin", (req, res) -> {
		return SigninGUI.getSignin();
	});

        get("/user", (req, res) -> {
		
		int ID = Server.getID();
		if(ID!=-1){
			res.redirect("/"+ID+"/user", 301);
			return "";
		}
		res.redirect("/login", 301);
		return "";

        });
	get("/syndicat", (req, res) -> {
		
		int ID = Server.getID();
		if(ID!=-1){
			res.redirect("/"+ID+"/syndicat", 301);
			return "";
		}
		res.redirect("/login", 301);
		return "";

        });
	get("/personne", (req, res) -> {
		
		int ID = Server.getID();
		if(ID!=-1){
			res.redirect("/"+ID+"/personne", 301);
			return "";
		}
		res.redirect("/login", 301);
		return "";

        });
	get("/appartement", (req,res) -> {
            int ID = Server.getID();
		if(ID!=-1){
			res.redirect("/"+ID+"/appartement", 301);
			return "";
		}
		res.redirect("/login", 301);
		return "";
        });

	get("/immeuble", (req, res) -> {
		
		int ID = Server.getID();
		if(ID!=-1){
			res.redirect("/"+ID+"/immeuble", 301);
			return "";
		}
		res.redirect("/login", 301);
		return "";

        });	


	get("/logout", (req, res) -> {
		//int ID = Server.getID();
		if(Server.getID()!=-1){
			Server.setID(-1);
		}
		res.redirect("/login", 301);
		return "";
	});

	get("/login", (req, res) -> {
		return LoginGUI.getLogin();
	});
	post("/login", (req, res) -> {
		String firstname = req.queryParams("firstName");
		String lastname = req.queryParams("lastName");
	
		Server.setID(UserGUI.CheckUser(firstname, lastname));

		int ID = Server.getID();

		if(ID!=-1){
			res.redirect("/"+ID+"/home", 301);
			return "";
		}
		res.redirect("/login", 301);
		return "";

	});


        get("/:id/home", (req,res) -> {
		int ID = Server.getID();

            return AccueilGUI.getAccueil(ID);
        });

	get("/:id/user", (req,res) -> {

            return UserGUI.getAllUser();
        });

	
	post("/addUser", (req,res) ->{
		String firstname = req.queryParams("firstName");
		String lastname = req.queryParams("lastName");

		UserGUI.createUser(firstname, lastname);
		int ID = Server.getID();
		if(ID!=-1){
			res.redirect("/"+ID+"/user", 301);
			return "";
		}
		res.redirect("/login", 301);
		return "";


		});
	get("/delUser", (req,res) ->{
		int id = Integer.parseInt(req.queryParams("id"));
	
		//System.out.println(id);

		UserGUI.deleteUser(id) ;
		int ID = Server.getID();
		if(ID!=-1){
			res.redirect("/"+ID+"/user", 301);
			return "";
		}
		res.redirect("/login", 301);
		return "";
	});

	get("/:id/appartement", (req,res) -> {
            return AppartementGUI.getAllAppartement();
        });


        get("/:id/syndicat", (req,res) -> {
            return SyndicatGUI.getAllSyndicat();
        });
	post("/addSyndicat", (req,res) ->{
		String Nom = req.queryParams("nom");
		String Adresse = req.queryParams("adresse");
		String Telephone = req.queryParams("telephone");
		String Mail = req.queryParams("mail");
		String Nom_Referent = req.queryParams("nom_referent");

		SyndicatGUI.createSyndicat(Nom, Adresse, Telephone, Mail, Nom_Referent) ;

		res.redirect("/syndicat", 301);
		return "";
	});
	get("/delSyndicat", (req,res) ->{
		String Nom = req.queryParams("nom");
		
		System.out.println(Nom);
		SyndicatGUI.deleteSyndicat(Nom) ;

		res.redirect("/syndicat", 301);
		return "";
	});




        	
	post("/addAppartement", (req,res) ->{

		//System.out.println("E\n");
		//String Adresse = req.queryParams("adresse");
		//System.out.println(Adresse);
		int Etage = Integer.parseInt(req.queryParams("etage"));
		//System.out.println(Etage);
		int Numero  = Integer.parseInt(req.queryParams("numero"));
		//System.out.println(Numero);
		int Superficie = Integer.parseInt(req.queryParams("superficie"));
		//System.out.println(Superficie);
		//boolean EstLoue = req.queryParams("choix").equals("true");
		//System.out.println(EstLoue);
		int ID = Server.getID();
		String IDAdresse = Server.getIDAdresse();

		//System.out.println("A\n");

		AppartementGUI.createAppartement(IDAdresse, Etage, Numero, Superficie);

		//System.out.println("N\n");

		res.redirect("/"+ID+"/immeuble/"+IDAdresse+"/appartement", 301);
		return "";
	});	
	get("/delAppartement", (req,res) ->{
		String Adresse = req.queryParams("adresse");
		int Etage = Integer.parseInt(req.queryParams("etage"));
		int Numero = Integer.parseInt(req.queryParams("numero"));
		int ID = Server.getID();
		Server.setIDAdresse(Adresse);

		String IDAdresse = Server.getIDAdresse();

		AppartementGUI.deleteAppartement(Adresse, Numero, Etage);

		res.redirect("/"+ID+"/immeuble/"+IDAdresse+"/appartement", 301);
		return "";
	});
	get("/delAppartementFromAll", (req,res) ->{
		String Adresse = req.queryParams("adresse");
		int Etage = Integer.parseInt(req.queryParams("etage"));
		int Numero = Integer.parseInt(req.queryParams("numero"));
		int ID = Server.getID();
		Server.setIDAdresse(Adresse);

		String IDAdresse = Server.getIDAdresse();

		AppartementGUI.deleteAppartement(Adresse, Numero, Etage);

		res.redirect("/"+ID+"/appartement", 301);
		return "";
	});


	
	get("/:id/immeuble", (req,res) -> {

            return ImmeubleGUI.getAllImmeuble();
        });
	
	post("/addImmeuble", (req,res) ->{
		String Nom = req.queryParams("nom");
		//System.out.println(Nom);
		String Adresse = req.queryParams("adresse");
		//System.out.println(Adresse);
		String Nom_Syndicat = req.queryParams("nom_syndicat");
		//System.out.println(Nom_Syndicat);
		
		ImmeubleGUI.createImmeuble(Nom, Adresse, Nom_Syndicat) ;

		res.redirect("/immeuble", 301);
		return "";
	});
	get("/delImmeuble", (req,res) ->{
		String Adresse = req.queryParams("adresse");
		int ID = Server.getID();

		ImmeubleGUI.deleteImmeuble(Adresse);

		res.redirect("/"+ID+"/immeuble", 301);
		return "";
	});

	
	get("/:id/immeuble/:idadresse/appartement", (req,res) -> {
		String IDAdresse = Server.getIDAdresse();
            return AppartementGUI.getAppartement(IDAdresse) ;

        });

	get("/:id/immeuble/:idadresse/appartement/:idappartement/personne", (req,res) -> {
		String IDAdresse = Server.getIDAdresse();
		int Numero = Server.getNumero();
		int Etage = Server.getEtage();
            	return PersonneGUI.getPersonne(IDAdresse, Numero, Etage);

		//return "TU DOIS IMPLEMENTER";

        });



	get("/SeeAppartement", (req,res) ->{
		
		String Adresse = req.queryParams("adresse");
		//System.out.println(Adresse);
		Server.setIDAdresse(Adresse);
		String IDAdresse = Server.getIDAdresse(); 
		int ID = Server.getID();


		res.redirect("/"+ID+"/immeuble/"+IDAdresse+"/appartement", 301);
		return "";
	});

	
	get("/:id/personne", (req,res) -> {
            return PersonneGUI.getAllPersonne();
        });
	post("/addPersonne", (req,res) ->{
		String Nom = req.queryParams("nom");
		String Prenom = req.queryParams("prenom");
		String Telephone = req.queryParams("telephone");
		boolean EstProprietaire = req.queryParams("choix").equals("true");

		String IDAdresse = Server.getIDAdresse();
		int Numero = Server.getNumero();
		int Etage = Server.getEtage();
		int ID = Server.getID();
		Server.setIDAppartement(IDAdresse+Numero+Etage);
		String IDAppartement = Server.getIDAppartement();

		PersonneGUI.createPersonne(Nom, Prenom, Telephone, EstProprietaire, IDAdresse, Numero, Etage);

		res.redirect("/"+ID+"/immeuble/"+IDAdresse+"/appartement/"+IDAppartement+"/personne", 301);

		return "";
	});
	get("/delPersonneFromAll", (req,res) ->{
		String Nom = req.queryParams("nom");
		String Prenom = req.queryParams("prenom");
		String Telephone = req.queryParams("telephone");
		int ID = Server.getID();

		

		//System.out.println(Nom+Prenom+Telephone);
	
		PersonneGUI.deletePersonne(Telephone, Prenom, Nom);

		res.redirect("/"+ID+"/personne", 301);
		return "";
	});
	get("/delPersonne", (req,res) ->{
		String Nom = req.queryParams("nom");
		String Prenom = req.queryParams("prenom");
		String Telephone = req.queryParams("telephone");

		String Adresse = req.queryParams("adresse");
		int Etage = Integer.parseInt(req.queryParams("etage"));
		int Numero = Integer.parseInt(req.queryParams("numero"));

		Server.setIDAdresse(Adresse);
		Server.setNumero(Numero);
		Server.setEtage(Etage);
		String IDAdresse = Server.getIDAdresse();
		Server.setIDAppartement(Adresse+Numero+Etage);
		String IDAppart = Server.getIDAppartement();
 
		int ID = Server.getID();

		//System.out.println(Nom+Prenom+Telephone);
	
		PersonneGUI.deletePersonne(Telephone, Prenom, Nom);

		res.redirect("/"+ID+"/immeuble/"+IDAdresse+"/appartement/"+IDAppart+"/personne", 301);
		return "";
	});

	get("/SeePersonne", (req,res) ->{
		
			
		//VOIR LES PERSONNES LIERS A UN APPARTEMENT
		
		String Adresse = req.queryParams("adresse");
		int Numero = Integer.parseInt(req.queryParams("numero"));
		int Etage = Integer.parseInt(req.queryParams("etage"));

		//System.out.println(Adresse);
		Server.setIDAdresse(Adresse);
		Server.setNumero(Numero);
		Server.setEtage(Etage);
		String IDAdresse = Server.getIDAdresse(); 
		int ID = Server.getID();


		Server.setIDAppartement(Adresse+Numero+Etage);
		String IDAppart = Server.getIDAppartement();


		res.redirect("/"+ID+"/immeuble/"+IDAdresse+"/appartement/"+IDAppart+"/personne", 301);
		return "";
		
	});






    }
}
