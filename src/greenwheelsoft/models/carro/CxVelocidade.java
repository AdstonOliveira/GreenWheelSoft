/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwheelsoft.models.carro;

public class CxVelocidade extends Peca{
    //5-6-8
    private int velocidade = 0;
    public static int[] permitidas = {5,6,8};
    
    
    public int getVelocidade() {
        
        return this.velocidade;
    }
    
    //Validação Velocidade - Previne inserção de velocidade nao permitida
    public boolean setVelocidade(int velocidade){
        int i = validaVelocidade(velocidade); 
        if( i != -1){
            this.velocidade = permitidas[i];
            return true;
        }
        
        return false;
    }
    
    public int validaVelocidade(int velocidade){

        for(int i = 0; i < permitidas.length; i++)
            if(velocidade == permitidas[i])
                return i;
       
        return -1;
    }
    
    
    
    @Override
    public String toString(){
        if(this.historico.size() > 1)
            return this.msg() + " " + this.pegarUltimo();
        
        return msg();
    }
    
    @Override
    public String msg(){
        return "Caixa Automatica de " + velocidade + " velocidades. " ;
    }
    
}
