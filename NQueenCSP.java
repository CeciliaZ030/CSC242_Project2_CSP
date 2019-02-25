import java.util.HashSet;

public class NQueenCSP {
	
	HashSet<Queen> Queens;
	int var_num;
	Queen_Constraint Constraint;
	int con_num;
	
	public NQueenCSP(int n) {
		//Variables
		this.Queens = new HashSet<Queen>();
		this.var_num = n;
		//Constraint
		this.Constraint = new Queen_Constraint();
	}
	

}

class Queen{
	
	String name;
	HashSet<int[]> Domain;
	int assignment_i;
	int assignment_j;
	
	
	public Queen(String name, int i, int j) {
		this.name = name;
		this.assignment_i= i;
		this.assignment_j = j;
		//Initialize Domain
		for(i = 0; i < 9; i++) {
			for(j = 0; j < 9; j++) {
				int[] new_value = {i,j};
				this.Domain.add(new_value);
			}
		}
	}
}

class Queen_Constraint{
	
	boolean check (Queen Q1, Queen Q2) {
		if(Q1.assignment_i != Q2.assignment_i && Q1.assignment_j != Q2.assignment_j
				&& (Q1.assignment_i-Q1.assignment_j)!=(Q2.assignment_i-Q2.assignment_j)
				&& (Q1.assignment_i+Q1.assignment_j)!=(Q2.assignment_i+Q2.assignment_j)) 
		{
			return true;
		}
		
		return false;
	}
	
}