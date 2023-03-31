package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import java.time.LocalTime;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private static HashBasedTable<LocalTime,Integer,Integer> table;   
	  

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
	}
	@Override
	public void addTachoGraphElement(int referenceSpeed, LocalTime time, int position){
	table.put(time, referenceSpeed, position); 
	} 
	@Override
	public LocalTime getTime(){
		return java.time.LocalTime.now(); 
	} 	
	@Override
	public Boolean isEmpty( HashBasedTable<LocalTime, Integer, Integer>  table){
		return table.isEmpty(); 
	} 
	@Override
	public HashBasedTable getTable(){
		return table; 
	} 


}
