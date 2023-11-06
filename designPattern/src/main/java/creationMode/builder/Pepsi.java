package creationMode.builder;

/**
 * 百事可乐
 * @Author liluo
 * @create 2023/11/3 18:16
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}