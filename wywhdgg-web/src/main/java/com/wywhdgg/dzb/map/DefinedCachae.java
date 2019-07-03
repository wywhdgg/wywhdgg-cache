package com.wywhdgg.dzb.map;

/**
 * @author: dongzhb
 * @date: 2019/7/3
 * @Description:  手写实现缓存
 */
public abstract class DefinedCachae {
    abstract Object get(String key);

    abstract void add(String key, Object value, long periodInMillis);

    abstract void remove(String key);

    abstract void clear();

    abstract long size();
}
