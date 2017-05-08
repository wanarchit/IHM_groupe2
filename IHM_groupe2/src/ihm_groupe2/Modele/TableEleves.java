package ihm_groupe2.Modele;

import ihm_groupe2.Noyau_fonctionnel.Eleve;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 * Classe modèle pour un JTable
 * Permet de définir les colonnes du JTable
 * Notre JTable n'est pas modifiable mais clickable
 * Il renvoie vers un JTree des réalisations de l'élève
 * 
 * @author Groupe 2
 */
public class TableEleves extends AbstractTableModel {
    
    private String[] columnName = {"Prénom", "Nom", "Classe", "Icone"};
    private ArrayList<Eleve> listeEleve;
    
    /**
     * Constructeur de la classe TableEleves
     * Permet de la création d'un TableEleves
     * @param listeEleves : liste des élèves pour le JTable
     */
    public TableEleves(ArrayList<Eleve> listeEleves) {   
        this.listeEleve = listeEleves;
    }

    @Override
    /**
     * Méthode getColumnCount
     * Permet de renvoier le nombre de colonne du tableau
     * @return lenght : integer
     */
    public int getColumnCount(){
        return columnName.length;
    }

    @Override
    /**
     * Méthode getRowCount
     * Permet de renvoyer le nombre de ligne du tableau
     * Cela correspond au nombre d'exercice dans la classe
     * @return nb lignes : integer
     */
    public int getRowCount(){
        return (listeEleve.size());
    }
    
    /**
    * Méthode getColumnName
    * Retourne le nom de la colone en fonction de la colonne sélectionnée
    * @param i : numéro de la colonne
    * @return le nom de la colonne (String)
    */
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
    /**
    * Méthode getValueAt
    * Récupère la valeur de la cellule correspondante selon chaque colonne
    * @param rowIndex : numéro de la ligne
    * @param columnIndex : numéro de la colonne
    */
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
 
    /**
    * Méthode setData
    * Permet d'actualiser les données
    * @param listeEleves : liste des élèves pour le JTable
    */
    public void setData(ArrayList <Eleve> listeEleves){
        this.listeEleve = listeEleves;
    }
    
    /**
     * Méthode isCellEditable
     * Permet de définir si les cellules sont modifiables ou non
     * @param rowIndex : numéro de la ligne
     * @param columnIndex : numéro de la colonne
     */    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //Toutes les cellules sont non éditables
    }
    
    /**
     * Méthode getColumnClass
     * Définit les types d'objet selon la colonne
     * @param columnIndex : numéro de la colonne
     */    
    public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            case 3 : return ImageIcon.class;
            default:
                return Object.class;
        }
    }
    
    /**
     * Méthode getEleveRow
     * Permet de récupérer l'objet d'une ligne
     * @param rowIndex : numéro de la ligne
     * @return listeEleve : l'élève
     */
    public Eleve getEleveRow(int rowIndex){
	return listeEleve.get(rowIndex);
    }
}