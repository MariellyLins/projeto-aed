package basico;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clique {
	
	private RepositorioPessoa rep = RepositorioPessoa.getInstance();
	private Map<Pessoa, Integer> grafo = new HashMap<>();
	
	public void preencher() {
		for(int i=0;i<rep.getPessoas().size();i++) {
			Integer j = i;
			grafo.put(rep.buscarInt(i),j);
		}
	}
	
	public List<Pessoa> organizar() {
		preencher();
		List<Pessoa> closed = new ArrayList<>();
		Pessoa x = null;
		Pessoa y = null;
		
		for(int i=0, j=0; i<grafo.size() && j<grafo.size(); i++, j++) {
			x = rep.getPessoas().get(i);
			y = rep.getPessoas().get(j);
			
			if(x.getVizinhos().contains(y)) {
				x.getVizinhos().remove(y);
				if(x.getVizinhos().containsAll(y.getVizinhos())) {
					closed.add(x);
					closed.add(y);
				}
			}
		}
		return closed;
	}
	 public ArrayList<ArrayList<Pessoa>> Montando(){
       ArrayList<ArrayList<Pessoa>> cliques = new ArrayList<ArrayList<Pessoa>>();
       int w=0;
       for(int i=0;i<rep.getPessoasPorCidade().size();i++){
         Pessoa temp = rep.getPessoasPorCidade().get(i);           
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

  public ArrayList<String> MaiorIndice(){
       ArrayList<ArrayList<Pessoa>> cliques = Montando();
       ArrayList<String> cidadesMaisAfetadas = new ArrayList<String>();
       int maior = -1;
       int posi=0;
       for(int i=0;i<cliques.size();i++){
          if(cliques.get(i).size()>maior){
              maior = cliques.get(i).size();
              posi = i;
          }
       }
       System.out.println(maior);
       if(cliques.size()>0)
         cidadesMaisAfetadas.add(cliques.get(posi).get(0).getCidade());
       for(int i=0;i<cliques.size();i++){
          if(cliques.get(i).size()== maior){
              if(!cidadesMaisAfetadas.contains(cliques.get(i).get(0).getCidade()))
               cidadesMaisAfetadas.add(cliques.get(i).get(0).getCidade());
          }
       }
      return cidadesMaisAfetadas;
  }
}
