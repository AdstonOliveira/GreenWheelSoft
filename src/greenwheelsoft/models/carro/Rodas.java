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
public class Rodas extends Peca{
    //ligas de 16 a 20 polegadas
    public static int permitidos[] = {16, 20};
    private String polegadas;

    
    
    @Override
    public String toString() {
       return this.historico.size() > 1 ? this.msg() + " " + this.pegarUltimo() : this.msg();
    }

    
    
    
    
    
    public static int[] getPermitidos() {
        return permitidos;
    }

    public static void setPermitidos(int[] permitidos) {
        Rodas.permitidos = permitidos;
    }

    public String getPolegadas() {
        return polegadas;
    }

    public void setPolegadas(String polegadas) {
        this.polegadas = polegadas;
    }

    @Override
    public String msg() {
        return "Rodas Ligas de: " +this.getPolegadas() + ". ";
    }
    
    
    
}
