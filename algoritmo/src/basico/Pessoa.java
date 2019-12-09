package basico;

import java.util.ArrayList;

public class Pessoa {
	private String nome = new String();
	private String cidade= new String();
	private ArrayList<Pessoa> conhecidos = new ArrayList<Pessoa>();
	private boolean curado;
	
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
	public void addConhecidos(Pessoa p) {
		this.conhecidos.add(p);
	}
	public boolean isCurado() {
		return curado;
	}

	public void setCurado(boolean curado) {
		this.curado = curado;
	}


	
	public Pessoa(String nome, String municipio, ArrayList<Pessoa> conhecidos)
	{
		this.nome = nome;
		this.cidade = municipio;
		this.conhecidos = conhecidos;
		
	}
	
	public Pessoa(String nome,String municipio)
	{
		this.nome = nome;
		this.cidade = municipio;
		this.conhecidos = new ArrayList<Pessoa>();
		
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
