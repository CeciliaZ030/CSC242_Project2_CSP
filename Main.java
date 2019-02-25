
public class Main {
	
	public static void main (String[] args) {
		
		AustraliaCSP aus = new AustraliaCSP();
		City[] city_Variables = {new City("WA"), new City("NT"), new City("Q"), new City("NSW"), new City("V"), new City("SA"), new City("T")};
		
		for (int i = 0; i < city_Variables.length; i++) {
			aus.add_City(city_Variables[i]);
		}

		aus.add_Constraint(city_Variables[5], city_Variables[0]);
		aus.add_Constraint(city_Variables[5], city_Variables[1]);
		aus.add_Constraint(city_Variables[5], city_Variables[2]);
		aus.add_Constraint(city_Variables[5], city_Variables[3]);
		aus.add_Constraint(city_Variables[5], city_Variables[4]);
		aus.add_Constraint(city_Variables[0], city_Variables[1]);
		aus.add_Constraint(city_Variables[1], city_Variables[2]);
		aus.add_Constraint(city_Variables[2], city_Variables[3]);
		aus.add_Constraint(city_Variables[3], city_Variables[4]);




	}
}
