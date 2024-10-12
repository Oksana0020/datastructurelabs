package package1;

public class Fun {
    public void haveFun() {
        int n = 100;
        System.out.println("Having fun! "+n);
        MoreFun moreFun = new MoreFun();
        moreFun.haveMoreFun();
        moreFun.haveEvenMoreFun(); // New method call
        System.out.println("Finishing fun "+n);
    }

    public void haveEvenMoreFunWithParameter(int n) {
        System.out.println("Having even more fun with parameter! "+n);
        MoreFun moreFun = new MoreFun();
        moreFun.haveMoreFunWithParameter(n);
    }
}
