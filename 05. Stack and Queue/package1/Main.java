package package1;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        int n = 55;
        Fun fun = new Fun();
        fun.haveFun();
        System.out.println("Finishing main "+n);
    }
}
//first main, then havefun calls, then have morefun. There is nothing after so goes back to havefun
