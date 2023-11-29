package creationMode.builder;

/**
 * 食物条目接口
 * @Author liluo
 * @create 2023/11/3 17:47
 */
public interface Item {

    /**
     * 获取食物名称
     *
     * @return 返回食物名称
     */
    String name();

    /**
     * 打包方式
     *
     * @return 包装接口
     */
    Packing packing();

    /**
     * 食物价格
     *
     * @return 返回食物价格
     */
    float price();

}
