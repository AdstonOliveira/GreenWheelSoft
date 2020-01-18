/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwheelsoft.models.carro;

public class Carro {
    
    protected String nome, cor;
    protected int vinNumber;
    //pecas
    protected CxVelocidade cx_velocidade;
    protected Motor motor;
    protected Portas portas;
    protected Rodas rodas;
    protected Transmissao transmissao;
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(int vinNumber) {
        this.vinNumber = vinNumber;
    }

    public CxVelocidade getCx_velocidade() {
        return cx_velocidade;
    }

    public void setCx_velocidade(CxVelocidade cx_velocidade) {
        this.cx_velocidade = cx_velocidade;
        this.cx_velocidade.adicionaHistorico(this);
    }

    public EngineType getEngine_type() {
        return this.motor.getEngine_type();
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
        this.motor.adicionaHistorico(this);
    }

    public Portas getPortas() {
        return portas;
    }

    public void setPortas(Portas portas) {
        this.portas = portas;
        this.portas.adicionaHistorico(this);
    }

    public Rodas getRodas() {
        return rodas;
    }

    public void setRodas(Rodas rodas) {
        this.rodas = rodas;
        this.rodas.adicionaHistorico(this);
    }

    public Transmissao getTransmissao() {
        return transmissao;
    }

    public void setTransmissao(Transmissao transmissao) {
        this.transmissao = transmissao;
        this.transmissao.adicionaHistorico(this);
    }


    @Override
    public String toString() {
        return "Carro{" + "nome=" + nome + ", cor=" + cor + ", vinNumber=" + vinNumber + ", cx_velocidade=" + cx_velocidade.toString() + ", motor=" + motor.toString() + ", portas=" + portas.toString() + ", rodas=" + rodas.toString() + ", transmissao=" + transmissao.toString() + '}';
    }

    public Peca transferirPeca(Peca peca){
    
        if(peca instanceof Motor){
            Motor transferir = this.motor;
            this.motor = null;
            return transferir;
        }
        
        if(peca instanceof CxVelocidade){
            CxVelocidade cx = this.cx_velocidade;
            this.cx_velocidade = null;
            return cx;
        }
        
        if(peca instanceof Portas){
            Portas porta = this.portas;
            this.portas = null;
            return porta;
        }
        
        if(peca instanceof Rodas){
            Rodas roda = this.rodas;
            this.rodas = null;
            return roda;
        }
        
        if(peca instanceof Transmissao){
            Transmissao t = this.transmissao;
            this.transmissao = null;
            return t;
        }
            
        System.out.println("Peca não identificada");
        return null;
    }
    
    @Override
    public boolean equals(Object carro){
        
        if(carro instanceof Carro){
            Carro other = (Carro) carro;
            return this.getNome().equalsIgnoreCase(other.getNome());
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        if(this instanceof CarroNovo){
            return 1;
        }
        return 0;
    }
    
    
    
    
}
