package musicstreaming;

public abstract class PlayerDecorator implements MusicPlayer {
    protected final MusicPlayer decoratedPlayer;

    public PlayerDecorator(MusicPlayer decoratedPlayer) {
        this.decoratedPlayer = decoratedPlayer;
    }

    public void play() {
        decoratedPlayer.play();
    }
}
