import java.util.HashSet;

public class SchedulingCSP {
	
	 HashSet<Task> Tasks;
	 int var_num;
	 HashSet<Scheduling_Constraint> Constraint;
	 int con_num;
	
	 public SchedulingCSP() {
		  // Variables
		  this.Tasks = new HashSet<Task>();
		  this.var_num = 0;
		  // Constraint
		  this.Constraint = new HashSet<Scheduling_Constraint>();
		  this.con_num = 0;
		
	 }
	
	 boolean add_Task(Task t) {
		  this.Tasks.add(t);
		  this.var_num++;
		  return true;
	 }
	
	 boolean add_Constraint(Task t1, Task t2, boolean order) {
		  this.Constraint.add(new Scheduling_Constraint(t1, t2, order));
		  return true;
	 }

}

class Task {

	 String name;
	 int duration;
	 HashSet<Integer> Domain;
	 int count;
	 int assignment;
	
	 public Task(String name, int duration) {
		  this.name = name;
		  this.duration = duration;
		  //Initialize Domain
		  this.Domain = new HashSet<Integer>();
		  for (int i = 0; i <= 27; i++) {
		   Domain.add(i);
		  }
		
		  this.count = 28;
		  this.assignment = -1;
		 }
}


class Scheduling_Constraint {
	
	 Task t1;
	 Task t2;
	 boolean order;
	
	 public Scheduling_Constraint(Task t1, Task t2, boolean order) {
		  this.t1 = t1;
		  this.t2 = t2;
		  this.order = order;
	 }
	
	 boolean check() {
		 if (this.order) {
			  if (this.t1.assignment < this.t2.assignment) {
				  return true;
			  }
			  return false;
		 } else {
			  if (this.t1.assignment > this.t2.assignment) {
				   return true;
			  }
			  return false;
		 }
	 }
}