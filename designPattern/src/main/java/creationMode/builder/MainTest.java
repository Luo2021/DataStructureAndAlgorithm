package creationMode.builder;

/**
 * @Author liluo
 * @create 2023/11/3 18:14
 */
public class MainTest {

    public static void main(String[] args) {

        Meal vegMeal = MealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = MealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}
