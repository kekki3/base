package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private boolean alarmstate;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
		this.alarmstate = false;
	}

	@Override
	public boolean getAlarmFlag() {
		return false;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}
	@Override
	public boolean getAlarmState() {return alarmstate;}

	@Override
	public void setAlarmState(boolean state) {alarmstate = state;}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);
	}

}
