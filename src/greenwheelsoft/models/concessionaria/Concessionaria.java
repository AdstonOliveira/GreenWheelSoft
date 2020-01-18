
package greenwheelsoft.models.concessionaria;

import greenwheelsoft.models.carro.Carro;

public class Concessionaria {
    private String nome;
    private String endereco;
    private Inventario inventario;

    public Concessionaria(){
        this.inventario = new Inventario(this);
    }
    
    
    
    public boolean add( Carro e ){
        if(this.inventario.getInventario().size() > 20) return false;
        
        this.inventario.getInventario().add(e);
        return true;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    
    
    
}
