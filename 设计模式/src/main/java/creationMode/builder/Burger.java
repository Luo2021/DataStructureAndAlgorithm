package creationMode.builder;

/**
 * 汉堡食物
 * @Author liluo
 * @create 2023/11/3 17:50
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    /**
     * 获取价格
     *
     * @return 返回价格
     */
    @Override
    public abstract float price();
}