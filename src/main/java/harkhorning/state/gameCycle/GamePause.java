package harkhorning.state.gameCycle;

import harkhorning.graphics.ui.Button;
import harkhorning.graphics.ui.ButtonInGame;
import harkhorning.state.GameState;
import harkhorning.state.State;
import harkhorning.state.StateMachine;

import java.util.ArrayList;

import static com.raylib.Colors.DARKPURPLE;
import static com.raylib.Raylib.*;
import static harkhorning.state.gameCycle.InGameState.RUNNING;

public class GamePause implements GameState {

    InGameStateMachine inGameStateMachine;
    StateMachine s;
    Button resume;
    Button mainMenuBtn;
    Button quitBtn;
    ArrayList<Button> buttons = new ArrayList<>();

    public GamePause(InGameStateMachine iGSM, StateMachine stateMachine)
    {
        this.inGameStateMachine = iGSM;
        this.s = stateMachine;
        resume = new ButtonInGame(s, inGameStateMachine, "Pause", RUNNING, State.RUNNING, 28, (float)(GetScreenWidth() / 2), 0, 10);
        mainMenuBtn = new Button(s, "Main Menu", State.MAIN_MENU, 28, (float)(GetScreenWidth() / 2), 1, 10);
        quitBtn = new Button(s, "Quit", State.QUITE, 28, (float)(GetScreenWidth() / 2), 2, 10);
        buttons.add(resume);
        buttons.add(mainMenuBtn);
        buttons.add(quitBtn);
    }

    @Override
    public void Init()
    {}
    @Override
    public void Update()
    {
        if (IsKeyPressed(KEY_ESCAPE)) {
            inGameStateMachine.setState(RUNNING);
        }
        for (Button button : buttons) {
            button.MouseOver();
        }
    }
    @Override
    public void Draw()
    {
        ClearBackground(DARKPURPLE);
        for (Button button : buttons) {
            button.DrawButton();
        }
    }
    @Override
    public void Exit()
    {}
}
