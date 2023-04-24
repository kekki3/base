package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.RowSortedTable;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import java.time.LocalTime;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private HashBasedTable<LocalTime, Integer, Integer> table = HashBasedTable.create();     
	  

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
		if (speedLimit < 0 || speedLimit> 500)
			user.setAlarmState(true);
		
		else if (controller.getReferenceSpeed() * 0.5 >= speedLimit )
			user.setAlarmState(true);
		else {
			user.setAlarmState(false);
		}
	}
	@Override
	public void addTachoGraphElement(int referenceSpeed, LocalTime time, int position){
		try {
			table.put(time, referenceSpeed, position); 
		} catch (Exception e) {
			//TODO: handle exception
		}
		
	} 
	@Override
	public LocalTime getTime(){
		LocalTime now = LocalTime.now() ;
		return now; 
	} 	
	@Override
	public Boolean isEmpty( HashBasedTable<LocalTime, Integer, Integer>  table){
		try {
			return table.isEmpty(); 
		} catch (Exception e) {
			return true;
		}
		
	} 
	@Override
	public HashBasedTable<LocalTime, Integer, Integer>  getTable(){
		return table; 
	} 


}
