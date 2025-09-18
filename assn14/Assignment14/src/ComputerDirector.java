/**
 * ComputerDirector is responsible for executing the building steps in the correct order.
 * It works with any builder that implements the ComputerBuilder interface.
 */
public class ComputerDirector {
    // The builder instance that will be used to construct the computer
    public ComputerBuilder builder;

    /**
     * Constructor that accepts a ComputerBuilder implementation
     * @param builder The builder to use for constructing computers
     */
    public ComputerDirector(ComputerBuilder builder){
        this.builder = builder;
    }

    /**
     * Builds a computer by calling the builder methods in sequence
     * @return The fully constructed Computer object
     */
    public Computer buildComputer(){
        // Execute build steps in the correct order
        builder.buildCpu();
        builder.buildGpu();
        builder.buildHdd();
        builder.buildOs();
        builder.setRamSize();
        
        // Return the completed computer
        return builder.returnComputer();
    }
}
