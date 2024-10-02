public class VideoPlayer implements Player{
    @Override
    public void play() {
        System.out.println("Videoplayer plays");
    }

    @Override
    public void stop() {
        System.out.println("Videoplayer stops");

    }

    @Override
    public void pause() {
        System.out.println("Videoplayer pauses");

    }
}
