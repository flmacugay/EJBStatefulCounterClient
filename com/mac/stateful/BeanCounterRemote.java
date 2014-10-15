package com.mac.stateful;

import javax.ejb.Remote;

@Remote
public interface BeanCounterRemote {
	int getCount();
	void addCount();
}
