package luo.li.array;

/**
 * 数组
 * @author luoli
 * @date 2021/9/29 21:51
 */
public class Array {
    private int[] data;
    private int size;

    //构造函数，传入数组容量是capacity的Array
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    //获取数组中元素个数
    public int getSize(){
        return size;
    }

    //获取数组容量
    public int getCapacity(){
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向数组头部添加元素
    public void addFirst(int e){
        add(0,e);
    }

    //向数组末尾中添加元素
    public void addLast(int e){
        add(size,e);
    }

    //向数组指定位置插入元素
    public void add(int index, int e){
        if(size == data.length){
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        for(int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
}
