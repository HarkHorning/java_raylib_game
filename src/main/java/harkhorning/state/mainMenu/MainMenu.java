//package harkhorning.state.mainMenu;
package harkhorning.state.mainMenu;



import com.raylib.Raylib;
import harkhorning.graphics.ui.Button;
import harkhorning.graphics.ui.Components;
import harkhorning.state.GameState;
import harkhorning.state.State;
import harkhorning.state.StateMachine;

import java.util.ArrayList;

import static com.raylib.Colors.DARKPURPLE;
import static com.raylib.Raylib.*;

public class MainMenu implements GameState {

    StateMachine s;
    Components com = new Components();
    Button startBtn;
    Button optionsBtn;
    Button quitBtn;
    ArrayList<Button> buttons = new ArrayList<>();

    public MainMenu(StateMachine stateMachine)
    {
        s = stateMachine;
    }

    @Override
    public void Init()
    {
        System.out.println("Initializing MainMenu");
        startBtn = new Button(s, "Start", State.RUNNING, 34, (float)(GetScreenWidth() / 2), 0, 10);
        optionsBtn = new Button(s, "Options", State.OPTION_MENU, 34, (float)(GetScreenWidth() / 2), 1, 10);
        quitBtn = new Button(s, "Quit", State.QUITE, 34, (float)(GetScreenWidth() / 2), 2, 10);
        buttons.add(startBtn);
        buttons.add(optionsBtn);
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
        ClearBackground(DARKPURPLE);
        com.CenteredText("GNOME SURVIVOR", Raylib.GetScreenWidth() / 2, 80, 64, com.colorMain);
        DrawFPS(20, 10);
        for (Button button : buttons) {
            button.DrawButton();
        }
    }
    @Override
    public void Exit()
    {
        System.out.println("Exiting MainMenu");
    }
}
