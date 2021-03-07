package structualPatterns.adapterPatterns;
// adapter
// class adapter
public class Adapter110v extends OriginOutput implements Target{
    @Override
    public void convent110vTo220v() {
        this.Output110v();
    }
}



