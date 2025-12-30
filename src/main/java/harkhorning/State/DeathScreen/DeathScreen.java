package harkhorning.State.DeathScreen;

import harkhorning.State.GameState;
import harkhorning.State.StateMachine;

import static com.raylib.Colors.MAROON;
import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.DrawFPS;

public class DeathScreen implements GameState {

    StateMachine s;

    public DeathScreen(StateMachine stateMachine)
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
        ClearBackground(MAROON);
    }
    @Override
    public void Exit()
    {
        System.out.println("Exiting GameCycle");
    }
}
