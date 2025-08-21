/**
 * Represents an individual employee in the organization.
 * Implements the OrganizationComponent interface.
 */
public class Employee implements OrganizationComponent {
    // Employee's name
    public String name;
    // Employee's salary
    private Double salary;

    /**
     * Constructs an Employee with the given name and salary.
     * 
     * @param name   Employee's name (must not be null or empty)
     * @param salary Employee's salary (must be non-null and non-negative)
     * @throws IllegalArgumentException if name or salary is invalid
     */
    public Employee(String name, Double salary) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (salary == null || salary < 0) {
            throw new IllegalArgumentException("Salary must be non-null and non-negative.");
        }
        this.name = name;
        this.salary = salary;
    }

    /**
     * Employees cannot have child components.
     * 
     * @throws UnsupportedOperationException always
     */
    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    /**
     * Employees cannot have child components.
     * 
     * @throws UnsupportedOperationException always
     */
    @Override
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    /**
     * Returns the salary of the employee.
     * 
     * @return salary
     */
    @Override
    public double getSalary() {
        return salary;
    }

    /**
     * Returns an XML representation of the employee.
     * 
     * @return XML string
     */
    @Override
    public String toXML() {
        return String.format("<Employee name=\"%s\" salary=\"%.2f\" />", name, salary);
    }
}
