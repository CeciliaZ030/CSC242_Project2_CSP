import java.util.LinkedList;

public class Solver {
	
	String CSP_instantce;
	
	public Solver(String instance) {
		this.CSP_instantce = instance;
	}
	
	AustraliaCSP aus_Solver(AustraliaCSP aus_CSP) {

		
		/**
		 * To do
		 * */
		
		return aus_CSP;
	}
	
	
	LinkedList<City> aus_Backtrack_Search(AustraliaCSP aus_CSP) {
		LinkedList<City> assignment =  new LinkedList<City>();
		return Backtrack(assignment, aus_CSP);	
	}
	
	LinkedList<City> Backtrack(LinkedList<City> assignment, AustraliaCSP aus_CSP) {
		LinkedList<City> shadow_copy = (LinkedList<City>) aus_CSP.Cities.clone();
		if (assignment.size() == aus_CSP.var_num) {
			return assignment;
		}
		City var = shadow_copy.remove();
		for (Character i : var.Domain) {
			var.assignment = i;
			if(aus_CSP.isConsistant(var, assignment)) {
				assignment.add(var);
				LinkedList<City> temp = aus_CSP.Propagate(assignment);
				if(temp != null) {
					//temp is null when the propagation fail
					assignment.addAll(temp);
					LinkedList<City> result = Backtrack(assignment, aus_CSP);
					if (result != null) {
						return result;
					}
				}
			}
			var.Domain.remove(i);
		}
		return null;
	}
	
	public boolean aus_revise(AustraliaCSP aus_CSP, City i, City j) {
		boolean changed = false;
		  
		Aus_Constraint C = new Aus_Constraint(i, i);
		  
		for(Character vi : i.Domain) {
			i.assignment = vi;
			boolean ok = false;
			for(Character vj : j.Domain) {
				j.assignment = vj;
				if(C.check()) {
					ok = true;
				}
			}
			if(!ok) {
				i.Domain.remove(vi);
				changed = true;
			}
		}
		  
		return changed;
	}

	public boolean aus_AC3(AustraliaCSP aus_CSP) {
		 LinkedList<Aus_Constraint> newList = (LinkedList<Aus_Constraint>) aus_CSP.Constraint.clone();
		 
		 while(!newList.isEmpty()) {
			 Aus_Constraint ijSet = newList.poll();
			 City i = ijSet.c1;
			 City j = ijSet.c2;
			 if(aus_revise(aus_CSP, i, j)) {
				 if(i.Domain.isEmpty()) {
					 return false;
				 }
				 for(City k : i.neighbors) {
					 newList.add(new Aus_Constraint(k, i));
				 }
			 }
		  }
		  aus_CSP.Constraint = (LinkedList<Aus_Constraint>) newList;
		  return true;
	}

	
	NQueenCSP NQ_Solver(NQueenCSP nQueen_CSP) {
		
		
		/**
		 * To do
		 * */
		
		return nQueen_CSP;
	}
	
	SchedulingCSP schedul_Solver(SchedulingCSP schedul_CSP) {
		
		/**
		 * To do
		 * */
		
		return schedul_CSP;
	}
	
}
