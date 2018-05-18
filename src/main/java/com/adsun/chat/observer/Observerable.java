package com.adsun.chat.observer;


/**
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 * @author fengxiang
 * @date 2018年5月18日
 */
public interface Observerable {
    
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
    
}
