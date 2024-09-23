package musicstreaming;

public class Main {
    public static void main(String[] args) {
        MusicSource localFileSource = new LocalFileSource();
        MusicPlayer localPlayer = new Player(localFileSource) {};

        MusicSource onlineStreamSource = new OnlineStreamSource();
        MusicPlayer onlinePlayer = new Player(onlineStreamSource) {};

        MusicSource radioSource = new RadioSource();
        MusicPlayer radioPlayer = new Player(radioSource) {};

        MusicPlayer enhancedLocalPlayer = new Equalizer(new VolumeControl(localPlayer));
        enhancedLocalPlayer.play();

        MusicPlayer enhancedOnlinePlayer = new VolumeControl(onlinePlayer);
        enhancedOnlinePlayer.play();
        
        radioPlayer.play();
    }
}
