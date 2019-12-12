package basico;

import java.util.ArrayList;
import org.graphstream.algorithm.ConnectedComponents;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;


public class RepositorioPessoa {
	private ArrayList<Pessoa> pessoas  = new ArrayList<Pessoa>(); 
	public static RepositorioPessoa instance;
	private ArrayList<String> cidades = new ArrayList<String>();
	private ArrayList<Pessoa> cid = new ArrayList<>();
	private ArrayList<Pessoa> pessoasPorCidade = new ArrayList<>();
	 public Graph grafo = new SingleGraph("Teste");
	 public Graph  grafoCidade = new SingleGraph("Teste2");
	

	public static RepositorioPessoa getInstance(){
		
		if(instance == null) {
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
	
	public ArrayList<Pessoa> getCid() {
		return cid;
	}

	public void setCid(ArrayList<Pessoa> cid) {
		this.cid = cid;
	}

	public void ganbiarra() {
		ArrayList<Pessoa> um = buscarPorCidade(cidades.get(1));
		ArrayList<Pessoa> dois = buscarPorCidade(cidades.get(2));
		ArrayList<Pessoa> tres = buscarPorCidade(cidades.get(3));
		ArrayList<Pessoa> quatro = buscarPorCidade(cidades.get(4));
		ArrayList<Pessoa> cinco = buscarPorCidade(cidades.get(5));
		ArrayList<Pessoa> seis = buscarPorCidade(cidades.get(6));
		ArrayList<Pessoa> sete = buscarPorCidade(cidades.get(7));
		ArrayList<Pessoa> oito = buscarPorCidade(cidades.get(8));
		ArrayList<Pessoa> zero = buscarPorCidade(cidades.get(0));
		
		
		cid.add(um.get(0));
		cid.add(dois.get(0));
		cid.add(tres.get(0));
		cid.add(quatro.get(0));
		cid.add(cinco.get(0));
		cid.add(seis.get(0));
		cid.add(sete.get(0));
		cid.add(oito.get(0));
		cid.add(zero.get(0));
		
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

	public ArrayList<Pessoa> getPessoasPorCidade() {
		return pessoasPorCidade;
	}

	public void setPessoasPorCidade(ArrayList<Pessoa> pessoasPorCidade) {
		this.pessoasPorCidade = pessoasPorCidade;
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
		ArrayList<Pessoa> pm = new ArrayList<>();
		for(int i=0;i<pessoas.size();i++) {
			if(pessoas.get(i).getCidade().equalsIgnoreCase(cidade)){
				pm.add(pessoas.get(i));
			}
		}
		return pm;
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
		

		//1
        rep.addConhecidos(Fernando,Falcão);
        rep.addConhecidos(Fernando, Samuel);
        rep.addConhecidos(Samuel, Falcão);
        rep.addConhecidos(Jose, Samuel);
       
       
       
        
        //2
		rep.addConhecidos(MariaLucia,Matheus);
		rep.addConhecidos(MariaLucia,MariadasDores);
		rep.addConhecidos(Victor, Matheus);
		rep.addConhecidos(Matheus, MariadasDores);
		rep.addConhecidos(Victor, MariadasDores);
		
        //3
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
	    
	    ganbiarra();
	}
	
	public void iniciarPClique() {
		this.pessoasPorCidade.addAll(pessoas);
		for(int i=0;i<pessoasPorCidade.size();i++) {
			for(int j=0;j<cidades.size();j++) {
				if(pessoasPorCidade.get(i).getCidade().equalsIgnoreCase(cidades.get(j))) {
					 pessoasPorCidade.get(i).setVizinhos(buscarPorCidade(cidades.get(j)));
				     pessoasPorCidade.get(i).getVizinhos().remove(pessoasPorCidade.get(i));
				}
				    
			}
		}
		
		this.pessoasPorCidade.get(3).getVizinhos().add(this.pessoasPorCidade.get(5));
		this.pessoasPorCidade.get(5).getVizinhos().add(this.pessoasPorCidade.get(3));
		this.pessoasPorCidade.get(11).getVizinhos().add(this.pessoasPorCidade.get(5));
		this.pessoasPorCidade.get(5).getVizinhos().add(this.pessoasPorCidade.get(11));
		this.pessoasPorCidade.get(6).getVizinhos().add(this.pessoasPorCidade.get(2));
		this.pessoasPorCidade.get(2).getVizinhos().add(this.pessoasPorCidade.get(6));
		this.pessoasPorCidade.get(2).getVizinhos().add(this.pessoasPorCidade.get(1));
		this.pessoasPorCidade.get(1).getVizinhos().add(this.pessoasPorCidade.get(2));
		this.pessoasPorCidade.get(8).getVizinhos().add(this.pessoasPorCidade.get(10));
		this.pessoasPorCidade.get(10).getVizinhos().add(this.pessoasPorCidade.get(8));
		this.pessoasPorCidade.get(15).getVizinhos().add(this.pessoasPorCidade.get(10));
		this.pessoasPorCidade.get(10).getVizinhos().add(this.pessoasPorCidade.get(15));
		this.pessoasPorCidade.get(15).getVizinhos().add(this.pessoasPorCidade.get(11));
		this.pessoasPorCidade.get(11).getVizinhos().add(this.pessoasPorCidade.get(15));
		this.pessoasPorCidade.get(15).getVizinhos().add(this.pessoasPorCidade.get(4));
		this.pessoasPorCidade.get(4).getVizinhos().add(this.pessoasPorCidade.get(15));
		
		
		
	}
	
    public void acao() {
        RepositorioPessoa rep = RepositorioPessoa.getInstance();
        for (int i = 0; i < rep.getPessoas().size(); i++) {
            grafo.addNode(rep.buscarInt(i).getNome());

        }
        for (int i = 0; i < rep.getPessoas().size(); i++) {
            for (int j = 0; j < rep.buscarInt(i).getConhecidos().size(); j++) {
                if ((grafo.getEdge(rep.buscarInt(i).getConhecidos().get(j).getNome() + " conhece " + rep.buscarInt(i).getNome())) == null) {
                    grafo.addEdge(rep.buscarInt(i).getNome() + " conhece " + rep.buscarInt(i).getConhecidos().get(j).getNome(), rep.buscarInt(i).getNome(), rep.buscarInt(i).getConhecidos().get(j).getNome());
                }
            }
        }

        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        //grafo.addAttribute("ui.stylesheet", "graph { fill-color: gray;}, node {fill-color: red;size: 10px, 10px;fill-mode: plain;stroke-mode: plain;stroke-color: black; }");
        for (Node node : grafo) {
            node.addAttribute("ui.label", node.getId());
        }
        ConnectedComponents cc = new ConnectedComponents();
        cc.init(grafo);
        grafo.display();

    }
    
    public void acaoClique() {
         for (int i = 0; i < this.pessoasPorCidade.size(); i++) {
        	 grafoCidade.addNode(this.pessoasPorCidade.get(i).getNome());
         }
         for (int i = 0; i < this.pessoasPorCidade.size(); i++) {
             for (int j = 0; j <this.pessoasPorCidade.get(i).getVizinhos().size(); j++) {
                 if (( grafoCidade.getEdge(this.pessoasPorCidade.get(i).getVizinhos().get(j).getNome() + " conhece " + this.pessoasPorCidade.get(i).getNome())) == null) {
                	 grafoCidade.addEdge(this.pessoasPorCidade.get(i).getNome() + " conhece " + this.pessoasPorCidade.get(i).getVizinhos().get(j).getNome(), this.pessoasPorCidade.get(i).getNome(), this.pessoasPorCidade.get(i).getVizinhos().get(j).getNome());
                 }
             }
         }

         System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        // grafoCidade.addAttribute("ui.stylesheet","graph { fill-color: green;}, node {fill-color: red;size: 10px, 10px;fill-mode: plain;stroke-mode: plain;stroke-color: black; }");
         for (Node node : grafoCidade) {
             node.addAttribute("ui.label", node.getId());
         }
         ConnectedComponents cc2 = new ConnectedComponents();
         cc2.init(grafoCidade);
         grafoCidade.display();
    }

}
