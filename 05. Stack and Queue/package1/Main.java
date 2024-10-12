package package1;

public class Main {

    public static void main(String[] args) {
        int n = 70;
        Fun fun = new Fun();
        fun.haveFun();
        fun.haveEvenMoreFunWithParameter(n);
        System.out.println("Finishing main "+n);
    }
}

//add new methods to the Fun and MoreFun classes
// to show more complex interactions between the classes