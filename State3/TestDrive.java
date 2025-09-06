package State3;

public class TestDrive {
	public static void main(String[] args) {
		
		// what about a singleton here???
		RemoteDevice remote = new RemoteDevice();
		
		remote.pressPlay();   // Stopped -> Playing
        remote.pressPause();  // Playing -> Paused
        remote.pressRewind(); // Paused -> Rewind -> auto Playing
        remote.pressLock();   // Lock while Playing
        remote.pressPlay();   // locked, ignored
        remote.pressPause();  // locked, ignored
        remote.pressLock();   // Unlock -> back to Playing
        remote.pressStop();   // Playing -> Stopped

	}

}
