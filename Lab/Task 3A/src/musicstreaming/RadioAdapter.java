package musicstreaming;

public class RadioAdapter implements MusicPlayer {
    private final MusicSource musicSource;

    public RadioAdapter(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    public void play() {
        musicSource.playMusic();
    }
}
