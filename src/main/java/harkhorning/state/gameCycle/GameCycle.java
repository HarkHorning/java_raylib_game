package harkhorning.state.gameCycle;

import harkhorning.core.draws.DrawRoot;
import harkhorning.core.InitRoot;
import harkhorning.core.updates.UpdateRoot;
import harkhorning.state.ContextStream;
import harkhorning.state.GameState;
import harkhorning.state.StateMachine;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;
import static harkhorning.state.gameCycle.InGameState.PAUSE;

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
        if (IsKeyDown(KEY_ESCAPE)) { inGameStateMachine.setState(PAUSE); }
        if (inGameStateMachine.update()) return;
        updateRoot.update();
    }
    @Override
    public void Draw()
    {
        ClearBackground(BLACK);
        if (inGameStateMachine.draw()) return;
        drawRoot.draw();
    }
    @Override
    public void Exit()
    {
        System.out.println("Exiting GameCycle");
    }
}
