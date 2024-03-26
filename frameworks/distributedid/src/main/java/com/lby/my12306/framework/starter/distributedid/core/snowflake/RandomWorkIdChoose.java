package com.lby.my12306.framework.starter.distributedid.core.snowflake;

import org.springframework.beans.factory.InitializingBean;

/**
 * 使用随机数获取雪花 WorkId
 * @author lby
 */
public class RandomWorkIdChoose extends AbstractWorkIdChooseTemplate implements InitializingBean {
    /**
     * 根据自定义策略获取 WorkId 生成器
     *
     * @return
     */
    @Override
    protected WorkIdWrapper chooseWorkId() {
        int start = 0, end = 31;
        return new WorkIdWrapper(getRandom(start, end), getRandom(start, end));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        chooseAndInit();
    }

    private static long getRandom(int start, int end) {
        return (long) (Math.random() * (end - start + 1) +start);
    }
}
