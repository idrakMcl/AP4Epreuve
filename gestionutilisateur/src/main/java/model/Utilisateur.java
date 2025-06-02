/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author i.mcolo
 */
public class Utilisateur {

    private String nom;
    private String prenom;
    private String email;
    private int id;
    private String commune;

    public Utilisateur(int id, String nom, String prenom, String email, String commune) {

        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.email = email;
        this.commune = commune;
    }

    public Utilisateur(String nom, String prenom, String email,String commune) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.commune = commune;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public String getCommune() {
        return commune;
    }

}
