package creationMode.builder;

/**
 * 素食汉堡
 * @Author liluo
 * @create 2023/11/3 18:14
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}