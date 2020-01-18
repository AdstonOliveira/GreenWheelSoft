package greenwheelsoft;

import greenwheelsoft.models.concessionaria.Concessionaria;
import java.util.ArrayList;
import java.util.Random;

public class InicializaEmpresas {
    
    private ArrayList<String> nomes = new ArrayList();
    private ArrayList<String> ruas = new ArrayList();
    private ArrayList<String> cidades = new ArrayList();
    private ArrayList<Concessionaria> empresas = new ArrayList();
    
    private int count = 0;
    
    public InicializaEmpresas(){
        this.preencheDados();
    }
    
    public final void preencheDados(){
    
        for (int i = 0; i < 50; i++) {
            this.nomes.add("Concessionária GreenWheel " + i);
            this.ruas.add("Rua " + (i+10));
            this.cidades.add("Cidade " + (i+50));
        }
    
    }
    
    
    public void setDados( Concessionaria c ){
        Random r = new Random();
        
        int i = r.nextInt( this.nomes.size() );
        c.setNome( this.nomes.get(i) );
        this.nomes.remove(i);
        
        c.setEndereco(this.ruas.get(i) + " " + this.cidades.get(i));
        this.ruas.remove(i);
        this.cidades.remove(i);
    }
    
    public void inicializaEmpresas(){
        for (int i = 0; i < 50; i++) {
            Concessionaria c = new Concessionaria();
            this.setDados(c);
            this.empresas.add(c);
        }
    }

    public ArrayList<String> getNomes() {
        return nomes;
    }

    public void setNomes(ArrayList<String> nomes) {
        this.nomes = nomes;
    }

    public ArrayList<String> getRuas() {
        return ruas;
    }

    public void setRuas(ArrayList<String> ruas) {
        this.ruas = ruas;
    }

    public ArrayList<String> getCidades() {
        return cidades;
    }

    public void setCidades(ArrayList<String> cidades) {
        this.cidades = cidades;
    }

    public ArrayList<Concessionaria> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Concessionaria> empresas) {
        this.empresas = empresas;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
