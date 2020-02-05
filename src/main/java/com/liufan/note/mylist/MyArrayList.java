package com.liufan.note.mylist;

import java.util.Arrays;

/**
 * 1.jdk 1.7后 数组默认数据大小放在add方法
 * 2.arraylist 底层采用数组实现，数组名称elementData
 * 3.arraylist数组默认初始化大小为10
 */
public class MyArrayList<E> implements MyList<E>{

    //Arraylist底层采用数组存放
    private Object[] elementData;

    //默认数组初始化容量
    private static final int DEFAULT_CAPACITY = 10;

    //实际ArrayList大小
    private int size;

    //Arraylist指定数组初始容量
    public MyArrayList(int initialCapacity) {
        if(initialCapacity<0){
            throw new IllegalArgumentException("初始容量不能小于0");
        }
        elementData  =  new Object[initialCapacity];
    }

    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }

    //每次扩容是以1.5倍扩容的
    public void add(E e){
        //1.判断实际存放的数据容量是否大于elementData
        ensureExplicitCapacity(size+1);
        //2.使用下标进行赋值
        elementData[size++] = e;
    }

    private void ensureExplicitCapacity(int minCapacity){
        if(size == elementData.length){
            //新数据容量大小
            int oldCapacity = elementData.length;
            //  oldCapacity >> 1   ==  oldCapacity/2
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    public E remove(int index) {
        rangeCheck(index);
        //1.使用下标查询该值是否存在
        E object = get(index);
        //计算删除元素后面的长度
        int numMoved = size - index -1;
        if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index,numMoved);
        elementData[--size] = null;
        return object;
    }

    public E get(int index){
        rangeCheck(index);
        return elementData(index);
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("下标越界了");
    }

    public int size(){
        return size;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }
}
