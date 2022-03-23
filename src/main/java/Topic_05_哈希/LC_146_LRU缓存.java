package Topic_05_哈希;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC_146_LRU缓存 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(3, 2);
        lruCache.get(3);
        lruCache.get(2);
        lruCache.put(4, 3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println();
    }
}

class LRUCache {

    Map<Integer, DListNode> map;
    DListNode head;
    int capacity;


    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head = new DListNode();
        head.next = head;
        head.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        DListNode node = map.get(key);
        reset(node);
        return node.val;
    }

    public void put(int key, int value) {
        //如果map中有key，则直接修改，并且修改优先级
        if (map.containsKey(key)){
            DListNode node = map.get(key);
            node.val = value;
            reset(node);
        } else {
            //如果没有，则先判断map容量是否已满，满则先移除
            if (map.size() == this.capacity){
                DListNode tail = head.prev;
                head.prev = tail.prev;
                tail.prev.next = head;
                map.remove(tail.key);
            }
            DListNode node = new DListNode(key, value);
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            map.put(key, node);
        }
    }

    public void reset(DListNode node) {
        //删除node
        node.prev.next = node.next;
        node.next.prev = node.prev;
        //将node放在head后面
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

class DListNode{
    int val;
    int key;
    DListNode prev;
    DListNode next;
    DListNode(){}

    DListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}