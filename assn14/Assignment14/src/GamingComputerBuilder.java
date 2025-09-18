import java.util.Scanner;

/**
 * This class is responsible for building a gaming computer configuration.
 * It implements the ComputerBuilder interface and guides the user through
 * selecting various computer components.
 */
public class GamingComputerBuilder implements ComputerBuilder {

    public Computer computer = new Computer();
    private Scanner scanner;

    /**
     * Constructor that initializes the builder with a scanner for user input
     * @param scanner Scanner object to read user choices
     */
    public GamingComputerBuilder(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Prompts the user to select a CPU for the gaming computer
     */
    @Override
    public void buildCpu() {
        System.out.println("Cpu ? : (1. i9-14900k 2. i5-5500 3. i4-3400)");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                computer.setCpu("Intel i9-14900k");
                break;
            case "2":
                computer.setCpu("Intel i5-5500");
                break;
            case "3":
                computer.setCpu("Intel i4-3400");
                break;
        }
    }

    /**
     * Prompts the user to select a hard drive for the gaming computer
     */
    @Override
    public void buildHdd() {
        System.out.println("Hard drive ? : (1. 1024 GB NVME m.2 SSD 2. 512 GB SSD 3. 2 TB HDD)");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                computer.setHdd("1024 GB NVME m.2 SSD");
                break;
            case "2":
                computer.setHdd("512 GB SSD");
                break;
            case "3":
                computer.setHdd("2 TB HDD");
                break;
        }
    }

    /**
     * Prompts the user to select a GPU for the gaming computer
     */
    @Override
    public void buildGpu() {
        System.out.println("GPU ? : (1. NVIDIA RTX 4090 2. NVIDIA RTX 4080 3. AMD RX 7900 XT)");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                computer.setGpu("NVIDIA RTX 4090");
                break;
            case "2":
                computer.setGpu("NVIDIA RTX 4080");
                break;
            case "3":
                computer.setGpu("AMD RX 7900 XT");
                break;
        }
    }

    /**
     * Prompts the user to select an operating system for the gaming computer
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
     * Prompts the user to select RAM size for the gaming computer
     */
    @Override
    public void setRamSize() {
        System.out.println("RAM Size ? : (1. 32 GB 2. 16 GB 3. 64 GB)");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                computer.setRamSize(32);
                break;
            case "2":
                computer.setRamSize(16);
                break;
            case "3":
                computer.setRamSize(64);
                break;
        }
    }

    /**
     * Returns the configured computer object
     * @return The fully configured Computer object
     */
    @Override
    public Computer returnComputer() {
        return computer;
    }
}
