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
			Pessoa t = rep.getPessoas().get(i);
			if(!rep.getPessoas().get(i).isConectado()) {
				for(int j=0; j< rep.getPessoas().get(i).getConhecidos().size();j++) {
					if(rep.getPessoas().get(i).getConhecidos().get(j).isConectado()) {
						mudados.add(rep.getPessoas().get(i).getConhecidos().get(j));
					   
					}
						
				}
				
				if(!mudados.isEmpty()) {					
					algo.replace(t,algo.get(t),algo.get(mudados.get(0)));
					 
				    if(mudados.size()>1)
				      ajeitandoGrafo(mudados,t);
				    
				    mudados.clear();
				}				
				   
				
			}
			for(int j=0; j< rep.getPessoas().get(i).getConhecidos().size();j++) {
				Pessoa g = t.getConhecidos().get(j);
				 algo.replace(g, algo.get(g), algo.get(t));
				 g.setConectado(true);
							
			}
			 t.setConectado(true);	 
			
		}
		
		
	}
	public void ajeitandoGrafo(ArrayList<Pessoa> mudados,Pessoa t) {
		Set<Integer> erro = new HashSet();
		for(int i=0;i<mudados.size();i++) {
			erro.add(algo.get(mudados.get(i)));
		}

	
    	if(erro.size()>1) {
    		for(Object value: algo.values()) {
	    		  if(erro.contains((Integer)value)) {
	    			  value = algo.get(t);
	  	    		 
	    		  }
	    			 
	    	}
    	}
	    	
    	
    	
    }
    public int retornarCC() {
    	organizar();
    	
    	 Set<Integer> r = new HashSet();
    	
    	for(Object value: algo.values()) {
    		r.add((Integer)value);
    	}
    	 	
    	return r.size();
    }
}
