/**
 * State.java
 *
 * This file represents the different transitions
 * between all states.
 */
package State2;

public interface State {
	public boolean pressPlay();
	public boolean pressPause();
	public boolean pressStop();
	public boolean pressRewind();
}
