package projetoAED;

import java.util.LinkedList;

class Grafo {
	
	/*
	 * Uma classe é definida para representação de Grafo
	 * Um grafo é um array de listas de adjacência
	 * O tamanho do Array será 'V' (nº de vértices no grafo)
	 * 
	 */
	int V; 
	LinkedList<String>[] listaAdjacencia; //Lista de adjacências
	
	/*
	 * Construtor
	 */
	
	Grafo(int V){
		this.V = V;
		listaAdjacencia = new LinkedList[V]; //Define o número de vértices como o tamanho do array
		
		// Para cada vértice é criada uma linked list para armazenar os nós adjacentes 
        for(int i = 0; i < V ; i++){ 
        	listaAdjacencia[i] = new LinkedList<String>(); 
        } 
	}
	
	int buscaIndice(String nome) {
		int aux = 0;
		for(int i = 0; i < listaAdjacencia.length ; i++){
			if(listaAdjacencia[i].contains(nome))
				aux = i;
		}
		return aux;
	}
	
	/*
	 * Adiciona uma aresta ao grafo unidirecional 
	 */
    void adicionaAresta( String origem, String destino) { 
        // Adiciona uma aresta da origem ao destino 
        listaAdjacencia[buscaIndice(origem)].add(destino);
  
        //Já que o grafo é unidirecional, adiciona uma aresta do destino até a origem
        listaAdjacencia[buscaIndice(destino)].add(origem);
    } 
	
    void DFSUtil(int v, boolean[] visitado) { 
        // Marca o nó atual como visitado e imprime
    	visitado[v] = true; 
        System.out.print(v+" "); 
        // Recursivo para todos os vértices adjacentes
        for (String x : listaAdjacencia[v]) { 
            if(!visitado[buscaIndice(x)]) DFSUtil(buscaIndice(x),visitado); 
        } 
    }
	
    void connectedComponents() { 
        // Marca todos os vértices como não visitados
        boolean[] visitado = new boolean[V]; 
        for(int v = 0; v < V; ++v) { 
            if(!visitado[v]) { 
                // imprime todos os vértices acessíveis a v
                DFSUtil(v,visitado); 
                System.out.println(); 
            } 
        } 
    } 
    
    /*
     * Programa Teste
     */
	public static void main(String[] args) {
        Grafo g = new Grafo(5); // 5 vertices numerados do 0 ao 4  
          
        g.adicionaAresta("Paulo", "Maria");  
        g.adicionaAresta("Maria", "João");  
        g.adicionaAresta("Carlos", "Silvia"); 
        g.adicionaAresta("Paulo", "João");
        System.out.println("São fortemente conectados: "); 
        g.connectedComponents(); 
	}

}
