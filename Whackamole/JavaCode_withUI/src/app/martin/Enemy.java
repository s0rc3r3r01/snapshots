package app.martin;

import java.util.ArrayList;
import java.util.List;

class Enemy implements Runnable {

    enum State {
        NOT_ON_ROAD, ROAD
    }

    private final int id;
    private State state;
    private final Gate gate;
    private final List<ActionAlias> enterAliases = new ArrayList<>();
    private final List<ActionAlias> exitAliases = new ArrayList<>();
    private final MartinMoleCanvas view;

    Enemy(int id, Gate gate, MartinMoleCanvas view) {
        super();
        this.id = id;
        this.gate = gate;
        this.view = view;
    }

    synchronized void enter() {
        view.log("Enemy" + id + ": action=enter");
        setState(State.ROAD);
        for (ActionAlias enterAlias : enterAliases) {
            enterAlias.execute();
        }
    }

    synchronized void exit() {
        view.log("Enemy" + id + ": action=exit");
        setState(State.NOT_ON_ROAD);
        for (ActionAlias exitAlias : exitAliases) {
            exitAlias.execute();
        }
    }

    State getState() {
        return state;
    }

    @Override
    public void run() {
        try {
            while (true) {
                view.moveEnemy(id, MartinMoleCanvas.EnemyWayPoint.GATE);
                while (!gate.isUp()) {
                    view.log("Enemy" + id + ": waits");
                    synchronized (gate) {
                        gate.wait(); // gate.raise will notify all waiting enemy threads
                    }
                    view.log("Enemy" + id + ": woken");
                }                
                enter();
                view.moveEnemy(id, MartinMoleCanvas.EnemyWayPoint.ROAD_END);
                exit();

            }
        } catch (InterruptedException e) {
            view.log("Enemy "+ id +" thread interrupted, finishing.");
        }
    }

    void addEnterAlias(ActionAlias actionAlias) {
        this.enterAliases.add(actionAlias);

    }

    void addExitAlias(ActionAlias actionAlias) {
        this.exitAliases.add(actionAlias);

    }

    private void setState(State state) {
        this.state = state;
        view.log("Enemy" + id + ": transitions to state=" + state);
    }

}
