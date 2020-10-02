package core.java;

public interface NachObserver {

    /*
    @args: the nach observer that changed states.
    This method is run whenever the state of a nach
    observed by the NachObserver changes.
     */
    void update(final ObservableNach nach);
}
