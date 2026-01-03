//package harkhorning.state.optionMenu;
package harkhorning.state.optionMenu;


import harkhorning.state.GameState;
import harkhorning.state.StateMachine;

import static com.raylib.Colors.DARKBROWN;
import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.DrawFPS;

public class OptionMenu implements GameState {

    StateMachine s;

    public OptionMenu(StateMachine stateMachine)
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
        ClearBackground(DARKBROWN);
    }
    @Override
    public void Exit()
    {
        System.out.println("Exiting GameCycle");
    }
}
