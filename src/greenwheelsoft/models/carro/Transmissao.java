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
public class Transmissao extends Peca{
    //automática / manual / NA
    public static String[] permitidas = {"Automatica", "Manual", "NA"};
    private String tipo;

    @Override
    public String toString() {
        
        return this.historico.size() > 1 ? this.msg() + " " + this.pegarUltimo() : this.msg();
    }

    
    public static String[] getPermitidas() {
        return permitidas;
    }

    public static void setPermitidas(String[] permitidas) {
        Transmissao.permitidas = permitidas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String msg() {
        return "Transmissao tipo: " + tipo + ". ";
    }
    
    
    
    
}
