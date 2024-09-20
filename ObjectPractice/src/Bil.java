public class Bil {

   private String märke;
    int årsModell;
    String färg;


    public Bil(String märke, int årsModell, String färg) { //kontruktorn
        this.märke = märke;
        this.årsModell = årsModell;
        this.färg = färg;

    }

    public Bil(String märke) {
        this.märke = märke;
    }

    public String getMärke() {
        return märke;
    }

    public void setMärke(String märke) {
        this.märke = märke;
    }

    public void startaMotor(){
        System.out.println("Motorn är igång");
    }
}


