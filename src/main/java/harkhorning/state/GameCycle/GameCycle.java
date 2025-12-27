package harkhorning.state.GameCycle;

import com.raylib.Raylib;
import harkhorning.state.ContextStream;
import harkhorning.state.GameState;
import harkhorning.state.StateMachine;

import java.awt.event.KeyEvent;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;
import static harkhorning.state.GameCycle.InGameState.PAUSE;
import static java.awt.event.KeyEvent.VK_ESCAPE;

public class GameCycle implements GameState {

    StateMachine s;
    ContextStream ctx;
    InGameStateMachine inGameStateMachine;
    GameState inGameState;
    public InGameState stateEnum;
    GamePause pause;

    public GameCycle(StateMachine stateMachine, ContextStream ctx)
    {
        s = stateMachine;
        this.ctx = ctx;
        this.inGameStateMachine = new InGameStateMachine();
    }

    public void setInGameState(InGameState newState) {
        stateEnum = newState;
    }

    @Override
    public void Init()
    {
        System.out.println("Initializing GameCycle");
    }
    @Override
    public void Update()
    {
        if (inGameStateMachine.update()) return;
        if (IsKeyReleased(KEY_ESCAPE)) { inGameStateMachine.setState(PAUSE); }
        Raylib.Vector2 lockedGShift = ctx.GlobalShift;
    }
    @Override
    public void Draw()
    {

        if (inGameStateMachine.draw()) return;
        DrawFPS(20, 20);
        ClearBackground(DARKGREEN);
    }
    @Override
    public void Exit()
    {
        System.out.println("Exiting GameCycle");
    }
}
