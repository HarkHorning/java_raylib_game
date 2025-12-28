package harkhorning.state.GameCycle;

import com.raylib.Raylib;
import harkhorning.Core.Draws.DrawRoot;
import harkhorning.Core.InitRoot;
import harkhorning.Core.Updates.UpdateRoot;
import harkhorning.state.ContextStream;
import harkhorning.state.GameState;
import harkhorning.state.StateMachine;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;
import static harkhorning.state.GameCycle.InGameState.PAUSE;

public class GameCycle implements GameState {

    StateMachine s;
    ContextStream ctx;
    InGameStateMachine inGameStateMachine;
    InitRoot initRoot;
    UpdateRoot updateRoot;
    DrawRoot drawRoot;

    public GameCycle(StateMachine stateMachine, ContextStream ctx)
    {
        s = stateMachine;
        this.ctx = ctx;
        this.inGameStateMachine = new InGameStateMachine(s);
        this.initRoot = new InitRoot();
        this.updateRoot = new UpdateRoot(initRoot);
        this.drawRoot = new DrawRoot(initRoot);
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
        updateRoot.update();
    }
    @Override
    public void Draw()
    {
        if (inGameStateMachine.draw()) return;
        DrawFPS(20, 20);
        drawRoot.draw();
    }
    @Override
    public void Exit()
    {
        System.out.println("Exiting GameCycle");
    }
}
