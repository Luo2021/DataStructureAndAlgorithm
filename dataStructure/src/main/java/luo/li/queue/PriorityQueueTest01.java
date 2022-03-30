package luo.li.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 求一个数组中前K小或者前K大
 * @author luoli
 * @date 2022/3/30 9:56
 */
public class PriorityQueueTest01 {
    public static void main(String[] args) {
        int[]arr = {0,4,3,2,1,5,9,7,10};
        int k = 3;
        int resMin[] = new int[k];
        Queue<Integer> queueMin = getMinK(arr,k);
        for(int i=0;i<k;i++){
            resMin[i] = queueMin.poll();
        }
        System.out.println(Arrays.toString(resMin));

        int resMax[] = new int[k];
        Queue<Integer> queueMax = getMaxK(arr,k);
        for(int i=0;i<k;i++){
            resMax[i] = queueMax.poll();
        }
        System.out.println(Arrays.toString(resMax));
    }

    //默认小顶堆,求K小，就构造大顶堆
    private static Queue getMinK(int[]arr,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<arr.length;i++) {
            if(queue.size() < k) {
                queue.offer(arr[i]);
            }else{
                int minQueue = queue.peek();
                if(minQueue>arr[i]){
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        return queue;
    }

    //求K大就构造小顶堆
    private static Queue getMaxK(int[]arr,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int i=0;i<arr.length;i++) {
            if(queue.size() < k) {
                queue.offer(arr[i]);
            }else if(queue.peek() < arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue;
    }
}
