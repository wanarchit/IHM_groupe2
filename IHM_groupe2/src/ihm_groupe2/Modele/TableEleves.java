/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Modele;

import ihm_groupe2.Noyau_fonctionnel.Classe;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Groupe_2
 */
public class TableEleves extends AbstractTableModel {
    
    private String[] columnName = {"Prénom", "Nom", "Classe", "Icone"};
    private ArrayList<Eleve> listeEleve;
    
    public TableEleves(ArrayList<Eleve> listeEleves) {   
        this.listeEleve = listeEleves;
    }

    @Override
    public int getColumnCount(){
        return columnName.length;
    }

    @Override
    public int getRowCount(){
        return (listeEleve.size());
    }
    
    public String getColumnName(int i){
        switch(i){
            case 0: return"Prénom";
            case 1: return"Nom";
            case 2: return"Classe";
            case 3: return"Icone";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){

        switch(columnIndex){
            case 0: return listeEleve.get(rowIndex).getPrenomPersonne();
            case 1: return listeEleve.get(rowIndex).getNomPersonne();
            case 2: return listeEleve.get(rowIndex).getLaClasse().getNomClasse();
            case 3: 
                ImageIcon ic = new ImageIcon((listeEleve.get(rowIndex).getIconEleve()).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
                return ic;
            default: return "";
        }
    }
 
    public void setData(ArrayList <Eleve> listeExo){
        this.listeEleve = listeExo;
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //Toutes les cellules sont non éditables
    }
    
    public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            case 3 : return ImageIcon.class;
            default:
                return Object.class;
        }
    }
    
    public Eleve getEleveRow(int rowIndex){
	return listeEleve.get(rowIndex);
    }
}