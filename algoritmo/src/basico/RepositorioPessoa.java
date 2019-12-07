package basico;

import java.util.ArrayList;

public class RepositorioPessoa {
	private ArrayList<Pessoa> pessoas  = new ArrayList(); //grafo
	public static RepositorioPessoa instance;
	

	public static RepositorioPessoa getInstance(){
		
		if(instance==null) {
			instance = new RepositorioPessoa();
		}
		return instance;
	}
	
	public void addConhecidos(Pessoa p,Pessoa p1) {
		p.addConhecidos(p1);
		p1.addConhecidos(p);
	}
	
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public void cadastrar(Pessoa p) {
		pessoas.add(p);
	}
	
	public void remover(Pessoa p) {
		pessoas.remove(p);
	}
	public Pessoa buscar(String nome) {
		for(int i=0;i<pessoas.size();i++) {
			if(pessoas.get(i).getNome().equalsIgnoreCase(nome)){
				return pessoas.get(i);
			}
		}
			return null;
	}
	public ArrayList<Pessoa> buscarPorCidade(String cidade) {
		ArrayList<Pessoa> pm = new ArrayList();
		for(int i=0;i<pessoas.size();i++) {
			if(pessoas.get(i).getCidade().equalsIgnoreCase(cidade)){
				pm.add(pessoas.get(i));
			}
		}
		return pm;
	}
	public ArrayList<Pessoa> connectComponents() {
		ArrayList<Pessoa> cc = new ArrayList();
		for(int i=1;i<pessoas.size();i++) {
			for(int j=0;j<pessoas.get(i).getConhecidos().size();j++){
				if(pessoas.get(i-1).getConhecidos().contains(pessoas.get(i).getConhecidos().get(j))){
					cc.addAll(pessoas.get(i-1).getConhecidos());
					cc.addAll(pessoas.get(i).getConhecidos());
					//t = true;
				}
			}
			
		}
		return cc;

	}
	
	public String toString(){
		String a;
		String b="";
		for(int i=0;i<pessoas.size();i++) {
			 a = i+" - "+ pessoas.get(i).toString()+"\n";
			 b = b+a;
		}
		return b;
	}

	public Pessoa buscarInt(int i) {
		if(pessoas.get(i)!=null){
			return pessoas.get(i);
		}
		return null;
	}
	

}
