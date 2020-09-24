import java.util.List;

public class LinkedListDeque<T> {
    private int size;
    private ListNode sentinel;

    private class ListNode{
        ListNode prev;
        ListNode next;
        T item;
        ListNode(T i, ListNode p, ListNode n){
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque(){
        size = 0;
        sentinel = new ListNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item){
        sentinel.next = new ListNode(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size ++;
    }
    public void addLast(T item){
        sentinel.prev = new ListNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size ++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        ListNode p = sentinel.next;
        while(p != null && p!= sentinel){
            System.out.print(p.item);
            System.out.print(' ');
            p = p.next;
        }
        System.out.println();
    }
    public T removeFirst(){
        if(size == 0){
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
        return item;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        T item = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return item;
    }
    public T get(int index){
        if(index >= size){
            return null;
        }
        ListNode dummy = sentinel.next;
        for(int i =0; i< index; i++){
            dummy = dummy.next;
        }
        return dummy.item;
    }
    private T getRecursive(int index, ListNode p){
        if( index == 0){
            return p.item;
        }else{
            return getRecursive(index-1, p.next);
        }
    }
    public T getRecursive(int index){
        if(index> size){
            return null;
        }
        return getRecursive(index, sentinel.next);
    }
}
