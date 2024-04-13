package model;

import view.Observer;
import java.util.List;
import java.util.ArrayList;

/**
 * class observable qui liste tout les observers.
 */
public abstract class Observable {
    private List<Observer> observerList;

    /**
    * constructeur des observables.
    */
    public Observable() {
        this.observerList = new ArrayList<Observer>();
    }

    /**
     * methode pour ajouter un observer.
     * @param o
     */
    public void addObserver(final Observer o) {
        observerList.add(o);
    }

    /**
     * methode pour supprimer un observer.
     * @param o
     */
    public void removeObserver(final Observer o) {
        observerList.remove(o);
    }

    /**
     * methode pour modifier d'une modification dans les observers.
     */
    public void notifyObservers() {
        for (Observer obs : observerList) {
            obs.update();
        }
    }

    public List<Observer> getObserverList() {
        return observerList;
    }
}
