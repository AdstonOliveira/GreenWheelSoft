/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwheelsoft;

import greenwheelsoft.models.carro.*;
import java.util.ArrayList;
import java.util.Random;

/**
  * @author adston
*/
public class InicializaPecas {
    
    private ArrayList<CxVelocidade> caixas = new ArrayList();
    private ArrayList<EngineType> engines = new ArrayList();
    private ArrayList<Motor> motores = new ArrayList();
    private ArrayList<Portas> portas = new ArrayList();
    private ArrayList<Rodas> rodas = new ArrayList();
    private ArrayList<Transmissao> transmissao = new ArrayList();

    public static Random rd = new Random(); //Gerador numero randomico
    public static int val = 1001; //Total de veiculos
    
    
    public InicializaPecas(){
        //Inicialização de todos os metodos na ordem correta
        this.inicializaCaixas();
        this.inicializaEngine();
        this.inicializaMotor();
        this.inicializaPortas();
        this.inicializaRodas();
        this.inicializaTransmissao();
    }
    
    
    //Metodos protegidos de segunda inicialização - Inicializacao indevida
    private void inicializaCaixas(){

        for (int i = 0; i < val; i++) {
            CxVelocidade cx = new CxVelocidade();
            cx.setVelocidade( indicePermitido(CxVelocidade.permitidas) );
            caixas.add(cx);
        }
        
    }
    
    private void inicializaEngine(){
        for (int i = 0; i < val; i++) {
            EngineType et = new EngineType();
            et.setCombustivel( indicePermitido( EngineType.permitidos ) );
            
            engines.add(et);
        }
    }
    
    private void inicializaMotor(){
        if( engines.isEmpty() ){ //Verifica se as engines existem
            System.out.println("O Motor depende das engines. Inicialize-as antes");
        }else{
            for (int i = 0; i < val; i++) {
                Motor m = new Motor();
                m.setEngine_type(engines.get(0));
                
                if( m.getEngine_type().getCombustivel().equalsIgnoreCase("elétrico") ){
                    String valor = String.valueOf( minMax(Motor.eletrico) ); 
                    m.setCapacidade(valor + " cvs");
                    engines.remove(0);
                }else{
                    String valor = String.valueOf( minMax(Motor.permitidos) ); 
                    m.setCapacidade(valor + " litros");
                    engines.remove(0);
                }
                
                motores.add(m);
            }
        }
        
    }
    
    private void inicializaPortas(){
        
        for (int i = 0; i < val; i++) {
            Portas p = new Portas();
            p.setQtde( minMax(Portas.permitidas) );
            portas.add(p);
        }
        
    }

    private void inicializaRodas(){
        
        for (int i = 0; i < val; i++) {
            Rodas r = new Rodas();
            r.setPolegadas( String.valueOf( minMax(Rodas.permitidos) ) );
            rodas.add(r);
        }
        
    }
    
    private void inicializaTransmissao(){
        
        for (int i = 0; i < val; i++) {
            Transmissao t = new Transmissao();
            t.setTipo( indicePermitido(Transmissao.permitidas) );
            transmissao.add(t);
        }
        
    }

    
    //Abstracao
    private int minMax(int[] vetor){
    //  rd.nextInt(max-min+1)+min 
    // Cria um valor aleatorio entre o minimo e o maximo, com base no vetor de 2 posicoes

        return vetor.length > 0 ? rd.nextInt(vetor[1]-vetor[0]+1) + vetor[0] : -1;
    }
    
    
    
    //Abstracao e sobrecarga de metodo
    /* 
       Sorteia uma posicao de acordo com o tamanho do array e retorna seu valor
     */
    private String indicePermitido(String[] vetor){

        return vetor[ rd.nextInt(vetor.length) ];
    }
    
    private int indicePermitido(int[] vetor){
        
        return vetor[ rd.nextInt(vetor.length) ];
    }
    
    //GETTERS

    public ArrayList<CxVelocidade> getCaixas() {
        return caixas;
    }

    public ArrayList<EngineType> getEngines() {
        return engines;
    }

    public ArrayList<Motor> getMotores() {
        return motores;
    }

    public ArrayList<Portas> getPortas() {
        return portas;
    }

    public ArrayList<Rodas> getRodas() {
        return rodas;
    }

    public ArrayList<Transmissao> getTransmissao() {
        return transmissao;
    }

    public static Random getRd() {
        return rd;
    }

    public static int getVal() {
        return val;
    }
        

    
    
}
