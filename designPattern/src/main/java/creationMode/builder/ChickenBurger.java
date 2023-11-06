package creationMode.builder;

/**
 * 鸡肉汉堡
 * @Author liluo
 * @create 2023/11/3 18:15
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}