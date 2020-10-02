package core.java;

public interface ObservableNach {
    /**
     * @param nacher
     * Adds an observer to the internal list of observers.
     */
    void addObserver(NachObserver nacher);

    /**
     * @param nacher
     * Deletes an observer from the internal list of observers.
     */
    void deleteObserver(NachObserver nacher);

    /**
     *  Deletes all observers from the internal list of observers.
     */
    void deleteObservers();

    /**
     * @return Returns the number of observers in the internal list of observers.
     */
    int countObservers();

    /**
     * Sets the internal flag that indicates this observable has changed state.
     */
    void setChanged();

    /*
    Clears the internal flag that indicates this observable has changed state.
     */
    void clearChanged();

    /*
    Returns the boolean value true if this observable has changed state.
     */
    void notifyObservers();

    /*
    Checks the internal flag to see if the observable has changed state
    and notifies all observers.
     */
    boolean hasChanged();

    /*
    Checks the internal flag to see if the observable has changed state
    and notifies all observers. Passes the object specified in the parameter
    list to the notify() method of the observer.
     */
    void notifyObservers(NachObserver nacher);
}
