package basico;

import java.util.ArrayList;
import org.graphstream.algorithm.ConnectedComponents;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import java.util.Scanner;
import basico.Pessoa;
import basico.RepositorioPessoa;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;


public class RepositorioPessoa {
	private ArrayList<Pessoa> pessoas  = new ArrayList<Pessoa>(); 
	public static RepositorioPessoa instance;
	private ArrayList<String> cidades = new ArrayList<String>();
	 public Graph grafo = new SingleGraph("Teste");
	

	public static RepositorioPessoa getInstance(){
		
		if(instance==null) {
			instance = new RepositorioPessoa();
		}
		return instance;
	}
	
	private RepositorioPessoa() {
		cidades.add("Vitória");
		cidades.add("Recife");
		cidades.add("Não existe");
		cidades.add("Olinda");
		cidades.add("Ribeirão");
		cidades.add("Socorro");
		cidades.add("Inventado");
		cidades.add("Boa Viagem");
		cidades.add("Camaragibe");
	}
	
	
	public ArrayList<String> getCidades() {
		return cidades;
	}

	public void setCidades(ArrayList<String> cidades) {
		this.cidades = cidades;
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
		if(!pessoas.contains(p))
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
	
	public void iniciarPessoas() {
		RepositorioPessoa rep = RepositorioPessoa.getInstance();
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
	}
	
    public void acao() {
    	RepositorioPessoa rep = RepositorioPessoa.getInstance();
		for(int i=0;i<rep.getPessoas().size();i++) {
			grafo.addNode(rep.buscarInt(i).getNome());
			
		}
		for(int i=0;i<rep.getPessoas().size();i++) {
			for(int j=0;j<rep.buscarInt(i).getConhecidos().size();j++) {
               if((grafo.getEdge(rep.buscarInt(i).getConhecidos().get(j).getNome()+" conhece "+rep.buscarInt(i).getNome()))==null)
				grafo.addEdge(rep.buscarInt(i).getNome()+" conhece "+rep.buscarInt(i).getConhecidos().get(j).getNome(), rep.buscarInt(i).getNome(),rep.buscarInt(i).getConhecidos().get(j).getNome());
			}
		}
		
	    
	    System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
	    grafo.addAttribute("ui.stylesheet", "graph { fill-color: green; }");
	    grafo.addAttribute("ui.stylesheet", "node {fill-color: red;size: 10px, 10px;fill-mode: plain;stroke-mode: plain;stroke-color: black; }");
	    for (Node node : grafo) {
	        node.addAttribute("ui.label", node.getId());
	    }
	    ConnectedComponents cc = new ConnectedComponents();
		cc.init(grafo);

		//System.out.printf("%d connected component(s) no grafo.%n",cc.getConnectedComponentsCount());
		
	    grafo.display();
	    ArrayList<Pessoa> moramEmInventado = rep.buscarPorCidade("Inventado");
	    ArrayList<Pessoa> moramEmRecife = rep.buscarPorCidade("Recife");
	    ArrayList<Pessoa> moramEmVitoria = rep.buscarPorCidade("Vitória");
	   
	    
    }
    
    	
}
