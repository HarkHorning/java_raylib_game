package harkhorning.state.GameCycle;

import harkhorning.state.GameState;

import static harkhorning.state.GameCycle.InGameState.RUNNING;

public class InGameStateMachine {

    private InGameState state;
    private GameState currentState;
    private final GamePause paused;

    public InGameStateMachine()
    {
        this.state = RUNNING;
        paused = new GamePause(this);
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
