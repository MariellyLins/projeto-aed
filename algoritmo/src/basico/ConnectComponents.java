package basico;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

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
		ArrayList<Pessoa> mudados = new ArrayList<>();
		for(int i=0;i<algo.size();i++) {
			for(int j=0; j< rep.getPessoas().get(i).getConhecidos().size();j++) {
				if(rep.getPessoas().get(i).getConhecidos().get(j).isConectado())
					mudados.add(rep.getPessoas().get(i).getConhecidos().get(j));
			}
			Pessoa t = rep.getPessoas().get(i);
			if(!mudados.isEmpty()) {
				algo.replace(t,algo.get(t),algo.get(mudados.get(0)));
			    if(mudados.size()>1)
			      ajeitandoGrafo(mudados,t);
			}				
			   
			for(int j=0; j< rep.getPessoas().get(i).getConhecidos().size();j++) {
				Pessoa g = t.getConhecidos().get(j);
				algo.replace(g, algo.get(g), algo.get(t));
				 g.setConectado(true);
				 t.setConectado(true);				
			}
		}
		
		
	}
	public void ajeitandoGrafo(ArrayList<Pessoa> mudados,Pessoa t) {
		Set<Pessoa> mudados2= new HashSet<>();
		
		mudados2.addAll(mudados);
    	if(mudados2.size()>1) {
    		for(Object value: algo.values()) {
	    		for(Pessoa p: mudados2)
	    		  if(value.equals(algo.get(p)))
	    			  value = algo.get(t);
	    	}
    	}
	    	
    	
    	
    }
    public int retornarCC() {
    	organizar();
    	
    	ArrayList<Integer> total = new ArrayList<Integer>();
    	
    	for(Object value: algo.values()) {
    		total.add((Integer)value);
    	}
    	
    	
    	ArrayList<Integer> r = new ArrayList<>();
    	
    	for(int i=0;i<total.size();i++) {
    		if(!r.contains(total.get(i))) {
    			r.add(total.get(i));
    		}
    	}
    	return r.size();
    }
}
