package com.lby.my12306.framework.starter.cache.core;

/**
 * 缓存加载器
 * @author lby
 */
@FunctionalInterface
public interface CacheLoader<T> {

    /**
     * 加载缓存
     * @return
     */
    T load();
}
