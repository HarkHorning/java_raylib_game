package harkhorning.state.MainMenu;

import com.raylib.Raylib;
import harkhorning.Graphics.UI.Button;
import harkhorning.Graphics.UI.Components;
import harkhorning.state.GameState;
import harkhorning.state.State;
import harkhorning.state.StateMachine;

import java.util.ArrayList;

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
        startBtn = new Button(s, "Start", State.RUNNING, 18, (float)(GetScreenWidth() / 2), 0, 6);
        optionsBtn = new Button(s, "Options", State.OPTION_MENU, 18, (float)(GetScreenWidth() / 2), 1, 6);
        quitBtn = new Button(s, "Quit", State.QUITE, 18, (float)(GetScreenWidth() / 2), 2, 6);
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
        com.CenteredText("Main Menu", Raylib.GetScreenWidth() / 2, 100, 22, com.colorMain);
        DrawFPS(20, 20);
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
