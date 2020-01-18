/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwheelsoft.models.carro;

import java.util.ArrayList;

/**
 *
 * @author adston
 */
public abstract class Peca{
    
    protected ArrayList<Carro> historico = new ArrayList();
    public abstract String msg();
    
    
    protected void adicionaHistorico(Carro carro){
        this.historico.add(carro);
    }
    
    protected String pegarUltimo(){
        return this.historico.isEmpty() ? "Nenhum Carro no historico" : 
                "Doador: (" + this.historico.get(this.historico.size() -2).getNome() +")"
                            + " ID: " + "(" +
                                 this.historico.get(this.historico.size() -2).getVinNumber() +")";
        
    }
    protected String tipo(){
        return String.valueOf(this.getClass().getName());
    }
    
    
    
}
