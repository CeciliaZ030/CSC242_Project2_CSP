import java.util.LinkedList;

public class Solver {
	
	String CSP_instantce;
	
	public Solver(String instance) {
		this.CSP_instantce = instance;
	}
	
	
	LinkedList<City> aus_Solver(AustraliaCSP aus_CSP) {
		LinkedList<City> Assignment =  new LinkedList<City>();
		LinkedList<City> shadow_copy = (LinkedList<City>) aus_CSP.Cities.clone();
		return Backtrack(Assignment, aus_CSP, shadow_copy);
	}
	
	LinkedList<City> Backtrack(LinkedList<City> Assignment, AustraliaCSP aus_CSP, LinkedList<City> shadow_copy) {
		if (Assignment.size() == aus_CSP.var_num) {
			return Assignment;
		}
		City var = shadow_copy.remove();
		
		while(!var.Domain.isEmpty()) {
			var.assignment = var.Domain.remove();
			if(aus_CSP.isConsistant(var, Assignment)) {
				Assignment.add(var);
				LinkedList<City> result = Backtrack(Assignment, aus_CSP, shadow_copy);
				if (result != null) {
					return result;
				}
			}
			var.Domain.remove(var.assignment);
		}
		
		return null;
	}
	
	
	void print(LinkedList<City> result) {
		for (City c : result) {
			System.out.println("shadow copy: " +c.name);
		}
		System.out.println();
	}
	
	void print2(LinkedList<City> result) {
		System.out.println("Assigned");

		for (City c : result) {
			System.out.println(c.name + ": " +c.assignment);
		}
		System.out.println();
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
