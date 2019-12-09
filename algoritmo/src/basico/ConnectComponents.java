package basico;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class ConnectComponents {
	private RepositorioPessoa rep = RepositorioPessoa.getInstance();
	private Map<Pessoa,Integer> algo = new  HashMap<>();
	
	public void preencher() {
		for(int i=0;i<rep.getPessoas().size();i++) {
			Integer j = i;
			algo.put(rep.buscarInt(i),j);
		}
	}
	
	public void organizar() {
		preencher();
		for(int i=0;i<algo.size();i++) {
			for(int j=0; j< rep.getPessoas().get(i).getConhecidos().size();j++) {
				Pessoa t = rep.getPessoas().get(i);
				Pessoa g = t.getConhecidos().get(j);
				algo.replace(g, algo.get(g), algo.get(t));
				
			}
		}
	}
	
    public int retornarCC() {
    	organizar();
    	Collection<Integer> c = algo.values();
    	
    	//ArrayList<Integer> total = (ArrayList<Integer>) c;
    	
    	Integer[] separado = (Integer[]) c.toArray();
    	ArrayList<Integer> r = new ArrayList<>();
    	
    	for(int i=0;i<separado.length;i++) {
    		if(!r.contains(separado[i])) {
    			r.add(separado[i]);
    		}
    	}
    	return r.size();
    }
}
