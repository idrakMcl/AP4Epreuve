/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.UtilisateurDao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author i.mcolo
 */
public class UserListModel extends AbstractTableModel {

    // tableau des noms de colonne
    String[] columnNames = {"id", "nom", "prenom","email","commune"};

    // arraylist<Utilisateur ou User???>
    private ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    private UtilisateurDao uDao = new UtilisateurDao();

    public UserListModel() {

//        this.utilisateurs.add(new Utilisateur(1, "mcl", "idrak","idrak@gmail.com"));
//        this.utilisateurs.add(new Utilisateur(2, "jean", "mathieu","mathieu@gmail.com"));
//        this.utilisateurs.add(new Utilisateur(3, "mbappe", "killian","killian@gmail.com"));

          this.utilisateurs =  uDao.getAll();
    }

    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    @Override
    public int getRowCount() {
        return this.utilisateurs.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }
    
    
    public void createUtilisateur(String nom,String prenom ,String email,String commune){
        Utilisateur u = new Utilisateur(nom,prenom,email,commune);
        this.uDao.insertUtilisateur(u);
        this.utilisateurs=uDao.getAll();
        this.fireTableDataChanged();
    }
    
    public void modifUtilisateur(Integer idModifier,String nomModifier,String prenomModifier,String emailModifier,String communeModifier){
    
        Utilisateur ut = new Utilisateur(idModifier,nomModifier,prenomModifier,emailModifier,communeModifier);
        this.uDao.UpdateUtilisateur(ut);
        this.utilisateurs=uDao.getAll();
        this.fireTableDataChanged();
    
    }
    
    
    public void deleteUtilisateur(Integer id){
    
        this.uDao.deleteUtilisateur(id);
        this.utilisateurs=uDao.getAll();
        this.fireTableDataChanged();
        
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Utilisateur i = utilisateurs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getId();                
            case 1:
                return i.getNom();
            case 2:
                return i.getPrenom();
            case 3:
                return i.getEmail();
            case 4: 
                return i.getCommune();
        }
        return null;
    }

}
