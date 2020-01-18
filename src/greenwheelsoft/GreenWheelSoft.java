/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwheelsoft;

import greenwheelsoft.controllers.ControllerHome;
import greenwheelsoft.views.Home;
import java.util.ArrayList;

/**
 *
 * @author adston
 */
public class GreenWheelSoft {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ControllerHome ch = new ControllerHome(new Home());
       
    }
    

//Abstracao    
    public static boolean imprimir(ArrayList array){
        
        if( array.isEmpty() ){
            System.out.println("Lista vazia, verifique se a mesma foi inicializada ou se todas as pecas ja foram "
                    + "atribuidas a seus veiculos");
            return false;
        }else
            for (int i = 0; i < array.size(); i++) 
                System.out.println(i + ": " +array.get(i).toString());
    
        System.out.println( array.size() );
        return true;
    }
    
}
