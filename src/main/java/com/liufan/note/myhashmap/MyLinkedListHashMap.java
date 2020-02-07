package com.liufan.note.myhashmap;

import java.util.LinkedList;

/**
 * @Author: Fan
 * @Date: 2020/2/6 14:16
 * 基于LinkedList实现hashMap集合
 */
public class MyLinkedListHashMap {

    //Map存放元素信息
    LinkedList<Entry>[] tables = new LinkedList[998];

    public void put(Object key,Object value){
        Entry newEntry = new Entry(key,value);
        int hash = getHash(key);
        //1.获取该下标元素，是否有值
        LinkedList<Entry> entryLinkedList = tables[hash];
        if(entryLinkedList == null){
            //没有hash冲突
            entryLinkedList = new LinkedList<Entry>();
            entryLinkedList.add(newEntry);
            tables[hash] = entryLinkedList;
        }else{
            //发生hash冲突，在链表后面继续添加节点
            for (Entry entry:entryLinkedList){
                 if(entry.key.equals(key)){
                    //hashCode相同 equals相同 同一个对象
                     entry.value = value; //直接覆盖
                 }else{
                     //hashCode相同 equals不相同
                     entryLinkedList.add(newEntry);
                 }

            }

        }
    }

    private int getHash(Object key){
        int hashCode = key.hashCode();
        int hash = hashCode % tables.length;
        return hash;
    }

    public Object get(String key){
        int hashCode = key.hashCode();
        int hash = hashCode % tables.length;
        LinkedList<Entry> entryLinkedList = tables[hash];
        for (Entry entry:entryLinkedList){
           if(entry.key.equals(key)){
               return entry.value;
           }
        }
        return tables[hash];
    }

    public static void main(String[] args){
        MyLinkedListHashMap map = new MyLinkedListHashMap();
        map.put("a","aaaa");
        map.put("b","bbbb");
        map.put("a","cccc");
        System.out.println(map.get("a"));

    }

}

//hash存储对象
class Entry<Key,Value>{

    //hashMap存储的k，v
    Key key;
    Value value;

    public Entry(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}
