package greenwheelsoft.controllers;

import greenwheelsoft.models.concessionaria.Concessionaria;
import greenwheelsoft.views.Listar;

public class ControllerEmpresa {
    private Concessionaria c;
    
    public ControllerEmpresa(Concessionaria c){
        this.c = c;
    }
    
    public void exibirDetalhes(){
        Listar listar = new Listar();
        
        listar.setTitulo("Carros da empresa: " + this.c.getNome());
            listar.setModel( this.c.getInventario().getInventario(), false );
            listar.changeLB("Veiculos disponiveis no estoque: "+ this.c.getInventario().getInventario().size());

            this.c.getInventario().exibir();
            listar.setVisible(true);
    }
    
}
