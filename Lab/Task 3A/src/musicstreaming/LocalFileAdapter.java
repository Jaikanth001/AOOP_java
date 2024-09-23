package musicstreaming;

public class LocalFileAdapter implements MusicPlayer {
    private final MusicSource musicSource;

    public LocalFileAdapter(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    public void play() {
        musicSource.playMusic();
    }
}
