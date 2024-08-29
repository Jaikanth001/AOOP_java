package musicstreaming;

public class Main {
    public static void main(String[] args) {
        MusicSource localFile = new MusicSource() {
            public void playMusic() {
                System.out.println("Playing local file.");
            }
        };
        MusicPlayer localPlayer = new LocalFileAdapter(localFile);

        MusicSource onlineStream = new MusicSource() {
            public void playMusic() {
                System.out.println("Streaming online music.");
            }
        };
        MusicPlayer onlinePlayer = new OnlineStreamAdapter(onlineStream);

        MusicSource radio = new MusicSource() {
            public void playMusic() {
                System.out.println("Playing radio station.");
            }
        };
        MusicPlayer radioPlayer = new RadioAdapter(radio);

        MusicPlayer enhancedPlayer = new Equalizer(new VolumeControl(localPlayer));
        enhancedPlayer.play();

        MusicPlayer onlineWithVolume = new VolumeControl(onlinePlayer);
        onlineWithVolume.play();
        
        radioPlayer.play();
    }
}
