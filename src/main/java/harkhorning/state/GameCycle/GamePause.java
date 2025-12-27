package harkhorning.state.GameCycle;

import harkhorning.state.ContextStream;
import harkhorning.state.GameState;
import harkhorning.state.StateMachine;

import static com.raylib.Colors.DARKGREEN;
import static com.raylib.Colors.PURPLE;
import static com.raylib.Raylib.*;
import static harkhorning.state.GameCycle.InGameState.RUNNING;

public class GamePause implements GameState {

    InGameStateMachine inGameStateMachine;

    public GamePause(InGameStateMachine iGSM)
    {
        this.inGameStateMachine = iGSM;
    }

    @Override
    public void Init()
    {}
    @Override
    public void Update()
    {
        if (IsKeyReleased(KEY_ESCAPE)) {
            inGameStateMachine.setState(RUNNING);
        }
    }
    @Override
    public void Draw()
    {
        ClearBackground(PURPLE);
    }
    @Override
    public void Exit()
    {}
}
