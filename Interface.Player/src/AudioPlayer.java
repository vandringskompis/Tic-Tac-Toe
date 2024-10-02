public class AudioPlayer implements  Player{
    @Override
    public void play() {
        System.out.println("Audioplayer plays");
    }

    @Override
    public void stop() {
        System.out.println("Audioplayer stops");

    }

    @Override
    public void pause() {
        System.out.println("Audioplayer pauses");

    }
}
