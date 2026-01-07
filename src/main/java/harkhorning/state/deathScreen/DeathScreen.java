//package harkhorning.state.deathScreen;
package harkhorning.state.deathScreen;


import com.raylib.Raylib;
import harkhorning.graphics.ui.Button;
import harkhorning.graphics.ui.Components;
import harkhorning.state.GameState;
import harkhorning.state.State;
import harkhorning.state.StateMachine;

import java.util.ArrayList;

import static com.raylib.Colors.MAROON;
import static com.raylib.Raylib.*;

public class DeathScreen implements GameState {

    StateMachine s;
    Components com = new Components();
    Button mainMenuBtn;
    Button quitBtn;
    ArrayList<Button> buttons = new ArrayList<>();

    public DeathScreen(StateMachine stateMachine)
    {
        s = stateMachine;
    }

    @Override
    public void Init()
    {
        System.out.println("Initializing DeathScreen");
        mainMenuBtn = new Button(s, "Main Menu", State.MAIN_MENU, 34, (float)(GetScreenWidth() / 2), 0, 10);
        quitBtn = new Button(s, "Quit", State.QUITE, 34, (float)(GetScreenWidth() / 2), 1, 10);
        buttons.add(mainMenuBtn);
        buttons.add(quitBtn);
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
        ClearBackground(MAROON);
        com.CenteredText("YOU DIED", Raylib.GetScreenWidth() / 2, 80, 64, com.colorMain);
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
