package creationMode.builder;

/**
 * 套餐建造
 * @Author liluo
 * @create 2023/11/3 18:13
 */
public class MealBuilder {

    /**
     * 素食汉堡套餐
     *
     * @return 返回封装的套餐
     */
    public static Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    /**
     * 鸡肉汉堡套餐
     *
     * @return 返回封装的套餐
     */
    public static Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}
