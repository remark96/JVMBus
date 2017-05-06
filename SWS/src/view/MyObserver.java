package view;

import model.MyObservable;

public interface MyObserver {
	public void update(MyObservable obs, Object obj);
}
