package package1;

public class MoreFun {
    public void haveMoreFun() {
        System.out.println("Having more fun!");
        int number = 10;
        System.out.println("Finishing more fun"+number);
    }

    public void haveEvenMoreFun() {
        System.out.println("Having even more fun!");
        int number = 20;
        System.out.println("Finishing even more fun"+number);
    }

    public void haveMoreFunWithParameter(int n) {
        System.out.println("Having more fun with parameter! "+n);
        int number = n * 2;
        System.out.println("Finishing more fun with parameter"+number);
    }
}