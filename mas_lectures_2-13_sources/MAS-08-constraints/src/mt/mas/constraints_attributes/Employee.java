package mt.mas.constraints_attributes;

/**
 * @author Mariusz
 *
 */
public class Employee {
	private float salary;

	public Employee(float salary) throws Exception {
		setSalary(salary);  // always use setters/getters
	}

	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 * @throws Exception 
	 */
	public void setSalary(float salary) throws Exception {
		// Validate all the constraints
		if(salary < this.salary) {
			throw new Exception(String.format("The salary (%s) cannot be decreased!%d", salary));
		}
		
		if(this.salary != 0 && this.salary * (1d + maxSalaryChangePercentage /100d) < salary) {
			throw new Exception(String.format("The salary (%s => %s) increase cannot be more then %s%%", getSalary(), salary, maxSalaryChangePercentage));
		}

		if(salary < minimumSalary) {
			throw new Exception(String.format("The new salary (%s) has to be at least %s", salary, minimumSalary));
		}
		
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("Employee, salary: %s", getSalary());  // always use setters/getters
	}

	public final static float minimumSalary = 2000;
	public final static float maximumSalary = 5000;
	public final static int maxSalaryChangePercentage = 10;
}
