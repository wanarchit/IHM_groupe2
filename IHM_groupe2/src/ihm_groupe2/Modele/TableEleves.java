/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Modele;

import ihm_groupe2.Noyau_fonctionnel.Classe;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Groupe_2
 */
public class TableEleves extends AbstractTableModel {
    
    private String[] columnName = {"Prénom", "Nom", "Classe"};
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
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){

        switch(columnIndex){
            case 0: return listeEleve.get(rowIndex).getPrenomPersonne();
            case 1: return listeEleve.get(rowIndex).getNomPersonne();
            case 2: return listeEleve.get(rowIndex).getLaClasse().getNomClasse();
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
            default:
                return Object.class;
        }
    }
    
    public Eleve getEleveRow(int rowIndex){
	return listeEleve.get(rowIndex);
    }
}