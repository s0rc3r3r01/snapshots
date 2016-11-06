package app.martin;

class Gate {

    private MartinMoleCanvas view;
    private boolean isSafe;

    enum State {
        DOWN, UP
    }

    Gate(MartinMoleCanvas view, boolean isSafe) {
        this.view = view;
        this.isSafe = isSafe;
    }
    private State state = State.UP;

    protected State getState() {
        return state;
    }

    synchronized void lower() {
        if (isSafe) {
            view.log("Gate: action=gate.lower");
            setState(State.DOWN);
            view.gateDown();
        }
    }

    synchronized boolean isUp() {
        view.log("Gate: Enemy checking gate: state=" + state);
        return State.UP.equals(state);

    }

    synchronized void raise() {
        setState(State.UP);
        view.gateUp();
        notifyAll(); // enemies want to know about this.
        view.log("Gate: notifyAll");
    }

    private void setState(State state) {
        this.state = state;
        view.log("Gate: transition to state=" + state);
    }
}
