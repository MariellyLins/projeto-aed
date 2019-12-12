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
}
