/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwheelsoft.models.carro;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author adston
 */
public class Cores {
    
    public static Random r = new Random();
    public static ArrayList<String> cores = new ArrayList(){
        {
            add("Azul");
            add("Amarelo");
            add("Vermelho");
            add("Verde");
            add("Branco");
            add("Preto");
            add("Cinza");
            add("Rosa");
            add("Roxo");
            add("Bege");
        }
    };
    
    
    
    public static String obterCor(){
        return cores.get( r.nextInt(cores.size()) );
    }
    
    
    public static void novaCor(String cor){
        cores.add(cor);
    }
    
}
