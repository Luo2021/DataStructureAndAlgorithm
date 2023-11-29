package luo.li.LFU算法;

import java.util.HashMap;
import java.util.Map;

/** LFU算法
 * @Author liluo
 * @create 2023/11/8 15:06
 */
public class LfuCache<K,V> {

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
        int freq = 1;

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
        int size;

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
            size++;
        }

        //已知节点删除
        public void remove(Node<K,V> node) {
            Node<K,V> prev = node.prev;
            Node<K,V> next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        //尾部删除
        public Node<K,V> removeLast() {
            Node<K,V> last = tail.prev;
            remove(last);
            return last;
        }

        //判断链表是否为空
        public boolean isEmpty() {
            return size == 0;
        }

    }

    /**
     * 最大容量
     */
    private int capacity;
    /**
     * HashMap
     */
    private Map<K, Node<K,V>> kvMap = new HashMap<>();
    /**
     * HashMap
     */
    private Map<Integer, DoubleLinkedList<K,V>> freqMap = new HashMap<>();
    /**
     * 双向链表
     */
    private DoubleLinkedList<K,V> list = new DoubleLinkedList();
    /**
     * 最小频度
     */
    private int minFreq = 1;

    public LfuCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * get操作
     * @param key
     * @return
     */
    public V get(K key) {
        if(!kvMap.containsKey(key)) {
            return null;
        }
        Node<K,V> node = kvMap.get(key);
        freqMap.get(node.freq).remove(node);
        if(freqMap.get(node.freq).isEmpty() && node.freq == minFreq) {
            minFreq++;
        }
        node.freq++;
        DoubleLinkedList<K,V> list = freqMap.get(node.freq);
        if(list == null) {
            list = new DoubleLinkedList();
            freqMap.put(node.freq, list);
        }
        list.addFirst(node);
        return node.value;
    }

    /**
     * put操作
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        //更新
        if(kvMap.containsKey(key)) {
            Node<K,V> node = kvMap.get(key);
            //删除原来频道链表上的node
            DoubleLinkedList<K, V> list = freqMap.get(node.freq);
            list.remove(node);
            //如果当前节点是频度链表最后一个节点并且该节点的频度是最小频度，则更新最小频度
            if(list.isEmpty() && node.freq == minFreq) {
                minFreq++;
            }
            //节点频度加一
            node.freq++;
            //如果该频度下链表为空则new一个新链表放在改频度下
            freqMap.computeIfAbsent(node.freq, k -> new DoubleLinkedList<>()).addFirst(node);
            node.value = value;
            return;
        }
        //新增
        if(kvMap.size() == capacity) {
           Node node = freqMap.get(minFreq).removeLast();
           kvMap.remove(node.key);
        }
        Node node = new Node(key, value);
        kvMap.put(key, node);
        freqMap.computeIfAbsent(1, k -> new DoubleLinkedList<>()).addFirst(node);
        minFreq = 1;
    }

}
