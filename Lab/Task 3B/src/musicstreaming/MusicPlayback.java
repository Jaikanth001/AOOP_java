package musicstreaming;

public abstract class MusicPlayback {
    protected MusicSource musicSource;

    public MusicPlayback(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    public abstract void play();
}
