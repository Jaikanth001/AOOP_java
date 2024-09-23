package musicstreaming;

public abstract class Player implements MusicPlayer {
    protected final MusicSource musicSource;

    public Player(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    public void play() {
        musicSource.playMusic();
    }
}
