package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import view.Observer;

/**
 * classe ObservableTest.
 */
public class ObservableTest extends Observable {

    /**
     * MockObserver.
     */
    class MockObserver implements Observer {
        private boolean updated = false;

        @Override
        public void update() {
            updated = true;
        }
    }

    /**
     * test addObserver.
     */
    @Test
    void testAddObserver() {
        ObservableTest observable = new ObservableTest();
        MockObserver observer = new MockObserver();

        // Vérifier qu'au début la liste des observers est vide
        assertTrue(observable.getObserverList().isEmpty());

        observable.addObserver(observer);

        // Vérifier que l'observer a bien été ajouté
        assertEquals(1, observable.getObserverList().size());
        assertTrue(observable.getObserverList().contains(observer));
    }

    /**
     * test removeObserver.
     */
    @Test
    void testRemoveObserver() {
        ObservableTest observable = new ObservableTest();
        MockObserver observer = new MockObserver();
        observable.addObserver(observer);

        // Vérifier que l'observer a bien été ajouté
        assertEquals(1, observable.getObserverList().size());
        assertTrue(observable.getObserverList().contains(observer));

        observable.removeObserver(observer);

        // Vérifier que l'observer a bien été supprimé
        assertEquals(0, observable.getObserverList().size());
        assertFalse(observable.getObserverList().contains(observer));
    }

    /**
     * test NotifyObservers.
     */
    @Test
    void testNotifyObservers() {
        ObservableTest observable = new ObservableTest();
        MockObserver observer1 = new MockObserver();
        MockObserver observer2 = new MockObserver();

        observable.addObserver(observer1);
        observable.addObserver(observer2);

        // Vérifier que les observers n'ont pas encore été notifiés
        assertFalse(observer1.updated);
        assertFalse(observer2.updated);

        observable.notifyObservers();

        // Vérifier que les observers ont été notifiés
        assertTrue(observer1.updated);
        assertTrue(observer2.updated);
    }
}
