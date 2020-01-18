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
public class EngineType {
    //(diesel / gasolina / elétrico)
    public static String[] permitidos = {"Diesel", "Gasolina", "Elétrico"};
    
    private String combustivel;

    
    
    
    public static String[] getPermitidos() {
        return permitidos;
    }

    public static void setPermitidos(String[] permitidos) {
        EngineType.permitidos = permitidos;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
    
    @Override
    public String toString(){
        return "Motor a " + this.combustivel;
    }
    
    
    
    
}
