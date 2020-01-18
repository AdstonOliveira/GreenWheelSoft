/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwheelsoft;

import greenwheelsoft.models.carro.Carro;
import greenwheelsoft.models.carro.CarroNovo;
import greenwheelsoft.models.carro.Cores;
import java.util.ArrayList;

/**
 *
 * @author adston
 */
public class IniciarNovosCarros {
    private ArrayList<Carro> antigos;
    private ArrayList<Carro> novos = new ArrayList();
    
    
    private int qtde = 500;
    private String[] nomes = {"VerdeRodaEsportesCarro", "SmallGreenMini", "MédioVerdeSalão", "GreenBus"};
    
    public IniciarNovosCarros(ArrayList<Carro> antigos){
        this.antigos = antigos;
        this.criarNovos();
    }
    
    public void criarNovos(){
        int nome = 0;
        
        for (int i = 0; i < 167; i++ ) {
            if(nome == 3)
                nome = 0;
            
            CarroNovo novo = new CarroNovo();
                novo.setNome(nomes[nome++]);
                novo.setCor(Cores.obterCor());
                novo.setVinNumber(IniciaCarrosExistentes.idCarro++);
                
                novo.setMotor( this.antigos.get(i) );//Motor composto 2 pecas
                
                novo.setCx(this.antigos.get(i+1));
                novo.setPortas(this.antigos.get(i+1));
                
                novo.setRodas(this.antigos.get(i+2));
                novo.setTransmissao(this.antigos.get(i+2));
                
                this.novos.add(novo);
            
            CarroNovo novo2 = new CarroNovo();
                novo2.setNome(nomes[nome++]);
                novo2.setCor(Cores.obterCor());
                novo2.setVinNumber(IniciaCarrosExistentes.idCarro++);
                
                novo2.setMotor(this.antigos.get(i+1));
                
                novo2.setCx(this.antigos.get(i+2));
                novo2.setPortas(this.antigos.get(i+2));
                
                novo2.setRodas(this.antigos.get(i));
                novo2.setTransmissao(this.antigos.get(i));

                
                this.novos.add(novo2);
                
                if(i < 166){ // em 498 precisam ser criados apenas 2 carros
                    CarroNovo novo3 = new CarroNovo();
                    novo3.setNome(nomes[nome++]);
                    novo3.setCor(Cores.obterCor());
                    novo3.setVinNumber(IniciaCarrosExistentes.idCarro++);
                    
                    novo3.setMotor(this.antigos.get(i+2));

                    novo3.setCx(this.antigos.get(i));
                    novo3.setPortas(this.antigos.get(i));

                    novo3.setRodas(this.antigos.get(i+1));
                    novo3.setTransmissao(this.antigos.get(i+1));
                    //Alterar metodo para receber objeto e exclui-lo pelo set (Sobrescrit)
                    this.novos.add(novo3);
                }
                
            CarrosDescartados.descartados.add( this.antigos.get(i) );
            CarrosDescartados.descartados.add( this.antigos.get(i+1) );
            CarrosDescartados.descartados.add( this.antigos.get(i+2) );
            
            this.antigos.remove((i));
            this.antigos.remove((i+1));
            this.antigos.remove((i+2));
        }
        
    }

    public ArrayList<Carro> getAntigos() {
        ArrayList<Carro> novo = antigos;
        return novo;
    }

    public void setAntigos(ArrayList<Carro> antigos) {
        this.antigos = antigos;
    }

    public ArrayList<Carro> getNovos() {
        return novos;
    }

    public void setNovos(ArrayList<Carro> novos) {
        this.novos = novos;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    public void imprimirAntigos(){
        for(Carro c : this.getAntigos()){
            System.out.println(this.antigos.size());
            System.out.println(c.getVinNumber());
        }
    }
    
    
    
    
    
    
}
