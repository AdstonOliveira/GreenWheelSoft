/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwheelsoft.models.carro;

/**
 *
 * @author adston
 */
public class Portas extends Peca{
    //(2 a 5)
    public static int[] permitidas= {2, 5};
    private int qtde;

    
    
    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    @Override
    public String toString() {
        
        return this.historico.size() > 1 ? this.msg() + " " + this.pegarUltimo() : this.msg();
    }

    @Override
    public String msg() {
        return "portas: " +this.qtde + ".";
    }
    
    
    
    
    
    
    
    
}
