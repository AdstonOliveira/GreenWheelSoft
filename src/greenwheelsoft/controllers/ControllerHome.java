package greenwheelsoft.controllers;

import greenwheelsoft.CarrosDescartados;
import greenwheelsoft.IniciaCarrosExistentes;
import greenwheelsoft.InicializaEmpresas;
import greenwheelsoft.InicializaPecas;
import greenwheelsoft.IniciarNovosCarros;
import greenwheelsoft.models.carro.Carro;
import greenwheelsoft.views.Home;
import greenwheelsoft.views.Listar;
import java.util.Random;

public class ControllerHome {

    private Home viewHome;
    private IniciaCarrosExistentes existentes;
    private IniciarNovosCarros novos;
    private InicializaPecas pecas;
    private InicializaEmpresas empresas;
    
    public ControllerHome(Home viewHome) {
        this.viewHome = viewHome;
        this.viewHome.setController(this);
        this.iniciar();
    }

    
    public void iniciar(){
        this.viewHome.setVisible(true);
    }

    public String[] inicializarPecas(){
        if(this.pecas == null){
            this.pecas = new InicializaPecas();
            return retorno(1, "Todas as Peças Criadas");
        }else{
            return retorno(0, "Peças já foram inicializadas anteriormente");
        }
    }
    
    public String[] inicializarExistentes(){
        if(this.existentes == null){
            this.existentes = new IniciaCarrosExistentes(this.pecas);
           
            return retorno(1, "Carros existentes gerados com sucesso");
        }else{
            return retorno(0, "Os carros já estavam criados");
        }
    }
    
    public String[] inicializarNovos(){
        
        if(this.novos == null && this.existentes != null ){
            this.novos = new IniciarNovosCarros( this.existentes.getCarros() );
            this.existentes.atualizaAntigos( this.novos.getAntigos() );
            
            return retorno(1, "Novos carros gerados com sucesso");
        }else{
            return retorno(0, "Os carros já estavam criados");
        }
    }
    
    public String[] iniciarEmpresas(){
        if(this.empresas == null){
            this.empresas = new InicializaEmpresas();
            this.empresas.inicializaEmpresas();
            
            return retorno(1, "Empresas Inicializadas");
        }else{
            return retorno(0, "Empresas foram inicializadas anteriormente");
        }
    }
    
    public void imprimirAntigos(){
    
           System.out.println(this.existentes.getCarros().size());
           System.out.println(this.novos.getAntigos().size());
        
    }
    
    private Listar lc;
    
    public boolean listaCarrosAntigos(){
        this.lc = new Listar();

        if(this.existentes != null){
            lc.setTitulo("Carros Existentes");

            lc.setModel(this.existentes.getCarros(), false);
            
            lc.setVisible(true);
            return true;
        }
        
        return false;
    }
    
    public void listaCarrosNovos(){
        Listar ce = new Listar();
        ce.setTitulo("Carros Novos Modelos");
        ce.setModel(this.novos.getNovos(), false);
        ce.setVisible(true);
    }
    
   
    
    public void listaEmpresas(){
        if(this.empresas != null){
            Listar ce = new Listar();
            ce.setTitulo("Empresas Disponiveis");
            System.out.println(empresas.getCidades().size());
            ce.setModel( this.empresas.getEmpresas() );
            
            ce.setVisible(true);
        }
    }
    
    public void listaDesmontados(){
        if(this.novos != null){
            Listar ce = new Listar();
            ce.setTitulo("Carros no patio já utilizados");
            
            ce.setModel( CarrosDescartados.descartados, true );
            ce.changeLB("Veiculos Desmontados no Patio: ");
            ce.setVisible(true); 
        }
    }
    
    public String[] distribuir(){
        if( this.empresas != null && this.novos.getNovos().size() > 0){
            Random rand = new Random();
            //Distribui igualmente os veiculos porém de forma aleatoria
            
            this.empresas.getEmpresas().forEach((c) -> {
                for( int i = 0; i < 10; i++ ){
                    Carro novo = this.novos.getNovos().get(rand.nextInt(this.novos.getNovos().size()));
                    Carro antigo = this.novos.getAntigos().get(rand.nextInt(this.novos.getAntigos().size()));
                    
                    c.add( novo );
                    c.add( antigo );
                    
                    this.novos.getNovos().remove(novo);
                    this.novos.getAntigos().remove(antigo);
                }
            });
            
            return this.retorno(1, "Veículos distribuidas");
        }else{
            return this.retorno(0, "Veiculos já foram distribuidas anteriormente");
        }
    }
    
    
    public Home getViewHome() {
        return viewHome;
    }

    public IniciaCarrosExistentes getExistentes() {
        return existentes;
    }

    public InicializaPecas getPecas() {
        return pecas;
    }
    
    public String[] retorno(int status, String causa){
        String[] retornar = new String[3];
        
        if(status == 1){
            retornar[0] = "Sucesso";
            retornar[1] = causa; 
            retornar[2] = "1";
        }else{
            retornar[0] = "Erro";
            retornar[1] = causa; 
            retornar[2] = "0";
        }
            
        return retornar;
    }
    
    
}
