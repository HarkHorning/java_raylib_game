package harkhorning.state.GameCycle;

import harkhorning.state.GameState;
import harkhorning.state.StateMachine;

import static harkhorning.state.GameCycle.InGameState.RUNNING;

public class InGameStateMachine {

    private final StateMachine s;
    private InGameState state;
    private GameState currentState;
    private final GamePause paused;

    public InGameStateMachine(StateMachine stateMachine)
    {
        this.s = stateMachine;
        this.state = RUNNING;
        paused = new GamePause(this, s);
    }

    public void setState(InGameState state) {
        this.state = state;
    }

    public boolean update()
    {
        switch (state) {
            case PAUSE: currentState = paused; currentState.Update(); return true;
            default: return false;
        }
    }

    public boolean draw()
    {
        switch (state) {
            case PAUSE: currentState = paused; currentState.Draw(); return true;
            default: return false;
        }
    }
}
