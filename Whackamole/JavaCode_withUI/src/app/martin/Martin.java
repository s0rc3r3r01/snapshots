package app.martin;

class Martin implements Runnable {

    public enum State {
        HOUSE, COURTYARD, ROAD
    }

    private State state;
    private final WarningIndicator indicator;
    private final MartinMoleCanvas view;

    Martin(WarningIndicator indicator, MartinMoleCanvas view) {
        super();
        this.indicator = indicator;
        this.view = view;
    }

    /*
	 * Aliasing - to match the FSP process renaming Martin process does not need
	 * to know about the sensor process.
     */
    private ActionAlias leaveAlias;
    private ActionAlias enterAlias;
    private ActionAlias exitAlias;

    synchronized void leave() {
        view.log("Martin: action=leave");
        leaveAlias.execute();  // Triggers sensor1.exit
        setState(State.COURTYARD);
    }

    synchronized void enter() throws InterruptedException {
        view.log("Martin: action=enter");
        setState(State.ROAD);
        enterAlias.execute(); // Triggers sensor1.enter
    }

    synchronized void exit() {
        view.log("Martin: action=exit");
        exitAlias.execute();  // Triggers sensor4.exit
        setState(State.HOUSE);
    }

    State getState() {
        return state;
    }

    @Override
    public void run() {

        try {          
            while (true) {

                leave();
                view.moveMartin(MartinMoleCanvas.MartinWayPoint.COURTYARD);
                while (!indicator.isOff()) {
                    view.log("Martin: waits");
                    synchronized (indicator) {
                        indicator.wait(); // wait on indicator to notify
                    }
                    view.log("Martin: woken");
                }
                enter();
                view.moveMartin(MartinMoleCanvas.MartinWayPoint.ROAD_END);
                exit();
                view.moveMartin(MartinMoleCanvas.MartinWayPoint.HOUSE);
                Thread.sleep(1000);
                view.log("Martin: wakes");

            }
        } catch (InterruptedException e) {
            view.log("Martin thread interrupted, finishing.");
        }

    }

    void setLeaveAlias(ActionAlias actionAlias) {
        this.leaveAlias = actionAlias;

    }

    void setEnterAlias(ActionAlias actionAlias) {
        this.enterAlias = actionAlias;

    }

    void setExitAlias(ActionAlias actionAlias) {
        this.exitAlias = actionAlias;

    }

    private void setState(State state) {
        this.state = state;
        view.log("Martin: transition to state=" + state);
    }
}
