/**
 * Playing.java
 *
 * This file represents the Playing state
 */
package State3;

public class Playing implements State {

    private RemoteDevice remote;

    public Playing(RemoteDevice remote) {
        this.remote = remote;
    }

    // the Play button is pressed
    public boolean pressPlay() {
        System.out.println("The player is already playing.");

        return false;
    }

    // the Pause button is pressed
    public boolean pressPause() {
        System.out.println("The player is paused.");
        remote.setState(remote.getPausedState());

        return true;
    }

    // the Stop button is pressed
    public boolean pressStop() {
        System.out.println("The player is stopped.");
        remote.setState(remote.getStoppedState());
        remote.setPosition(0);

        return true;
    }

    public boolean pressRewind() {
        System.out.println("The player is rewinding...");
        remote.setState(remote.getRewindState());
        remote.setPosition(0);

        System.out.println("Rewind complete, automatically starting playback.");
        remote.setState(remote.getPlayingState());
        remote.setPosition(remote.getPosition() + 1);

        return false;
    }

    public boolean pressLock() {
        System.out.println("The player is now LOCKED. All buttons are disabled until unlocked.");
        remote.setState(new Locked(remote, this));
        return true;
    }

    public String toString() {
        return "Playing";
    }

}
