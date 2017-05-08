package ihm_groupe2.Modele;

import ihm_groupe2.Noyau_fonctionnel.Classe;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Classe modèle pour un JTable
 * Permet de définir les colones du JTable
 * Notre JTable n'est pas modifiable mais clickable
 * Il renvoie vers le JTable des élèves de cette classe
 * 
 * @author Groupe 2
 */
public class TableClasses extends AbstractTableModel{
    private String[] columnName = {"Nom classe", "Nom professeur", "Nombre d'élève"};
    private ArrayList<Classe> listeClasse;
    
    /**
     * Constructeur de la classe TableClasses
     * Permet la création d'un TableClasses
     * @param listeClasses : liste des classes à afficher dans le JTable
     */
    public TableClasses(ArrayList<Classe> listeClasses) {   
        this.listeClasse = listeClasses;
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
        return (listeClasse.size());
    }
    
    @Override
    /**
    * Méthode getColumnName
    * Retourne le nom de la colone en fonction de la colonne sélectionnée
    * @param i : numéro de la colonne
    * @return le nom de la colonne (String)
    */    
    public String getColumnName(int i){
        switch(i){
            case 0: return"Nom classe";
            case 1: return"Nom professeur";
            case 2: return"Nombre d'élève";
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
            case 0: return listeClasse.get(rowIndex).getNomClasse();
            case 1: return listeClasse.get(rowIndex).getProfesseur().getNomPersonne();
            case 2: return listeClasse.get(rowIndex).getListEleveClasse().size();
            default: return "";
        }
    }
 
    /**
     * Méthode setData
     * Permet d'actualiser les données
     * @param listeClasses : liste des classes pour le JTable
     */    
    public void setData(ArrayList <Classe> listeClasses){
        this.listeClasse = listeClasses;
    }
    
    @Override
    /**
     * Méthode isCellEditable
     * Permet de définir si les cellules sont modifiables ou non
     * @param rowIndex : numéro de la ligne
     * @param columnIndex : numéro de la colonne
     */    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //Toutes les cellules sont non éditables
    }
    
    @Override
    /**
     * Méthode getColumnClass
     * Définit les types d'objet selon la colonne
     * @param columnIndex : numéro de la colonne
     */    
    public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            default:
                return Object.class;
        }
    }

    /**
     * Méthode getClasseRow
     * Permet de récupérer l'objet d'une ligne
     * @param rowIndex : numéro de la ligne
     * @return listeClasse : la classe
     */    
    public Classe getClasseRow(int rowIndex){
	return listeClasse.get(rowIndex);
    }
}
