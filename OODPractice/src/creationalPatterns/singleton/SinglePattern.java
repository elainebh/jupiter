package creationalPatterns.singleton;
/*
背景：小成有一个塑料生产厂，但里面只有一个仓库。
目的：想用代码来实现仓库的管理
现有做法： 建立仓库类和工人类
其中，仓库类里的quantity=商品数量；工人类里有搬运方法MoveIn(int i)和MoveOut(int i)。

出现的问题：通过测试发现，每次工人搬运操作都会新建一个仓库，就是货物都不是放在同一仓库，这是怎么回事呢？（看下面代码）

使用了单例模式后，仓库类就只有一个仓库实例了，再也不用担心搬运工人进错仓库了
 */

//仓库类
class StoreHouse {
    //仓库商品数量
    private int quantity = 100;

    ///*
    //Singleton
    //自己在内部实例化
    private static StoreHouse ourInstance  = new StoreHouse();;
    //让外部通过调用getInstance()方法来返回唯一的实例。
    public static StoreHouse getInstance() {
        return ourInstance;
    }

    //封闭构造函数
    private StoreHouse() {
    }
    //Singleton
    //*/

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }


}

//搬货工人类
class Carrier{
    public StoreHouse mStoreHouse;
    public Carrier(StoreHouse storeHouse){
        mStoreHouse = storeHouse;
    }
    //搬货进仓库
    public void MoveIn(int i){
        mStoreHouse.setQuantity(mStoreHouse.getQuantity()+i);
    }
    //搬货出仓库
    public void MoveOut(int i){
        mStoreHouse.setQuantity(mStoreHouse.getQuantity()-i);
    }
}

//工人搬运测试
public class SinglePattern {
    public static void main(String[] args){
        ///*
        // Singleton
        StoreHouse mStoreHouse1 = StoreHouse.getInstance();
        StoreHouse mStoreHouse2 = StoreHouse.getInstance();
        //*/

        //StoreHouse mStoreHouse1 = new StoreHouse();
        //StoreHouse mStoreHouse2 = new StoreHouse();
        Carrier Carrier1 = new Carrier(mStoreHouse1);
        Carrier Carrier2 = new Carrier(mStoreHouse2);

        System.out.println("两个是不是同一个？");

        if(mStoreHouse1.equals(mStoreHouse2)){//这里用equals而不是用 == 符号，因为 == 符号只是比较两个对象的地址
            System.out.println("是同一个");
        }else {
            System.out.println("不是同一个");
        }
        //搬运工搬完货物之后出来汇报仓库商品数量
        Carrier1.MoveIn(30);
        System.out.println("仓库商品余量："+Carrier1.mStoreHouse.getQuantity());
        Carrier2.MoveOut(50);
        System.out.println("仓库商品余量："+Carrier2.mStoreHouse.getQuantity());
    }
}


