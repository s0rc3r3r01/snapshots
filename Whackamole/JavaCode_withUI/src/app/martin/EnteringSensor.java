package app.martin;

class EnteringSensor extends Sensor {

    private ActionAlias enterAlias;

    void setEnterAlias(ActionAlias actionAlias) {
        this.enterAlias = actionAlias;
    }

    EnteringSensor(int number, MartinMoleCanvas view) {
        super(number, view);
    }

    synchronized void enter() {
        view.log("Sensor" + getNumber() + ": action=enter");
        getView().flashSensor(getNumber());
        if (enterAlias != null) {
            enterAlias.execute();
        }
    }
}
