import java.util.ArrayList;
import java.util.Scanner;

public class Players {
   private String name;
   private String markers;

    public Players(String name, String markers) {
        this.name = name;
        this.markers = markers;
    }

    public Players() {
    }

    public String getName() {
        return name;
    }

    public String getMarkers() {
        return markers;
    }



}

