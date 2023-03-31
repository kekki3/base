package hu.bme.mit.train.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

import com.google.common.collect.HashBasedTable;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	void addTachoGraphElement(int referenceSpeed, LocalTime time, int position); 

	LocalTime getTime(); 

	Boolean isEmpty(HashBasedTable<LocalTime, Integer, Integer>  table); 

	HashBasedTable getTable(); 

}
