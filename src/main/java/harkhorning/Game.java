package harkhorning;

import com.raylib.Raylib;
import harkhorning.state.ContextStream;
import harkhorning.state.StateMachine;
import harkhorning.state.UpdateThread;

import static com.raylib.Colors.RAYWHITE;
import static com.raylib.Raylib.*;

public class Game { // make this a runnable

    StateMachine s;
    ContextStream ctx;
    UpdateThread updateThread;

    public Game()
    {
        SetConfigFlags(FLAG_FULLSCREEN_MODE);
//        InitWindow(1280, 720, "Gnome Survivor");
        InitWindow(640, 360, "Gnome Survivor");
        this.ctx = new ContextStream();
        this.s = new StateMachine(ctx);
        this.updateThread = new UpdateThread(s);
    }

    public void Run()
    {
        Raylib r = new Raylib();
        updateThread.startUpdateThread();
        SetExitKey(KEY_NULL);
        SetTargetFPS(30);

        while (!WindowShouldClose() && !s.CHECK_GAME_OVER()) {
            BeginDrawing();
            ClearBackground(RAYWHITE);

            s.DrawGame();

            EndDrawing();
        }

        updateThread.stopUpdateThread();
        CloseWindow();
    }
}
