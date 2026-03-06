//package harkhorning.state.optionMenu;
package harkhorning.state.optionMenu;


import com.raylib.Raylib;
import harkhorning.graphics.ui.Button;
import harkhorning.graphics.ui.Components;
import harkhorning.state.GameState;
import harkhorning.state.State;
import harkhorning.state.StateMachine;

import java.util.ArrayList;

import static com.raylib.Colors.BLACK;
import static com.raylib.Colors.DARKBROWN;
import static com.raylib.Raylib.*;

public class OptionMenu implements GameState {

    StateMachine s;
    Components com = new Components();
    Button mainMenuBtn;
    ArrayList<Button> buttons = new ArrayList<>();

    public OptionMenu(StateMachine stateMachine)
    {
        s = stateMachine;
    }

    @Override
    public void Init()
    {
        System.out.println("Initializing GameCycle");
        mainMenuBtn = new Button(s, "Main Menu", State.MAIN_MENU, 34, (float)(GetScreenWidth() / 2), 0, 10);
        buttons.add(mainMenuBtn);
    }
    @Override
    public void Update()
    {
        for (Button button : buttons) {
            button.MouseOver();
        }
    }
    @Override
    public void Draw()
    {
        DrawFPS(20, 20);
        ClearBackground(DARKBROWN);
        com.CenteredText("OPTIONS", Raylib.GetScreenWidth() / 2, 60, 64, BLACK);
        for (Button button : buttons) {
            button.DrawButton();
        }
    }
    @Override
    public void Exit()
    {
        System.out.println("Exiting GameCycle");
    }
}
