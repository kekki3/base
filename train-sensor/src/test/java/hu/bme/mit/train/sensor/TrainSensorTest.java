package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainController;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController mockTC;
    TrainUser mockTU;
    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        // TODO Add initializations
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTC,mockTU);
    }

    @Test
    public void AbsuMinMargin() {
        // TODO Delete this and add test cases based on the issues
        trainSensor.overrideSpeedLimit(-5);
        verify(mockTU , times(1)).setAlarmState(true);

    }
    @Test
    public void AbsuMaxMargin() {
        // TODO Delete this and add test cases based on the issues
        trainSensor.overrideSpeedLimit(508);
        verify(mockTU , times(1)).setAlarmState(true);
        
    }
    @Test
    public void RelaMargin() {
        // TODO Delete this and add test cases based on the issues
        trainSensor.overrideSpeedLimit(4);

        verify(mockTU , times(1)).setAlarmState(false);
        
    }
    @Test
    public void BetweenMargin() {
        // TODO Delete this and add test cases based on the issues
        trainSensor.overrideSpeedLimit(200);
        verify(mockTU , times(1)).setAlarmState(false);
        
    }
}
