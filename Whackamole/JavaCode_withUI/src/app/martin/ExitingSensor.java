package app.martin;

class ExitingSensor extends Sensor {

    ExitingSensor(int number, MartinMoleCanvas view) {
        super(number, view);
    }

    /*
	public void exit() {
		if ("sensor1".equals(getName())) {
			gateController.leave();
		} else if ("sensor4".equals(getName())) {
			gateController.exit();
		}
	}
     */
    //Gate controller is listening to Exit Sensor
    private ActionAlias exitAlias;

    void setExitAlias(ActionAlias actionAlias) {
        this.exitAlias = actionAlias;
    }

    synchronized void exit() {
        view.log("Sensor" + getNumber() + ": action=exit");
        getView().flashSensor(getNumber());
        
        //if Sensor1: gateController.leave else if Sensor4 gateController.exit(): 
        exitAlias.execute();
    }
}
