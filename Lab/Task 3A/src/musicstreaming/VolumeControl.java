package musicstreaming;

public class VolumeControl extends PlayerDecorator {
    public VolumeControl(MusicPlayer decoratedPlayer) {
        super(decoratedPlayer);
    }

    public void play() {
        decoratedPlayer.play();
        System.out.println("Volume control adjusted.");
    }
}
