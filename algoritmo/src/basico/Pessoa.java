package basico;

import java.util.ArrayList;

public class Pessoa {
	private String nome = new String();
	private String cidade= new String();
	private ArrayList<Pessoa> conhecidos = new ArrayList<Pessoa>();
	private ArrayList<Pessoa> vizinhos = new ArrayList<Pessoa>();
	private boolean conectado = false;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String municipio) {
		this.cidade = municipio;
	}

	public ArrayList<Pessoa> getConhecidos() {
		return conhecidos;
	}

	public void setConhecidos(ArrayList<Pessoa> conhecidos) {
		this.conhecidos = conhecidos;
	}
	public ArrayList<Pessoa> getVizinhos() {
		return vizinhos;
	}

	public void setVizinhos(ArrayList<Pessoa> vizinhos) {
		this.vizinhos = vizinhos;
	}
	public void addConhecidos(Pessoa p) {
		this.conhecidos.add(p);
	}
	public boolean isConectado() {
		return conectado;
	}

	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}


	
	public Pessoa(String nome, String municipio, ArrayList<Pessoa> conhecidos,ArrayList<Pessoa> vizinhos)
	{
		this.nome = nome;
		this.cidade = municipio;
		this.conhecidos = conhecidos;
		this.conectado = false;
		this.vizinhos = vizinhos;
	}
	
	public Pessoa(String nome,String municipio)
	{
		this.nome = nome;
		this.cidade = municipio;
		this.conectado = false;
		
	}
	public String toString()
	{
		return this.nome + " mora em "+this.cidade;
	}
	public boolean equals(Pessoa p) {
    	if(p.getNome().equalsIgnoreCase(this.getNome())) {
    		return true;
    	}
    	return false;
    }
}
