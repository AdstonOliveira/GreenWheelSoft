package greenwheelsoft.views;

import greenwheelsoft.models.carro.Carro;
import greenwheelsoft.models.carro.CarroNovo;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * INSERIR URNA NO BANCO
 * @author adston
 */
public class CarroExistenteTableModel extends AbstractTableModel{
    protected ArrayList<Carro> Carros;
    protected String[] colunas = {"#","Nome", "Cor","vinId", "Motor", "Caixa", "Rodas", "Portas"};
    protected Color border = new Color(106,90,205);
    
    public CarroExistenteTableModel(ArrayList<Carro> dados){
        this.Carros = dados;
    }
    
    public CarroExistenteTableModel(){
        this.Carros = new ArrayList();
        this.limpar();
    }
    
    @Override
    public int getRowCount() {
        return this.Carros.size();
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
    
    public void setValueAt(Carro aValue, int rowIndex) {  
       Carro carro = Carros.get(rowIndex);
        
        carro.setMotor( aValue.getMotor() );
        carro.setCx_velocidade(aValue.getCx_velocidade());
        carro.setCor(aValue.getCor());
        carro.setNome(aValue.getNome());
        carro.setPortas(aValue.getPortas());
        carro.setRodas(aValue.getRodas());
        carro.setTransmissao(aValue.getTransmissao());
        carro.setVinNumber(aValue.getVinNumber());
        
        fireTableCellUpdated(rowIndex, 1);  
        fireTableCellUpdated(rowIndex, 2);  
        fireTableCellUpdated(rowIndex, 3);  
        fireTableCellUpdated(rowIndex, 4);  
        fireTableCellUpdated(rowIndex, 5);  
        fireTableCellUpdated(rowIndex, 6);  
        fireTableCellUpdated(rowIndex, 7);  
        fireTableCellUpdated(rowIndex, 8);  
   
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
    
    public Carro getSelectedCar(int i){
        return this.Carros.get(i);
    }
    
    
    @Override
    public Object getValueAt(int i, int Ci) {
        
        Carro carro;
        if(Carros.get(i) instanceof CarroNovo)
            carro = (CarroNovo) Carros.get(i);
        else
           carro = Carros.get(i);

        switch (Ci){
                case 1:
                    return carro.getNome();
                case 2:
                    return carro.getCor();
                case 3:
                    return carro.getVinNumber();
                case 4:
                    return carro.getMotor();
                case 5:
                    return carro.getCx_velocidade();
                case 6:
                    return carro.getRodas();
                case 7:
                    return carro.getPortas();
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
    
    
    public Carro getCarro(int i){
        return this.Carros.get(i);
    }
    
    public void addCarro(Carro u){
        
        if( u.getMotor()!= null ) {
            this.Carros.add(u);
            int ultimoIndice = getRowCount() - 1;  
   
            fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }
    }
    
    public void addListaCarros(List<Carro> urnas){
        int tamanhoAntigo = this.getRowCount();
        this.Carros.addAll(urnas);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    public void limpar() {  
        this.Carros.clear();    
        fireTableDataChanged();  
    }  
   
    public boolean isEmpty() {  
        return this.Carros.isEmpty();  
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
            table.getColumnModel().getColumn(2).setMaxWidth(150);
            table.getColumnModel().getColumn(3).setMaxWidth(50);
            table.getColumnModel().getColumn(6).setMaxWidth(150);
            table.getColumnModel().getColumn(7).setMaxWidth(250);
            
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
       
    }
    
    
    
}
