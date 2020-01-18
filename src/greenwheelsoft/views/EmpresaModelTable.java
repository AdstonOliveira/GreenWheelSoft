package greenwheelsoft.views;

import greenwheelsoft.models.concessionaria.Concessionaria;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * INSERIR URNA NO BANCO
 * @author adston
 */
public class EmpresaModelTable extends AbstractTableModel{
    protected ArrayList<Concessionaria> concessionarias;
    protected String[] colunas = {"#","Nome", "Endereco"};
    protected Color border = new Color(106,90,205);
    
    public EmpresaModelTable(ArrayList<Concessionaria> dados){
        this.concessionarias = dados;
    }
    
    public EmpresaModelTable(){
        this.concessionarias = new ArrayList();
        this.limpar();
    }
    
    @Override
    public int getRowCount() {
        return this.concessionarias.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {  
        //"Nome", "Cor","vinId", "Motor", "Caixa", "Rodas", "Portas"
        switch (columnIndex){
            default:
                return String.class;
        }
    }
    
    public void setValueAt(Concessionaria aValue, int rowIndex) {  
       Concessionaria c = this.concessionarias.get(rowIndex);
        c.setNome(aValue.getNome());
        c.setEndereco(aValue.getEndereco());
        
        
        fireTableCellUpdated(rowIndex, 1);  
        fireTableCellUpdated(rowIndex, 2);  
   
    }
    
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
//        Carro carro = Carros.get(rowIndex);
//   
//     switch (columnIndex) {
//         case 0:  
//             carro.setCor( aValue.toString() );
//             break;
//         case 1:  
//             urna.setDT_ABERTURA( Timestamp.valueOf(aValue.toString()) );             
//             break;
//         case 2:  
//             urna.setDT_ENCERRAMENTO( Timestamp.valueOf(aValue.toString()) );             
//             break;
//         case 3:
//             urna.setCD_CARGA_1_URNA_EFEETIVADA(aValue.toString());
//             break;
//         default:  
//             System.err.println("Índice da coluna inválido");
//     }  
//        fireTableCellUpdated(rowIndex, columnIndex);  
//     }
    
    public Concessionaria getSelectedCar(int i){
        return this.concessionarias.get(i);
    }
    
    
    @Override
    public Object getValueAt(int i, int Ci) {
        
        Concessionaria c = this.concessionarias.get(i);

        switch (Ci){
                case 1:
                    return c.getNome();
                case 2:
                    return c.getEndereco();
                case 0:
                    return i+1;
                default:
                    System.err.println("Coluna nao identificada");
                    return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {  
        return false;  
    }
    
    
    public Concessionaria getEmpresa(int i){
        return this.concessionarias.get(i);
    }
    
    public void addEmpresa(Concessionaria u){
            this.concessionarias.add(u);
            int ultimoIndice = getRowCount() - 1;  
   
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        
    }
    
    public void addLista(ArrayList<Concessionaria> concessionarias){
        int tamanhoAntigo = this.getRowCount();
        this.concessionarias.addAll(concessionarias);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    public void limpar() {  
        this.concessionarias.clear();    
        fireTableDataChanged();  
    }  
   
    public boolean isEmpty() {  
        return this.concessionarias.isEmpty();  
    }  
    
    public void formatTable(JTable table){
        
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setFont( new Font("monospaced", Font.BOLD, 12) );
        table.setBorder(BorderFactory.createLineBorder(this.border));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.LIGHT_GRAY);
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < table.getModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
       
    }
    
    
    
}
