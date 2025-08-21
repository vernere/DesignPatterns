/**
 * The OrganizationComponent interface defines the common operations for
 * components
 * in an organizational structure, such as employees or departments. It supports
 * the Composite design pattern, allowing both individual objects and
 * compositions
 * of objects to be treated uniformly.
 *
 * <p>
 * Implementations of this interface can represent either leaf nodes (e.g.,
 * individual employees)
 * or composite nodes (e.g., departments containing employees or other
 * departments).
 * </p>
 *
 * Methods:
 * <ul>
 * <li>{@code add(OrganizationComponent component)}: Adds a child component to
 * this component.</li>
 * <li>{@code remove(OrganizationComponent component)}: Removes a child
 * component from this component.</li>
 * <li>{@code getSalary()}: Returns the total salary associated with this
 * component.</li>
 * <li>{@code toXML()}: Serializes this component and its children to an XML
 * representation.</li>
 * </ul>
 */
public interface OrganizationComponent {

    public void add(OrganizationComponent component);

    public void remove(OrganizationComponent component);

    public double getSalary();

    public String toXML();
}
