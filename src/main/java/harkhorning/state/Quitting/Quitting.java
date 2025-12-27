package harkhorning.state.Quitting;

import harkhorning.state.GameState;
import harkhorning.state.StateMachine;

import static com.raylib.Colors.BLACK;
import static com.raylib.Colors.DARKGREEN;
import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.DrawFPS;

public class Quitting implements GameState {

    StateMachine s;

    public Quitting(StateMachine stateMachine)
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
        s.CLOSE_GAME();
    }
    @Override
    public void Draw()
    {
        DrawFPS(20, 20);
        ClearBackground(BLACK);
    }
    @Override
    public void Exit()
    {
        System.out.println("Exiting GameCycle");
    }
}
