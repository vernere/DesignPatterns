/**
 * Represents a computer with its hardware and software specifications.
 * This class stores information about CPU, RAM, hard drive, GPU, and operating system.
 */
public class Computer {

    // Fields to store computer specifications
    public String cpu;     // Stores the CPU model/type
    public int ramSize;    // Stores RAM size in GB
    public String hdd;     // Stores hard drive details
    public String gpu;     // Stores graphics card information
    public String os;      // Stores operating system information

    // Getters - methods to access private fields
    /**
     * @return the CPU specification
     */
    public String getCpu() {
        return cpu;
    }

    /**
     * @return the RAM size in GB
     */
    public int getRamSize() {
        return ramSize;
    }

    /**
     * @return the hard drive specification
     */
    public String getHdd() {
        return hdd;
    }

    /**
     * @return the GPU specification
     */
    public String getGpu() {
        return gpu;
    }

    /**
     * @return the operating system specification
     */
    public String getOs() {
        return os;
    }

    // Setters - methods to modify private fields
    /**
     * Sets the CPU specification
     * @param cpu the CPU model/type to set
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * Sets the RAM size
     * @param ramSize the RAM size in GB to set
     */
    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    /**
     * Sets the hard drive specification
     * @param hdd the hard drive details to set
     */
    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    /**
     * Sets the GPU specification
     * @param gpu the GPU model/type to set
     */
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    /**
     * Sets the operating system specification
     * @param os the operating system to set
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * Prints the complete computer configuration to console
     * Displays CPU, RAM, HDD, GPU and OS details
     */
    public void printConfiguration() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ramSize + " GB");
        System.out.println("HDD: " + hdd);
        System.out.println("GPU: " + gpu);
        System.out.println("OS: " + os);
    }
}
