package State2;

public class TestDrive {
	public static void main(String[] args) {
		
		// what about a singleton here???
		RemoteDevice remote = new RemoteDevice();
		
		remote.pressPlay();   // Stopped -> Playing
        remote.pressPause();  // Playing -> Paused
        remote.pressRewind(); // Paused -> Rewind
        remote.pressPause();  // Rewind -> Paused
        remote.pressPlay();   // Paused -> Playing
        remote.pressStop();   // Playing -> Stopped
        remote.pressStop();   // Stopped -> already stopped
        remote.pressRewind(); // Stopped -> Rewind
        remote.pressPlay();   // Rewind -> Playing
        remote.pressRewind(); // Playing -> Rewind
        remote.pressRewind(); // Rewind -> already rewinded

	}

}
