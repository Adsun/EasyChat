package com.adsun.chat.observer;

import com.adsun.chat.message.Message;

/**
 * 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 * @author fengxiang
 * @date 2018年5月18日
 */
public interface Observer {
    public void update(Message message);
}
