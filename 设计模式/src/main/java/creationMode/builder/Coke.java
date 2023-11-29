package creationMode.builder;

/**
 * 可口可乐
 * @Author liluo
 * @create 2023/11/3 18:16
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}