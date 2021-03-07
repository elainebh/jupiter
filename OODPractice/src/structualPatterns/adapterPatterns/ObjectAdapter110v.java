package structualPatterns.adapterPatterns;
// adapter
// object adapter
public class ObjectAdapter110v implements Target {
    // 注意这里的Adapter是将Adapter110V作为一个成员属性，而不是继承它。
    private Adapter110v adapter110v;
    @Override
    public void convent110vTo220v() {
        adapter110v.Output110v();
    }
}
