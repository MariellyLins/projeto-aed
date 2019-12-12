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
			System.out.println("Vez de "+t.getNome()+" seu valor é "+algo.get(t));
			
				System.out.println("Não esta conectado");
				for(int j=0; j< rep.getPessoas().get(i).getConhecidos().size();j++) {
					if(rep.getPessoas().get(i).getConhecidos().get(j).isConectado()) {
						mudados.add(rep.getPessoas().get(i).getConhecidos().get(j));
						System.out.println("nó tem conhecido "+j+" já conectado");
					   
					}
						
				}
				
				if(!mudados.isEmpty()) {					
					algo.replace(t,algo.get(t),algo.get(mudados.get(0)));
					System.out.println("valor de "+t.getNome()+" mudou para "+algo.get(t));
					 
				    if(mudados.size()>1) {
				    	  System.out.println(t.getNome()+" tem "+mudados.size()+" nós conectados");
					      ajeitandoGrafo(mudados,t);
				    }
				    	
				    
				    mudados.clear();
				}				
				   
				
			
			for(int j=0; j< rep.getPessoas().get(i).getConhecidos().size();j++) {
				Pessoa g = t.getConhecidos().get(j);
				System.out.println("valou de "+g.getNome()+" era "+algo.get(g));
				 algo.replace(g, algo.get(g), algo.get(t));
				 System.out.println("valou de "+g.getNome()+" mudou para "+algo.get(g));
				 g.setConectado(true);
				 System.out.println(g.getNome()+" conectado "+g.isConectado());		
			}
			t.setConectado(true);	  
			System.out.println(t.getNome()+" conectado "+t.isConectado());		
		
		}
		
	}
	public void ajeitandoGrafo(ArrayList<Pessoa> mudados,Pessoa t) {
		Set<Integer> erro = new HashSet<>();
		for(int i=0;i<mudados.size();i++) {
			erro.add(algo.get(mudados.get(i)));
		}

	
    	if(erro.size()>1) {
    		for(Object value: algo.values()) {
	    		  if(erro.contains((Integer)value)) {
	    			  System.out.println("Valor é "+ value);
	    			  value = algo.get(t);
	    			  System.out.println("valou mudou para "+algo.get(t));
	  	    		 
	    		  }
	    			 
	    	}
    	}
	    	
    	
    	
    }
	public void limparCC() {
		for(int i=0;i<rep.getPessoas().size();i++) {
            rep.getPessoas().get(i).setConectado(false);
		}
		algo.clear();
	}
    public int retornarCC() {
    	organizar();
    	
    	 Set<Integer> r = new HashSet<>();
    	for(Object value: algo.values()) {
    		r.add((Integer)value);
    	}
    	System.out.println(r.toString());
    	limparCC();
    	return r.size();
    }
    
}
