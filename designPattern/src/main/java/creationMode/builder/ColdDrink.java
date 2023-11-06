package creationMode.builder;

/**
 * 冷饮食物
 * @Author liluo
 * @create 2023/11/3 18:08
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

    /**
     * 获取价格
     *
     * @return 返回价格
     */
    @Override
    public abstract float price();

}
