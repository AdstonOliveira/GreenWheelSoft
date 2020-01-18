
package greenwheelsoft.models.concessionaria;

import greenwheelsoft.models.carro.Carro;
import java.util.ArrayList;
import java.util.HashMap;


public class Inventario {
    private ArrayList<Carro> inventario;
    private final Concessionaria concessionaria;
    
    public Inventario( Concessionaria concessionaria ){
        this.concessionaria = concessionaria;
        this.inventario = new ArrayList();
    }

    public ArrayList<Carro> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Carro> inventario) {
        this.inventario = inventario;
    }
    
    
    public HashMap<String,Integer> identificaIguais(){
        
        HashMap<String,Integer> iguais = new HashMap();
        
        for(int i = 0; i < this.inventario.size(); i++) {
            Carro comp = this.inventario.get(i);
            System.out.println(comp.getNome());
            
            if( iguais.containsKey( comp.getNome() ) ){
                iguais.put(comp.getNome(), iguais.get( comp.getNome() ) +1 );
            }else
                iguais.put(comp.getNome(), 1);
            
        }
        
        return iguais;

    }
    
    public String coresByNome(String nome){
        String cores = "";
        
        for(Carro c : this.inventario){
            if(c.getNome().equalsIgnoreCase(nome))
                cores += c.getCor()+ ", ";
        }
        
        return cores;
        
    }
    
    public void exibir(){
        for(Carro c : this.getInventario()){
            System.out.println(c.getNome());
        }
    }
    
    
    
    
    
}
