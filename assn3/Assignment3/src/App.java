public class App {
    public static void main(String[] args) throws Exception {
        // Create main department and sales department
        OrganizationComponent mainDepartment = new Department("Main");
        OrganizationComponent sales = new Department("Sales");

        // Create employees with names and salaries
        OrganizationComponent employee1 = new Employee("Joe Jones", 5.50);
        OrganizationComponent employee2 = new Employee("Hannah Mont", 6.50);
        OrganizationComponent employee3 = new Employee("Bob Sale", 7.50);

        // Add employees and sales department to main department
        mainDepartment.add(employee1);
        mainDepartment.add(employee2);
        mainDepartment.add(sales);
        // Add employee to sales department
        sales.add(employee3);

        // Print XML representation of main department
        System.out.println(mainDepartment.toXML());

        // Print XML representation of employee1
        System.out.println(employee1.toXML());

        // Print XML representation of sales department
        System.out.println(sales.toXML());

        // Print total salary of main department
        System.out.println("Total Salary :");
        System.out.println(mainDepartment.getSalary());

        // Remove employee2 from main department
        mainDepartment.remove(employee2);

        // Print XML after removal
        System.out.println(mainDepartment.toXML());

        // Remove sales department from main department
        mainDepartment.remove(sales);

        // Print XML after removal
        System.out.println(mainDepartment.toXML());
    }
}
