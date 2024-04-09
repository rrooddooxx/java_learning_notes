public class Box<T> {

    private T internalState;


    public void setState(T state)
    {
        this.internalState = state;
    }

    public T getState()
    {
        return this.internalState;
    }
}
