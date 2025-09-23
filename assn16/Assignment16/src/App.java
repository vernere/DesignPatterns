public class App {
    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

    public static void testVoiceDevice(Device device) {
        System.out.println("Tests with Voice Remote on Smart TV.");

        VoiceRemote voiceRemote = new VoiceRemote((Device) device);

        voiceRemote.voiceCommand("turn on");
        device.printStatus();

        voiceRemote.voiceCommand("volume up");
        device.printStatus();

        voiceRemote.voiceCommand("mute");
        device.printStatus();

        voiceRemote.voiceCommand("channel next");
        device.printStatus();

        voiceRemote.voiceCommand("turn off");
        device.printStatus();

    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== Testing Original Implementation ===");
        testDevice(new Tv());
        testDevice(new Radio());

        System.out.println("\n=== Testing Extended Implementation ===");
        testVoiceDevice(new Tv());
    }
}
