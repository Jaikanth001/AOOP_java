package musicstreaming;

public class Equalizer extends PlayerDecorator {
    public Equalizer(MusicPlayer decoratedPlayer) {
        super(decoratedPlayer);
    }

    public void play() {
        decoratedPlayer.play();
        System.out.println("Equalizer settings applied.");
    }
}
