public class VoiceRemote extends BasicRemote implements SmartRemote {

        public VoiceRemote(Device device) {
        super(device);
    }

    @Override
    public void voiceCommand(String command) {
        System.out.println("Voice Remote: Processing voice command - '" + command + "'");
        
        // Parse and execute voice commands
        String lowerCommand = command.toLowerCase();
        
        if (lowerCommand.contains("turn on") || lowerCommand.contains("power on")) {
            if (!device.isEnabled()) {
                power();
            }
        } else if (lowerCommand.contains("turn off") || lowerCommand.contains("power off")) {
            if (device.isEnabled()) {
                power();
            }
        } else if (lowerCommand.contains("volume up")) {
            volumeUp();
        } else if (lowerCommand.contains("volume down")) {
            volumeDown();
        } else if (lowerCommand.contains("mute")) {
            device.setVolume(0);
        } else if (lowerCommand.contains("channel")) {
            if (lowerCommand.contains("up") || lowerCommand.contains("next")) {
                channelUp();
            } else if (lowerCommand.contains("down") || lowerCommand.contains("previous")) {
                channelDown();
            }
        } else {
            System.out.println("Voice Remote: Command not recognized");
        }
    }

}
