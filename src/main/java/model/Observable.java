package model;

import view.Observer;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe observable qui liste tous les observers.
 */
public abstract class Observable {
    private List<Observer> observerList;

    /**
    * Constructeur des observables.
    */
    public Observable() {
        this.observerList = new ArrayList<Observer>();
    }

    /**
     * Méthode pour ajouter un observer.
     * @param o
     */
    public void addObserver(final Observer o) {
        observerList.add(o);
    }

    /**
     * Méthode pour supprimer un observer.
     * @param o
     */
    public void removeObserver(final Observer o) {
        observerList.remove(o);
    }

    /**
     * Méthode pour notifier d'une modification dans les observers.
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
