package ihm_groupe2.Modele;

import ihm_groupe2.Noyau_fonctionnel.Classe;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Paul
 */
public class TableClasses extends AbstractTableModel{
    private String[] columnName = {"Nom classe", "Nom professeur", "Nombre d'élève"};
    private ArrayList<Classe> listeClasse;
    
    public TableClasses(ArrayList<Classe> listeClasses) {   
        this.listeClasse = listeClasses;
    }

    @Override
    public int getColumnCount(){
        return columnName.length;
    }

    @Override
    public int getRowCount(){
        return (listeClasse.size());
    }
    
    @Override
    public String getColumnName(int i){
        switch(i){
            case 0: return"Nom classe";
            case 1: return"Nom professeur";
            case 2: return"Nombre d'élève";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){

        switch(columnIndex){
            case 0: return listeClasse.get(rowIndex).getNomClasse();
            case 1: return listeClasse.get(rowIndex).getProfesseur().getNomPersonne();
            case 2: return listeClasse.get(rowIndex).getListEleveClasse().size();
            default: return "";
        }
    }
 
    public void setData(ArrayList <Classe> listeClasses){
        this.listeClasse = listeClasses;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //Toutes les cellules sont non éditables
    }
    
    @Override
    public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            default:
                return Object.class;
        }
    }
    
    public Classe getClasseRow(int rowIndex){
	return listeClasse.get(rowIndex);
    }
}
