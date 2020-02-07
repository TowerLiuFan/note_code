package com.liufan.note.myhashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Fan
 * @Date: 2020/2/6 13:19
 * 基于ArrayList实现hashMap集合
 */
public class MyArrayListHashMap<Key,Value> {

    //map集合存储的容量
    private List<Entry<Key,Value>> tables = new ArrayList<Entry<Key,Value>>();

    //private int size;

    public void put(Key key,Value value){
        Entry<Key, Value> entry = getEntry(key);
        if(entry!=null){
            //已经存在
            entry.value = value;
        }else{
           Entry newEntry = new Entry(key,value);
           tables.add(newEntry);
        }
    }

    public Value get(Key key){
        Entry<Key,Value> entry =  getEntry(key);
        return entry == null ? null : entry.value ;
    }

    public Entry<Key,Value> getEntry(Key key){
        for (Entry<Key,Value> entry : tables){
            if(entry.key.equals(key)){
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args){
        MyArrayListHashMap<String, String> hashMap = new MyArrayListHashMap<>();
        hashMap.put("a","aaaa");
        hashMap.put("b","bbbb");
        hashMap.put("a","cccc");
        System.out.println(hashMap.get("a"));

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
