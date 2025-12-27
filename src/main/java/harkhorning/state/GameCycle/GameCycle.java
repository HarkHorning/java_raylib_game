package harkhorning.state.GameCycle;

import harkhorning.state.GameState;
import harkhorning.state.StateMachine;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.DrawFPS;

public class GameCycle implements GameState {

    StateMachine s;

    public GameCycle(StateMachine stateMachine)
    {
        s = stateMachine;
    }

    @Override
    public void Init()
    {
        System.out.println("Initializing GameCycle");
    }
    @Override
    public void Update()
    {
    }
    @Override
    public void Draw()
    {
        DrawFPS(20, 20);
        ClearBackground(DARKGREEN);
    }
    @Override
    public void Exit()
    {
        System.out.println("Exiting GameCycle");
    }
}
