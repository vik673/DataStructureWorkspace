package com.app.core;

import customException.QueueHandlingException;

public interface QueueIntf {
	public void addQ(int elem) throws QueueHandlingException;
	public int deleteQ() throws QueueHandlingException;
	public boolean isEmpty();
	public boolean isFull();
}
