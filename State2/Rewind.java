package State2;

public class Rewind implements State {
	private RemoteDevice remote;
	
	public Rewind(RemoteDevice remote) {
		this.remote = remote;
	}

	// the Play button is pressed
	public boolean pressPlay() {
		System.out.println("The player is already playing.");
		
		return false;
	}

	// the Pause button is pressed
	public boolean pressPause() {
		System.out.println("The player is now paused.");
		
		return true;
	}


	// the Stop button is pressed
	public boolean pressStop() {
		System.out.println("The player is now stopped.");
		remote.setState(remote.getStoppedState());
		remote.setPosition(0);
		
		return true;
	}

    public boolean pressRewind() {
		System.out.println("The player is already rewinded.");
		
		return false;
	}
}
