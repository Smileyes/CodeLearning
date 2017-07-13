import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TankClient().launchFrame();
	}

	public TankClient() {
		super("Ì¹¿Ë´óÕ½");
	}

	private void launchFrame() {
		this.setVisible(true);
		this.setBounds(100, 100, 800, 600);
	}

}
