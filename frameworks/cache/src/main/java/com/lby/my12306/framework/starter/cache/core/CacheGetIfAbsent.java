package com.lby.my12306.framework.starter.cache.core;

/**
 * 缓存查询为空
 * @author lby
 */
@FunctionalInterface
public interface CacheGetIfAbsent<T> {

    /**
     * 如果查询结果为空，执行逻辑
     */
    void execute(T param);
}
