package model;

import view.Observer;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 */
public abstract class Observable {
    private List<Observer> observerList;

    /**
    * 
    */
    public Observable() {
        this.observerList = new ArrayList<Observer>();
    }

    /**
     * 
     * @param o
     */
    public void addObserver(final Observer o) {
        observerList.add(o);
    }

    /**
     * 
     * @param o
     */
    public void removeObserver(final Observer o) {
        observerList.remove(o);
    }

    /**
     * 
     */
    public void notifyObservers() {
        for (Observer obs : observerList) {
            obs.update();
        }
    }
}
