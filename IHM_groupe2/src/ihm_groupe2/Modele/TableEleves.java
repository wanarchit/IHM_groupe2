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
 * @author Maxime
 */
public class TableEleves extends AbstractTableModel {
    
    private final Eleve[] eleves;
    private ArrayList<Eleve> listeEleves;
    
    private final String[] entetes = {"Classe", "Prénom", "Nom"};
    
    public TableEleves(ArrayList <Eleve> listeEleves) {   
    super();
    this.listeEleves = listeEleves;
    
    Professeur P1 = new Professeur ("azerty", "123456", "Thomas", "Kerdreux");
    Professeur P2 = new Professeur ("zqsd", "wxcvbn", "Patrick", "Girard");
    Classe CP = new Classe ("CP", P1);
    Classe CE1 = new Classe ("CE1", P1);
    Classe CE2 = new Classe ("CE2", P2);
    
    eleves = new Eleve[]{
                new Eleve(CP, "Maxime", "Tanguy"),
                new Eleve(CP, "Alphonse", "Brown"),
                new Eleve(CE1, "Delphine", "Rousse"),
                new Eleve(CE1, "Paul", "Gand"),
                new Eleve(CE2, "Jonathan", "Rivault"),
                new Eleve(CE2, "Marin", "Conrady"),
        };
    
    listeEleves.add(new Eleve(CP, "Maxime", "Tanguy"));
    listeEleves.add(new Eleve(CP, "Alphonse", "Brown"));
    listeEleves.add(new Eleve(CE1, "Delphine", "Rousse"));
    listeEleves.add(new Eleve(CE1, "Paul", "Gand"));
    listeEleves.add(new Eleve(CE2, "Jonathan", "Rivault"));
    listeEleves.add(new Eleve(CE2, "Marin", "Conrady"));
    
    }

    @Override
    public int getRowCount() {
        return eleves.length;
    }

    @Override
    public int getColumnCount() {
       return entetes.length; 
    }
    
    /**
     *
     * @param columnIndex
     * @return
     */
    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: 
                return eleves[rowIndex].getLaClasse().getNomClasse();
            case 1:
                return eleves[rowIndex].getNomPersonne();
            case 2:
                return eleves[rowIndex].getPrenomPersonne();
            default:
                return null; //Ne devrait jamais arriver  
        }
    }
    
    /**
     * Permet de récupérer l'objet d'une ligne
     * @param rowIndex
     * @return
     */
    public Eleve getElevesRow(int rowIndex){
	return listeEleves.get(rowIndex);
    }
}
