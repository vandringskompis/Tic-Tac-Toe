//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Player audioplayer = new AudioPlayer();
        Player videoplayer = new VideoPlayer();

        audioplayer.play();

        System.out.println("Woohoo vilken musik!!");
        audioplayer.pause();

        System.out.println("NEEEEEJJJJ!!! Sätt på igen!");
        audioplayer.play();
        System.out.println("Wohhooo");
        audioplayer.stop();
        System.out.println("NEEEEJJJJ");

        videoplayer.play();
        videoplayer.stop();
        videoplayer.play();
        videoplayer.pause();


    }
}