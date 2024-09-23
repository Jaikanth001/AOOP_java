package musicstreaming;

public class OnlineStreamAdapter implements MusicPlayer {
    private final MusicSource musicSource;

    public OnlineStreamAdapter(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    public void play() {
        musicSource.playMusic();
    }
}
