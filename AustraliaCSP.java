import java.util.LinkedList;

public class AustraliaCSP {
	
	LinkedList<City> Cities;
	int var_num;
	LinkedList<Aus_Constraint> Constraint;
	int con_num;
	
	
	public AustraliaCSP() {
		//Variables
		this.Cities = new LinkedList<City>();
		this.var_num = 0;
		//Constraint
		this.Constraint = new LinkedList<Aus_Constraint>();
		this.con_num = 0;
	}
	
	boolean add_City(City c) {
		this.Cities.add(c);
		this.var_num++;
		return true;
	}
	
	boolean add_Constraint(City c1, City c2) {
		this.Constraint.add(new Aus_Constraint(c1, c2));
		return true;
	}
	
	public boolean isConsistant(City new_c, LinkedList<City> assignments) {
		
		/**given a new city-assignment and current assignment, 
		 * test weather this new assignment is okay
		 */
		boolean isConsistant = true;
		for(Aus_Constraint i : this.Constraint) {
			if(i.c1 == new_c || i.c2 == new_c) {
				for (City old_c : assignments) {
					if(i.c1 == old_c || i.c2 == old_c) {
						Aus_Constraint temp = new Aus_Constraint(new_c, old_c);
						isConsistant = temp.check();
					}
				}
			}
		}
		return isConsistant;
	}
	
	public LinkedList<City> Propagate(LinkedList<City> assignments){
		
		/**Given a assignments
		 * propagate them as much as possible
		 * */
		return null;
		
	}

	
	

}

class City {
	
	public String name;
	LinkedList<Character> Domain;
	int count;
	Character assignment;
	LinkedList<City> neighbors;
	
	public City(String name) {
		this.name = name;
		//Initialize Domain
		this.Domain = new LinkedList<Character>();
		Domain.add('R');
		Domain.add('Y');
		Domain.add('B');
		Domain.add('G');
		this.count = 4;
		this.assignment = null;
	}	
}


class Aus_Constraint {
	
	City c1;
	City c2;
	
	public Aus_Constraint(City c1, City c2) {
		this.c1 = c1;
		this.c2 = c2;
		c1.neighbors.add(c2);
		c2.neighbors.add(c1);

	}
	
	boolean check() {
		if(this.c1.assignment == this.c2.assignment)
			return false;
		return true;
	}
	
	
}