package app.martin;

/**
 * Controls the gate depending on sensor triggers.
 *
 * @author Priyanka Kotnis
 *
 */
class GateController {

    private final Gate gate;
    private State state = State.EXITED;
    private MartinMoleCanvas view;

    GateController(Gate gate, MartinMoleCanvas view) {
        this.gate = gate;
        this.view = view;
    }

    enum State {
        LOWERED, ENTERED, EXITED
    }

    synchronized void leave() {
        view.log("GateController: action=leave");           
        lower();
    }

    private synchronized void lower() {  
        setState(state.LOWERED);
        gate.lower();
    }

    /**
     * Martin enter
     */
    synchronized void enter() {
        view.log("GateController: action=enter");        
        setState(state.ENTERED);
    }

    synchronized void exit() {
        view.log("GateController: action=exit");
        /*Gate controller knows if Martin was on the road and implies Martin triggered the exit sensor by exiting.*/
        if (State.ENTERED.equals(state)) {
            view.log("GateController: Martin exit --> GATE Controller exit --> Raise the gate now");
            raise();
            state = State.EXITED;
        }
    }

    private synchronized void raise() {
        gate.raise();
    }

    private void setState(State state) {
        this.state = state;
        view.log("GateController: transition to state=" + state);
    }
}
