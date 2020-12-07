package projet.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name="T_UTILISATEUR")
public class Utilisateur implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY )
@Column(name="UT_ID")
int id;
@Column(name="UT_NOM")
String nom;
@Column(name="UT_PRENOM")
String prenom;
@Column(name="UT_ADRESS")
String adresseMail;
public Utilisateur() {}
public String getNom() {return nom;}
public void setNom(String nom) {this.nom = nom;}
public String getPrenom() {return prenom;}
public void setPrenom(String prenom) {this.prenom = prenom;}
public String getAdresseMail() {return adresseMail;}
public void setAdresseMail(String adresseMail) {this.adresseMail = adresseMail;}
}