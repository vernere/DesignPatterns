/**
 * Interface for building computers following the Builder design pattern.
 * Defines the necessary steps for creating different variations of a Computer object.
 * Implementing classes should provide specific implementations for each building step.
 * 
 * <p>The builder pattern separates the construction of a complex object from its
 * representation, allowing the same construction process to create different representations.</p>
 * 
 * @see Computer
 */
public interface ComputerBuilder {

    public void buildCpu();

    public void setRamSize();

    public void buildHdd();

    public void buildGpu();

    public void buildOs();

    public Computer returnComputer();

}
