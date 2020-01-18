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
public class Motor extends Peca{
    public static int[] permitidos = {1, 4};//minimo e maximo
    public static int[] eletrico = {50, 340};//min e max eletrico
    
    private EngineType engine_type;
    //1,0 litro a 4,0 litros (gasolina ou diesel) 
    //50 cv a 340 cv (elétrico)
    
    private String capacidade;

    @Override
    public String toString() {
        if(this.historico.size() > 1)
            return this.msg() + " " + this.pegarUltimo();
        
        return msg();
    }

    @Override
    public String msg(){
        return this.engine_type.toString() + " capacidade de " + this.capacidade + ". ";
    }
    
    public static int[] getPermitidos() {
        return permitidos;
    }

    public static void setPermitidos(int[] permitidos) {
        Motor.permitidos = permitidos;
    }

    public static int[] getEletrico() {
        return eletrico;
    }

    public static void setEletrico(int[] eletrico) {
        Motor.eletrico = eletrico;
    }

    public EngineType getEngine_type() {
        return engine_type;
    }

    public void setEngine_type(EngineType engine_type) {
        this.engine_type = engine_type;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }
    
    
    
    
    
    
    
    
}
