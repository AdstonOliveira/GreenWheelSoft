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
public class CarroNovo extends Carro{
    
    private ArrayList<Carro> doadores;
    public CarroNovo(){
        
    }
    
    public CarroNovo( ArrayList<Carro> doadores ) {
        this.doadores = doadores;
    }
    /**
     *
     * @param carro
     * Recebe um carro e remove o Motor
     */
    public void setMotor(Carro carro){
        if(carro.getMotor() != null){
            this.motor = (Motor) carro.transferirPeca(carro.getMotor());
            this.motor.adicionaHistorico(this);
        }else{
            System.out.println("Carro sem motor");
        }
    }
    
    public void setCx(Carro carro){
        if(carro.getCx_velocidade() != null){
            this.cx_velocidade = (CxVelocidade) carro.transferirPeca(carro.getCx_velocidade());
            this.cx_velocidade.adicionaHistorico(this);
        }else{
            System.out.println("Carro sem Caixa");
        }
    }
    
    public void setPortas(Carro carro){
        if(carro.getPortas() != null){
            this.portas = (Portas) carro.transferirPeca(carro.getPortas());
            this.portas.adicionaHistorico(this);
        }else{
            System.out.println("Carro sem portas");
        }
    }
    
    public void setRodas(Carro carro){
        if(carro.getRodas() != null){
            this.rodas = (Rodas) carro.transferirPeca(carro.getRodas());
            this.rodas.adicionaHistorico(this);
        }else{
            System.out.println("Carro sem rodas");
        }
    }
    
    public void setTransmissao(Carro carro){
        if(carro.getTransmissao() != null){
            this.transmissao = (Transmissao) carro.transferirPeca(carro.getTransmissao());
            this.rodas.adicionaHistorico(this);
        }else{
            System.out.println("Carro sem transmissao");
        }
    }

    public ArrayList<Carro> getDoadores() {
        return doadores;
    }

    public void setDoadores(ArrayList<Carro> doadores) {
        this.doadores = doadores;
    }

    
    
    
    

    
    
    
    
    
    
    
    
   
    
    
}
