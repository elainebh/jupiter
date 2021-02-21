package creationalPatterns.singleton;

public class Singleton {
    //1. 创建私有变量 ourInstance（用以记录 Singleton 的唯一实例）
    //2. 内部进行实例化
    private static Singleton ourInstance  = new  Singleton();

    //3. 把类的构造方法私有化，不让外部调用构造方法实例化
    private Singleton() {
    }
    //4. 定义公有方法提供该类的全局唯一访问点
    //5. 外部通过调用getInstance()方法来返回唯一的实例
    public static Singleton newInstance() {
        return ourInstance;
    }
}