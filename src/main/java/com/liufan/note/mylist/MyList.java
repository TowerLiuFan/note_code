package com.liufan.note.mylist;

/**
 * List接口
 * @param <E>
 */
public interface MyList<E> {

    public void add(E e);

    public E get(int index);

    public E remove(int index);

    public int size();
}
