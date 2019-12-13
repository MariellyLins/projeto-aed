package basico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.graphstream.graph.Edge;
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
	public Graph grafoCidade = new SingleGraph("Teste2");
	private Map<Pessoa,Integer> Algo = new  HashMap<>();

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

	public void gambiarra() {
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
		if(!p.getConhecidos().contains(p1)) {
			p.addConhecidos(p1);
			p1.addConhecidos(p);
		}
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
		Pessoa Falcao = new Pessoa("Luiz F. Falcão","Recife");

		rep.cadastrar(Falcao);
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
		rep.addConhecidos(Fernando, Falcao);
		rep.addConhecidos(Fernando, Samuel);
		rep.addConhecidos(Samuel, Falcao);
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

	public void acao() throws InterruptedException {
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
		//evita erros quando tentamos buscar algo inexistente:
		grafo.setStrict(false);

		//(tem exemplos no site graphStream de estilos de edição)
		//melhorar qualidade do grafo:
		grafo.addAttribute("ui.quality");
		grafo.addAttribute("ui.antialias");

		//importar imagem de fundo:
		grafo.addAttribute("ui.stylesheet", "graph { fill-mode: image-scaled-ratio-max; fill-image: url('imagens/vacina.jpg'); }");

		//determinar atributos do no
		for (Node node : grafo.getNodeSet()) {
			node.addAttribute("ui.label", node.getId());
			grafo.getNode(node.getId()).setAttribute("ui.style", " size: 30px;fill-mode: image-scaled-ratio-min; fill-image: url('imagens/bac.png');");
		}

		//atributos das arestas 
		for(Edge e: grafo.getEdgeSet()) {
			e.setAttribute("ui.style", "shape: blob; size: 3px; arrow-shape: none;fill-color: #007d8b;");
		}

		grafo.display();


		this.organizar();


		/*for(int i = 0; i < 30; i++) {
        	//exemplo de manipulação de grafo:
        	grafo.removeEdge("Marielly conhece Juliane");
          //para esperar tempo antes de fazer ação:
            Thread.sleep(1000);
        }*/
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

		//evita erros quando tentamos buscar algo inexistente:
		grafoCidade.setStrict(false);

		//(tem exemplos no site graphStream de estilos de edição)
		//melhorar qualidade do grafo:
		grafoCidade.addAttribute("ui.quality");
		grafoCidade.addAttribute("ui.antialias");

		//importar imagem de fundo:
		grafoCidade.addAttribute("ui.stylesheet", "graph { fill-mode: image-scaled-ratio-max; fill-image: url('imagens/População_pernambuco.png'); }");

		//determinar atributos do no
		for (Node node :grafoCidade.getNodeSet()) {
			node.addAttribute("ui.label", node.getId());
			grafoCidade.getNode(node.getId()).setAttribute("ui.style", "text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #A7CC; text-color: white; text-style: bold-italic; text-color: green; text-offset: 5px, 0px;  size: 30px;fill-mode: image-scaled-ratio-min; fill-image: url('imagens/bac.png');");
		}


		//atributos das arestas 
		for(Edge e: grafoCidade.getEdgeSet()) {
			e.setAttribute("ui.style", "shape: blob; size: 3px; arrow-shape: none;fill-color: #007d8b;");
		}

		grafoCidade.display();
		explore(grafoCidade.getNode(0));
	}

	public void explore(Node source) {
		Iterator<? extends Node> k = source.getBreadthFirstIterator();
		Node aux = null;
		while (k.hasNext()) {
			Node next = k.next();
			if(next.getDegree() >= higherDegree() || next.hasEdgeBetween(aux)) {
				next.setAttribute("ui.style", "text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #A7CC; text-color: white; text-style: bold-italic; text-color: green; text-offset: 5px, 0px;  size: 30px;fill-mode: image-scaled-ratio-min; fill-image: url('imagens/bomb animation spritesheet (2).png');");
				aux = next;
			}
			sleep();
		}
	}

	protected void sleep() {
		try { Thread.sleep(1000); } catch (Exception e) {}
	}

	public void preencher() throws InterruptedException {
		for(int i=0;i<this.getPessoas().size();i++) {
			Thread.sleep(1000);
			Integer j = i;
			Algo.put(this.buscarInt(i),j);		
			grafo.getNode(i).setAttribute("ui.label", i);
			grafo.getNode(i).setAttribute("ui.style", " size: 30px;fill-mode: image-scaled-ratio-min; fill-image: url('imagens/bac.png');");
		}
	}

	public void organizar() throws InterruptedException {
		preencher();
		ArrayList<Pessoa> mudados = new ArrayList<>();

		for(int i=0;i<Algo.size();i++) {
			Pessoa t = this.getPessoas().get(i);

			for(int j=0; j< this.getPessoas().get(i).getConhecidos().size();j++) {
				if(this.getPessoas().get(i).getConhecidos().get(j).isConectado()) {
					mudados.add(this.getPessoas().get(i).getConhecidos().get(j));					
				}
			}

			if(!mudados.isEmpty()) {	
				Thread.sleep(1000);
				Algo.replace(t,Algo.get(t),Algo.get(mudados.get(0)));
				grafo.getNode(t.getNome()).setAttribute("ui.label",Algo.get(t));
				grafo.getNode(t.getNome()).setAttribute("ui.style", " size: 30px;fill-mode: image-scaled-ratio-min; fill-image: url('imagens/bac.png');");

				if(mudados.size()>1) {
					ajeitandoGrafo(mudados,t);
				}
				mudados.clear();
			}				

			for(int j=0; j< this.getPessoas().get(i).getConhecidos().size();j++) {
				Pessoa g = t.getConhecidos().get(j);
				Algo.replace(g, Algo.get(g), Algo.get(t));
				grafo.getNode(g.getNome()).setAttribute("ui.label",Algo.get(t));
				grafo.getNode(g.getNome()).setAttribute("ui.style", " size: 30px;fill-mode: image-scaled-ratio-min; fill-image: url('imagens/bac.png');");
				g.setConectado(true);	
			}
			t.setConectado(true);	  

		}
		limparCC();
	}

	public void ajeitandoGrafo(ArrayList<Pessoa> mudados,Pessoa t) throws InterruptedException {
		Set<Integer> erro = new HashSet<>();
		for(int i=0;i<mudados.size();i++) {
			erro.add(Algo.get(mudados.get(i)));
		}

		if(erro.size()>1) {
			for(int i=0; i< this.getPessoas().size();i++) {
				Pessoa g = this.getPessoas().get(i);
				if(erro.contains((Integer)Algo.get(g))) {
					Thread.sleep(1000);
					Algo.replace(g, Algo.get(g), Algo.get(t));
					grafo.getNode(g.getNome()).setAttribute("ui.label",Algo.get(t));
					grafo.getNode(g.getNome()).setAttribute("ui.style", " size: 30px;fill-mode: image-scaled-ratio-min; fill-image: url('imagens/bac.png');");

				}
			}

		}
	}

	public void limparCC() {
		for(int i=0;i<this.getPessoas().size();i++) {
			this.getPessoas().get(i).setConectado(false);
		}
		Algo.clear();
	}

	public ArrayList<ArrayList<Pessoa>> Montando(){
		ArrayList<ArrayList<Pessoa>> cliques = new ArrayList<ArrayList<Pessoa>>();
		int w=0;

		for(int i=0;i<getPessoasPorCidade().size();i++){
			Pessoa temp = getPessoasPorCidade().get(i);           

			for(Pessoa p: temp.getVizinhos()){
				cliques.add(new ArrayList<Pessoa>());

				for(Pessoa d: p.getVizinhos()){
					if(temp.getVizinhos().contains(d)){
						if(!cliques.get(w).contains(d)){
							if(temp.getCidade().equals(d.getCidade()))
								cliques.get(w).add(d);
						}
					}
				}

				if(!cliques.get(w).contains(p)){
					if(temp.getCidade().equals(p.getCidade()))
						cliques.get(w).add(p);
				}

				if(!cliques.get(w).contains(temp)){
					cliques.get(w).add(temp);
				}
				w++;
			}
		}
		return cliques;
	}

	public int higherDegree() {
		ArrayList<ArrayList<Pessoa>> cliques = Montando();
		int maior = -1;

		for(int i=0;i<cliques.size();i++){
			if(cliques.get(i).size()>maior){
				maior = cliques.get(i).size();
			}
		}
		return maior;
	}
}
