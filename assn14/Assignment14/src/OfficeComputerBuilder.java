import java.util.Scanner;

/**
 * Office Computer Builder - implements the ComputerBuilder interface
 * Responsible for building computers with office-specific configurations
 * Uses a Builder pattern to construct Computer objects step by step
 */
public class OfficeComputerBuilder implements ComputerBuilder {

    public Computer computer = new Computer();
    private Scanner scanner;

    /**
     * Constructor that takes a scanner for user input
     * @param scanner Scanner object for reading user choices
     */
    public OfficeComputerBuilder(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Builds the CPU component of the computer
     * Presents user with office-appropriate CPU options
     */
    @Override
    public void buildCpu() {
        System.out.println("Cpu ? : (1. Intel i5-12600 2. Intel i3-10100 3. AMD Ryzen 5 5600)");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                computer.setCpu("Intel i5-12600");
                break;
            case "2":
                computer.setCpu("Intel i3-10100");
                break;
            case "3":
                computer.setCpu("AMD Ryzen 5 5600");
                break;
        }
    }

    /**
     * Builds the Hard Drive component of the computer
     * Presents user with office-appropriate storage options
     */
    @Override
    public void buildHdd() {
        System.out.println("Hard drive ? : (1. 512 GB SSD 2. 256 GB SSD 3. 1 TB HDD)");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                computer.setHdd("512 GB SSD");
                break;
            case "2":
                computer.setHdd("256 GB SSD");
                break;
            case "3":
                computer.setHdd("1 TB HDD");
                break;
        }
    }

    /**
     * Builds the GPU component of the computer
     * Presents user with office-appropriate graphics options
     */
    @Override
    public void buildGpu() {
        System.out.println("GPU ? : (1. Intel Integrated Graphics 2. AMD Integrated Graphics 3. NVIDIA GT 1030)");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                computer.setGpu("Intel Integrated Graphics");
                break;
            case "2":
                computer.setGpu("AMD Integrated Graphics");
                break;
            case "3":
                computer.setGpu("NVIDIA GT 1030");
                break;
        }
    }

    /**
     * Sets the Operating System for the computer
     * Presents user with office-appropriate OS options
     */
    @Override
    public void buildOs() {
        System.out.println("Operating System ? : (1. Windows 11 2. Windows 10 3. Linux)");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                computer.setOs("Windows 11");
                break;
            case "2":
                computer.setOs("Windows 10");
                break;
            case "3":
                computer.setOs("Linux");
                break;
        }
    }

    /**
     * Sets the RAM size for the computer
     * Presents user with office-appropriate memory options
     */
    @Override
    public void setRamSize() {
        System.out.println("RAM Size ? : (1. 16 GB 2. 8 GB 3. 32 GB)");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                computer.setRamSize(16);
                break;
            case "2":
                computer.setRamSize(8);
                break;
            case "3":
                computer.setRamSize(32);
                break;
        }
    }

    /**
     * Returns the fully constructed computer object
     * @return The completed Computer object
     */
    @Override
    public Computer returnComputer() {
        return computer;
    }
}
