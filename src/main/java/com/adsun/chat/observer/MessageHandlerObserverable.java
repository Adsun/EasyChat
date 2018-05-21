package com.adsun.chat.observer;

import java.util.ArrayList;
import java.util.List;

import com.adsun.chat.message.Message;

/**
 * @author fengxiang
 * @date 2018年5月18日
 */
public class MessageHandlerObserverable implements Observerable {

	//注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> list;
    private static MessageHandlerObserverable messageHandlerObserverable = null;
    
    public synchronized static MessageHandlerObserverable getInstance() {
    	if (messageHandlerObserverable == null) {
    		messageHandlerObserverable = new MessageHandlerObserverable();
    	}
    	return messageHandlerObserverable;
    }
    
	private MessageHandlerObserverable() {
		list = new ArrayList<Observer>();
	}


	public void registerObserver(Observer o) {
		list.add(o);
	}

	
	public void removeObserver(Observer o) {
		list.remove(o);
	}

	public void notifyObserver(Message obj) {
		for(int i = 0; i < list.size(); i++) {
            Observer oserver = list.get(i);
            oserver.update(obj);
        }
	}
}
