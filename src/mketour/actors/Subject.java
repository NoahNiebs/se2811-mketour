package mketour.actors;


import mketour.AbstractChallenge;

import java.util.ArrayList;

public abstract class Subject {

    protected ArrayList<AbstractChallenge> observers;

    protected Subject() {
        this.observers = new ArrayList<>();
    }
    public void notifyObservers() {
        for (AbstractChallenge challenge : this.observers) {
            challenge.update(this);
        }
    }

    public void addObserver(AbstractChallenge challenge) {
        this.observers.add(challenge);
    }

}
