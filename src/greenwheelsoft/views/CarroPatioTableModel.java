package greenwheelsoft.views;

import greenwheelsoft.models.carro.Carro;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * INSERIR URNA NO BANCO
 * @author adston
 */
public class CarroPatioTableModel extends CarroExistenteTableModel{
    
    public CarroPatioTableModel(ArrayList<Carro> dados){
        this.Carros = dados;
    }
    
    public CarroPatioTableModel(){
        this.Carros = new ArrayList();
        this.limpar();
    }

    
    @Override
    public void addCarro(Carro u){
        this.Carros.add(u);
        int ultimoIndice = getRowCount() - 1;  
   
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    
    @Override
    public void addListaCarros(List<Carro> urnas){
        int tamanhoAntigo = this.getRowCount();
        this.Carros.addAll(urnas);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    @Override
    public void formatTable(JTable table){
        
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setFont( new Font("monospaced", Font.BOLD, 12) );
        table.setBorder(BorderFactory.createLineBorder(Color.RED));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.LIGHT_GRAY);
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
       
    }
    
    
    
}
