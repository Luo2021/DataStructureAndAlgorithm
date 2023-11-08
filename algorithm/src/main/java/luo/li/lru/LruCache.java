package luo.li.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU算法
 * @Author liluo
 * @create 2023/11/8 14:13
 */
public class LruCache<K,V> {

    /**
     * node节点
     * @param <K>
     * @param <V>
     */
    static class Node<K,V> {
        Node<K,V> prev;
        Node<K,V> next;
        K key;
        V value;

        public Node() {}

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 双向链表
     * @param <K>
     * @param <V>
     */
    static class DoubleLinkedList<K,V> {
        Node<K,V> head;
        Node<K,V> tail;

        public DoubleLinkedList() {
            //添加头尾哨兵节点
            head = tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        //头部添加
        public void addFirst(Node<K,V> node) {
            Node<K,V> oldHead = head.next;
            head.next = node;
            node.prev = head;
            node.next = oldHead;
            oldHead.prev = node;
        }

        //已知节点删除
        public void remove(Node<K,V> node) {
            Node<K,V> prev = node.prev;
            Node<K,V> next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        //尾部删除
        public Node<K,V> removeLast() {
            Node<K,V> last = tail.prev;
            remove(last);
            return last;
        }
    }

    /**
     * 最大容量
     */
    private int capacity;
    /**
     * HashMap
     */
    private Map<K, Node<K,V>> map = new HashMap<>();
    /**
     * 双向链表
     */
    private DoubleLinkedList<K,V> list = new DoubleLinkedList();

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * get操作
     * @param key
     * @return
     */
    public V get(K key) {
        if(!map.containsKey(key)) {
            return null;
        }
        Node<K,V> node = map.get(key);
        list.remove(node);
        list.addFirst(node);
        return node.value;
    }

    /**
     * put操作
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        //存在则更新
        if(map.containsKey(key)) {
            Node<K,V> node = map.get(key);
            node.value = value;
            list.remove(node);
            list.addFirst(node);
            return;
        }
        //新增
        Node<K,V> node = new Node(key, value);
        map.put(key,node);
        list.addFirst(node);
        if(map.size() > capacity) {
            Node<K,V> removed = list.removeLast();
            map.remove(removed.key);
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        LruCache<Integer, Integer> lruCache = new LruCache<>(4);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.put(5,5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
