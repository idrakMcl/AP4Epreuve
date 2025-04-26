/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import model.UserListModel;
import model.Utilisateur;
import view.AjoutDialog;
import view.MainView;
import view.ModifDialog;

/**
 *
 * @author i.mcolo
 */
public class MainControl implements PropertyChangeListener {

    private MainView view;
    // Attributs
// Référence au modèle de la liste des utilisateurs
    private UserListModel userListModel;
    private AjoutDialog ajoutDialog;
    private ModifDialog modifDialog; 

    public MainControl(MainView view) {
        // Création du JTableModel (1)
        this.userListModel = new UserListModel();
        this.view = view;

        // on fournit this.view pour renseigner la fenêtre parent
// le 2ème paramètre précise que cette fenêtre est modale
        this.ajoutDialog = new AjoutDialog(this.view, true);
        this.ajoutDialog.addPropertyChangeListener(this);

//        Demande a la vue de rajouter la viue ModifDialog dans ses aBonnées
        this.modifDialog = new ModifDialog(this.view, true);
        this.modifDialog.addPropertyChangeListener(this);

// moi le contrôleur (this), je demande
// à la vue de me rajouter dans ses abonnés
        this.view.addPropertyChangeListener(this);
        // On passe le JTableModel à la vue (2)
        this.view.setTableModel(userListModel);
    }
    
    
    //echange des donnes de la jtable de maineView et modifDialog\\
    
   
// Réception des notifications
//!!!!!!! a finir !!!!!!!\\

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {

            case "btnAjoutUtilisateurClick":
                this.ajoutDialog.setVisible(true);
                break;

            case "btnAjouterClick":
                String nom = this.ajoutDialog.getNom();
                String prenom = this.ajoutDialog.getPrenom();
                String email = this.ajoutDialog.getEmail();

                this.userListModel.createUtilisateur(nom, prenom, email);

                this.ajoutDialog.setVisible(false);
                break;
            case  "btnModifierUtilisateurClick":
                this.modifDialog.setId(view.getSelectedIdModifier());
                this.modifDialog.setNom(view.getSelectedNomModifier());
                this.modifDialog.setPrenom(view.getSelectedprenomModifier());
                this.modifDialog.setEmail(view.getSelectedEmailModifier());                
                this.modifDialog.setVisible(true);
                break;
            case  "btnValiderModifierClick":
                Integer idModifier = this.modifDialog.getId();
                String nomModifier = this.modifDialog.getNom();
                String prenomModifier = this.modifDialog.getPrenom();
                String emailModifier = this.modifDialog.getEmail();
                this.userListModel.modifUtilisateur(idModifier, nomModifier, prenomModifier,emailModifier);

                this.modifDialog.setVisible(false);
            case "btnDeleteUtilisateurClick":
                this.userListModel.deleteUtilisateur(view.getSelectedIdModifier());

        }
    }

}
