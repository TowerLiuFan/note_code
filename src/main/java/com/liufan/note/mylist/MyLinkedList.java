package com.liufan.note.mylist;


public class MyLinkedList<E> {

    //链表实际存储元素
    private int size;

    //第一个元素(头结点，为了查询开始)
    private Node first;

    //最后一个元素(尾节点，为了添加开始)
    private Node last;

    public void  add(E e){
        //创建节点
        Node node = new Node();
        //给节点赋值
        node.object = e;
        if(first==null){
            //给第一个元素赋值
            first = node;
            //第一个元素的头和尾都属于自己
        }else{
            //添加第二个或以上元素
            node.prev = last;
            //将上一个元素的next赋值
            last.next = node;
        }
        last = node;
        size++;
    }

    // 链表节点存储元素
    private class Node{
        //存放元素的值
          Object object;
        //上一个节点Node
          Node prev;
        //下一个节点Node
          Node next;
    }

    @SuppressWarnings("unnsed")
    public Object get(int index){
        //检查下标
        checkElementIndex(index);
        Node node = null;
        if(first!=null){
            node = first;  //默认取第0个
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return getNode(index).object;
    }

    public Node getNode(int index){
        //检查下标
        checkElementIndex(index);
        Node node = null;
        if(first!=null){
            node = first;  //默认取第0个
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }


    //删除指定下标元素
    public void remove(int index){
        checkElementIndex(index);
        //1.现获取当前删除的Node节点
        Node oldNode = getNode(index);
        if(oldNode!=null){
            //2.获取删除元素的上下节点
            Node oldNextNode = oldNode.next;
            Node oldPrevNode = oldNode.prev;
            if(oldPrevNode == null){
                first = oldNextNode;
            }else{
                oldPrevNode.next=oldNextNode;
                oldNode.prev = null;
            }
            if(oldNextNode == null){
                last = oldPrevNode;
            }else{
                oldNextNode.prev=oldPrevNode;
                oldNode.next = null;
            }
            oldNode.object = null;
            size--;
        }
    }

    public void add(int index,E e){
        if(index == size){
            add(e);
        }else{
            checkElementIndex(index);
            Node oldNode = getNode(index);
            Node newNode = new Node();
            newNode.object = e;
            if(oldNode!=null){
                Node oldPrevNode = oldNode.prev;
                if(oldPrevNode == null){
                    first = newNode;
                }else{
                    newNode.prev = oldPrevNode;
                    oldPrevNode.next = newNode;
                    oldNode.prev = newNode;
                }
                newNode.next = oldNode;
                size++;
            }
        }


    }

    public static void main(String[] args){
        MyLinkedList<String> linkedList = new MyLinkedList<>();
            linkedList.add("a");
            linkedList.add("b");
            linkedList.add("c");
            linkedList.add(10,"d");
            for (int i = 0; i <linkedList.size ; i++) {
            System.out.println(linkedList.get(i));
        }


    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("下标越界了!");
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
}
