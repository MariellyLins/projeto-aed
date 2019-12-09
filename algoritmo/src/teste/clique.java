package teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import basico.Pessoa;
import basico.RepositorioPessoa;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.spriteManager.*;
import org.graphstream.ui.view.Viewer;

import org.graphstream.algorithm.ConnectedComponents;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;

public class clique {

	public static void main(String[] args) {
		Graph grafo = new SingleGraph("Teste");
		
		
		
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
		
		rep.cadastrar(Falcão);
		rep.cadastrar(Fernando);
		rep.cadastrar(Fernanda);
		rep.cadastrar(Lucas);
		rep.cadastrar(Rodrigues);
		rep.cadastrar(Samuel);
		rep.cadastrar(Victor);
		rep.cadastrar(Sabrina);
		rep.cadastrar(Matheus);
		rep.cadastrar(MariaGuilia);
		rep.cadastrar(Maely);
		rep.cadastrar(Marielly);
		rep.cadastrar(Juliane);
		rep.cadastrar(Jose);
		rep.cadastrar(MariadasDores);
		rep.cadastrar(Carlos);
		rep.cadastrar(MariaLucia);
		


        rep.addConhecidos(Fernando,Falcão);
        rep.addConhecidos(Fernando, Samuel);
        rep.addConhecidos(Samuel, Falcão);
        rep.addConhecidos(Jose, Samuel);
        

		rep.addConhecidos(MariaLucia,Matheus);
		rep.addConhecidos(MariaLucia,MariadasDores);
		rep.addConhecidos(Victor, Matheus);
		rep.addConhecidos(Matheus, MariadasDores);
		rep.addConhecidos(Victor, MariadasDores);

		rep.addConhecidos(Carlos,Marielly);
		rep.addConhecidos(Carlos,Maely);
		rep.addConhecidos(Carlos,Fernanda);
		rep.addConhecidos(Carlos,Juliane);
		
		rep.addConhecidos(Marielly,Sabrina);
		rep.addConhecidos(Marielly,Fernanda);
		rep.addConhecidos(Marielly,Maely);
	    rep.addConhecidos(Marielly,Juliane);
	    rep.addConhecidos(Marielly,Lucas);
	    
	   
	    
	    rep.addConhecidos(Juliane,Lucas);
	    rep.addConhecidos(Juliane,Rodrigues);
	    rep.addConhecidos(MariaGuilia,Rodrigues);
	    rep.addConhecidos(Juliane,Fernanda);
	    rep.addConhecidos(Juliane,Maely);
	    rep.addConhecidos(Juliane,MariaGuilia);
	    
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------------------------------------\n\tPesquisa de Universidade Federal Rural");
		String resp1="Sim";
		while(resp1.equalsIgnoreCase("Sim"))
		{
			System.out.println("\tVocê deseja adicionar um participante? ");
			resp1= sc.next();
			while(!resp1.equalsIgnoreCase("Sim")&&!resp1.equalsIgnoreCase("Não")){
				System.out.println("Digite uma resposta valida");
				resp1 = sc.next();
			}
			if(resp1.equalsIgnoreCase("Sim")) {
				System.out.println("Digite o nome do participante: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.println("Digite a cidade em que ele reside: ");
				String cidade = sc.nextLine();
				System.out.println(rep.toString());
				System.out.println("O/a participante tem contato direto com algum dos demais participantes listados acima?");
				rep.cadastrar(new Pessoa(nome,cidade));
				String resp2 = "Sim";
				while(resp2.equalsIgnoreCase("Sim")) {
					System.out.println("Digite seu numero correspondente ou  "+(rep.getPessoas().size()+1)+" para sair: ");
					int posi = sc.nextInt();
					if(posi!=rep.getPessoas().size()+1) {
					  rep.addConhecidos(rep.buscar(nome),rep.buscarInt(posi));
					}
					System.out.println("Deseja adicionar mais conhecidos para esse participante? ");
					resp2= sc.next();
					while(!resp2.equalsIgnoreCase("Sim")&&!resp2.equalsIgnoreCase("Não")){
						System.out.println("Digite uma resposta valida");
						resp2 = sc.next();
					}
				}
			}
		    
	    
		}
		//Um grafo seria uma ArrayList? 
		
		for(int i=0;i<rep.getPessoas().size();i++) {
			grafo.addNode(rep.buscarInt(i).getNome());
			
		}
		for(int i=0;i<rep.getPessoas().size();i++) {
			for(int j=0;j<rep.buscarInt(i).getConhecidos().size();j++) {
               if((grafo.getEdge(rep.buscarInt(i).getConhecidos().get(j).getNome()+" conhece "+rep.buscarInt(i).getNome()))==null)
				grafo.addEdge(rep.buscarInt(i).getNome()+" conhece "+rep.buscarInt(i).getConhecidos().get(j).getNome(), rep.buscarInt(i).getNome(),rep.buscarInt(i).getConhecidos().get(j).getNome());
			}
		}
		
		System.out.println("Pessoas cadastradas para o experimento com o Discreta-Vírus:");
	    System.out.println(rep.toString());
	    
	    //SpriteManager sman = new SpriteManager(grafo);
	   // Sprite s = sman.addSprite("S1");
	   // s.attachToNode("Maely Coutinho");
	    
	    System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
	    
	   // Viewer viewer = grafo.display();
	   // viewer.disableAutoLayout();
	    
	    
	   // viewer.enableAutoLayout();
	    
	   // grafo.addAttribute("ui.stylesheet", "url('//Users//Maely//git//projeto-aednew//algoritmo//GS/População_pernambuco')");
	    grafo.addAttribute("ui.stylesheet", "graph { fill-color: green; }");
	    grafo.addAttribute("ui.stylesheet", "node {fill-color: red;size: 10px, 10px;fill-mode: plain;stroke-mode: plain;stroke-color: black; }");
	    for (Node node : grafo) {
	        node.addAttribute("ui.label", node.getId());
	    }
	    ConnectedComponents cc = new ConnectedComponents();
		cc.init(grafo);

		System.out.printf("%d connected component(s) no grafo.%n",cc.getConnectedComponentsCount());
		
	    grafo.display();
	    ArrayList<Pessoa> moramEmInventado = rep.buscarPorCidade("Inventado");
	    ArrayList<Pessoa> moramEmRecife = rep.buscarPorCidade("Recife");
	    ArrayList<Pessoa> moramEmVitoria = rep.buscarPorCidade("Vitória");
	   
	    
	}
		

}






