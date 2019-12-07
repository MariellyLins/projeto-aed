package teste;

import java.util.ArrayList;
import java.util.Arrays;

import basico.Pessoa;
import basico.RepositorioPessoa;

public class clique {

	public static void main(String[] args) {
		RepositorioPessoa rep = RepositorioPessoa.getInstance();
		
		//pessoas que possuem alguma doença X:
		Pessoa MariaLucia = new Pessoa("Maria Lucia da Silva","Inventado");
		Pessoa MariadasDores = new Pessoa("Maria das Dores Costa","Inventado");
		Pessoa Carlos = new Pessoa("Carlos Bragão","Não existe");
		Pessoa Jose = new Pessoa("José Rocha","Vitória");
		Pessoa Marielly = new Pessoa("Marielly","Ribeirão");
		Pessoa Juliane = new Pessoa("Juliane","Inventado");
		Pessoa Maely = new Pessoa("Maely Coutinho","Socorro");
		Pessoa MariaGuilia = new Pessoa("Maria Guilia","Vitória");
		Pessoa Fernanda = new Pessoa("Fernanda","Recife");
		Pessoa Sabrina = new Pessoa("Sabrina","Recife");
		Pessoa Matheus = new Pessoa("Matheus Felipe","Inventado");
		Pessoa Victor = new Pessoa("João Victor","Olinda");
		Pessoa Samuel = new Pessoa("Samuel Justino","Recife");
		Pessoa Rodrigues = new Pessoa("José Rodrigues","Vitória");
		Pessoa Lucas = new Pessoa("Lucas","Boa Viagem");
		Pessoa Fernando = new Pessoa("Luiz Fernando","Camaragibe");
		Pessoa Falcão = new Pessoa("Luiz F. Falcão","Recife");
		
		rep.addConhecido(MariaLucia,Falcão);
		rep.addConhecido(MariaLucia,Fernando);
		rep.addConhecido(MariaLucia,Fernanda);
		rep.addConhecido(MariaLucia,Carlos);
		rep.addConhecido(MariaLucia,MariadasDores);

		rep.addConhecido(Carlos,Marielly);
		rep.addConhecido(Carlos,Samuel);
		rep.addConhecido(Carlos,Matheus);
		rep.addConhecido(Carlos,Juliane);
		
		rep.addConhecido(Marielly,Sabrina);
		rep.addConhecido(Marielly,Matheus);
		rep.addConhecido(Marielly,Maely);
	    rep.addConhecido(Marielly,Jose);
	    rep.addConhecido(Marielly,Lucas);
	    
	    rep.addConhecido(Juliane,Lucas);
	    rep.addConhecido(Juliane,Victor);
	    rep.addConhecido(Juliane,Rodrigues);
	    rep.addConhecido(Juliane,Jose);
	    rep.addConhecido(Juliane,Maely);
	    rep.addConhecido(Juliane,MariaGuilia);
	    
	    ArrayList<Pessoa> moramEmInventado = rep.buscarPorCidade("Inventado");
	    ArrayList<Pessoa> moramEmRecife = rep.buscarPorCidade("Recife");
	    
	    //Um grafo seria uma ArrayList? 
	    
	}

}
