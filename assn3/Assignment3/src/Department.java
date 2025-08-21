// Department.java
// Represents a department in an organization, which can contain other organization components.

/**
 * Represents a department in an organization, which can contain child components
 * such as other departments or employees. Implements the OrganizationComponent interface
 * to support composite operations like adding, removing, calculating total salary,
 * and converting to XML format.
 */
public class Department implements OrganizationComponent {
    public String name; // Name of the department
    public OrganizationComponent[] components; // Child components (departments or employees)

    // Constructor to initialize department name
    public Department(String name) {
        this.name = name;
    }

    // Adds a child component to the department
    @Override
    public void add(OrganizationComponent component) {
        if (components == null) {
            // If no components exist, create a new array with the component
            components = new OrganizationComponent[] { component };
        } else {
            // Otherwise, create a new array with one extra slot and copy existing
            // components
            OrganizationComponent[] newComponents = new OrganizationComponent[components.length + 1];
            System.arraycopy(components, 0, newComponents, 0, components.length);
            newComponents[components.length] = component;
            components = newComponents;
        }
    }

    // Removes a child component from the department
    @Override
    public void remove(OrganizationComponent component) {
        if (components == null || components.length == 0) {
            return; // Nothing to remove
        }
        int index = -1;
        // Find the index of the component to remove
        for (int i = 0; i < components.length; i++) {
            if (components[i].equals(component)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return; // Component not found
        }
        // Create a new array without the removed component
        OrganizationComponent[] newComponents = new OrganizationComponent[components.length - 1];
        System.arraycopy(components, 0, newComponents, 0, index);
        System.arraycopy(components, index + 1, newComponents, index, components.length - index - 1);
        components = newComponents.length == 0 ? null : newComponents;
    }

    // Calculates the total salary of all child components
    @Override
    public double getSalary() {
        double total = 0;
        if (components != null) {
            for (OrganizationComponent organizationComponent : components) {
                total += organizationComponent.getSalary();
            }
        }
        return total;
    }

    // Converts the department and its child components to XML format with
    // indentation
    @Override
    public String toXML() {
        return toXMLHelper(0);
    }

    // Helper method to handle indentation recursively
    private String toXMLHelper(int indentLevel) {
        String indent = "    ".repeat(indentLevel);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s<Department name=\"%s\">%n", indent, name));
        if (components != null) {
            for (OrganizationComponent component : components) {
                // If component is Department, call its helper, else call toXML with indentation
                if (component instanceof Department) {
                    sb.append(((Department) component).toXMLHelper(indentLevel + 1));
                } else {
                    String childIndent = "    ".repeat(indentLevel + 1);
                    String xml = component.toXML();
                    // Indent each line of the child XML
                    for (String line : xml.split("\n")) {
                        sb.append(childIndent).append(line).append(System.lineSeparator());
                    }
                }
            }
        }
        sb.append(String.format("%s</Department>%n", indent));
        return sb.toString();
    }
}
