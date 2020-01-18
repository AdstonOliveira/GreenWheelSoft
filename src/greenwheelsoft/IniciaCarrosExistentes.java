/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwheelsoft;

import greenwheelsoft.models.carro.Carro;
import greenwheelsoft.models.carro.Cores;
import java.util.ArrayList;

/**
 * @author adston
 */

public class IniciaCarrosExistentes {
    private final InicializaPecas inicializadas;
    private ArrayList<String> listaNomes = new ArrayList();
    private ArrayList<Carro> modelosAntigos = new ArrayList();
    private int qtde = 1001;
    public static int idCarro = 1000;
    
    public IniciaCarrosExistentes(InicializaPecas inicializadas){
        //Garante que as pecas a serem utilizadas existem
        this.inicializadas = inicializadas;
        this.preencheNomes();
        this.montaCarros();
    }
    
    public void atualizaAntigos(ArrayList<Carro> att){
        this.modelosAntigos = null;
        this.modelosAntigos = att;
               
    }
    public final void preencheNomes(){
        for (int i = 0; i < 10; i++) 
            listaNomes.add("GreenWheelX"+(i+1));
    }
    
    public void montaCarros(){
        
        int nome = 0;
        
        for (int i = 0; i < this.qtde; i++) {
            Carro antigo = new Carro();
            
            if( nome == 10 ) //Loop entre os nomes, nao permitindo estourar
                nome = 0;
            
            antigo.setNome( listaNomes.get(nome) ); //Busca um nome na lista de nomes
            nome++; // avanca a posicao do nome
            
            //Inicialização dos componentes
            antigo.setVinNumber( idCarro++ ); // Adiciona o id e em seguida incrementa 1
            antigo.setCor( Cores.obterCor() ); // Seleciona cor aleatoria
            
            antigo.setCx_velocidade( this.inicializadas.getCaixas().get(0) ); //Adiciona uma caixa
            this.inicializadas.getCaixas().remove(0); //Indisponibiliza o objeto a outro carro
            
            antigo.setMotor(this.inicializadas.getMotores().get(0)); //Adiciona Motor
            this.inicializadas.getMotores().remove(0);
            
            antigo.setPortas(this.inicializadas.getPortas().get(0)); //Adiciona Portas
            this.inicializadas.getPortas().remove(0);
            
            antigo.setRodas(this.inicializadas.getRodas().get(0)); //Adiciona rodas
            this.inicializadas.getRodas().remove(0);
            
            antigo.setTransmissao(this.inicializadas.getTransmissao().get(0)); //Adiciona Transmissao
            this.inicializadas.getTransmissao().remove(0);
            
            this.modelosAntigos.add(antigo);
        }
    }
    
    public ArrayList<Carro> getCarros(){
        return this.modelosAntigos;
    }
    
    
    
}
