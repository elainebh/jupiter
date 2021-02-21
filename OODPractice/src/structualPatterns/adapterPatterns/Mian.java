package structualPatterns.adapterPatterns;

public class Mian {
    public static void main(String[] args) {
        Target adapter110v = new Adapter110v();
        adapter110v.convent110vTo220v();
    }
}
