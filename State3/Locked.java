package State3;

public class Locked implements State {
    private RemoteDevice remote;
    private State previousState;

    public Locked(RemoteDevice remote, State previousState) {
        this.remote = remote;
        this.previousState = previousState;
        System.out.println("The player is now LOCKED. All buttons are disabled until unlocked.");
    }

    public boolean pressPlay() {
        System.out.println("Player is locked. Cannot play.");
        return false;
    }

    public boolean pressPause() {
        System.out.println("Player is locked. Cannot pause.");
        return false;
    }

    public boolean pressStop() {
        System.out.println("Player is locked. Cannot stop.");
        return false;
    }

    public boolean pressRewind() {
        System.out.println("Player is locked. Cannot rewind.");
        return false;
    }

    public boolean pressLock() {
        System.out.println("Player is unlocked. Returning to "+ previousState + ".");
        remote.setState(previousState);
        return true;
    }
}
