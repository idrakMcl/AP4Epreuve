package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MySQLConnexion;
import model.MySQLConnexion;
import model.Utilisateur;
import model.Utilisateur;

/**
 *
 * @author i.mcolo
 */
public class UtilisateurDao {

    private ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    private  Connection connexion;

    public UtilisateurDao() {
        this.connexion = MySQLConnexion.getConnexion();
    }

    public ArrayList<Utilisateur> getAll() {

        try {
            String query = "SELECT * FROM utilisateur ";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ResultSet res = ps.executeQuery();

            ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

            while (res.next()) {
                int id = res.getInt("id");
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String email = res.getString("email");
                // etc...

                utilisateurs.add(new Utilisateur(id, nom, prenom, email));
            }

            return utilisateurs;
        } catch (SQLException ex) {
            return null;
        }

    }

    public void insertUtilisateur(Utilisateur u) {
        try {

            String query = "insert into utilisateur(nom,prenom,email,mdp) VALUES (?,?,?,?)";

            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, "mdp");

//            Utilisateur a = new Utilisateur(u.getNom(), u.getPrenom(), u.getEmail());
//            utilisateurs.add(a);
            int n = ps.executeUpdate();
            // n contient l'id générer lors de l'insertion en base
            //ici on le recuper var c'est un insert (inutile dans le cas d'un update ou un delete)
            u.setId(n);

        
//        catch (SQLException ex) {

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     public void UpdateUtilisateur(Utilisateur ut) {
        try {

            String query = "UPDATE utilisateur SET nom = ?,prenom = ?,email = ?,mdp = ? WHERE id = ?";

            PreparedStatement ps = this.connexion.prepareStatement(query);
            
            ps.setString(1, ut.getNom());
            ps.setString(2, ut.getPrenom());
            ps.setString(3, ut.getEmail());
            ps.setString(4, "mdp");
            ps.setInt(5, ut.getId());
            ps.executeUpdate();

//            Utilisateur a = new Utilisateur(u.getNom(), u.getPrenom(), u.getEmail());
//            utilisateurs.add(a);
//            int n = ps.executeUpdate();
            // n contient l'id générer lors de l'insertion en base
            //ici on le recuper var c'est un insert (inutile dans le cas d'un update ou un delete)
//            u.setId(n);

        
//        catch (SQLException ex) {

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void deleteUtilisateur(Integer id) {
        try {

            String query = "DELETE FROM utilisateur WHERE id = ?" ;

            PreparedStatement ps = this.connexion.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.executeUpdate();

//            Utilisateur a = new Utilisateur(u.getNom(), u.getPrenom(), u.getEmail());
//            utilisateurs.add(a);
//            int n = ps.executeUpdate();
            // n contient l'id générer lors de l'insertion en base
            //ici on le recuper var c'est un insert (inutile dans le cas d'un update ou un delete)
//            u.setId(n);

        
//        catch (SQLException ex) {

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

