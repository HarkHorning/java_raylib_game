package harkhorning.graphics.ui;

import com.raylib.Raylib;
import harkhorning.state.State;
import harkhorning.state.StateMachine;
import harkhorning.state.gameCycle.InGameState;
import harkhorning.state.gameCycle.InGameStateMachine;

import static com.raylib.Colors.GRAY;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.MOUSE_BUTTON_LEFT;

public class ButtonInGame extends Button {

    InGameState iGSP;
    InGameStateMachine iSM;

    public ButtonInGame(StateMachine s, InGameStateMachine iSM, String t, InGameState iGSP, State sP, int size, float x, int i, int pad) {
        super(s, t, sP, size, x, i, pad);
        this.iSM = iSM;
        this.iGSP = iGSP;
    }

    @Override
    public void OnClick()
    {
        iSM.setState(iGSP);
    }
    @Override
    public void MouseOver()
    {
        if (CheckCollisionPointRec(GetMousePosition(), rect)) {
            selected = true;
            if (IsMouseButtonReleased(MOUSE_BUTTON_LEFT)) {
                OnClick();
            }
        } else selected = false;
    }
    @Override
    public void DrawButton()
    {
        if (selected) {
            Raylib.DrawRectangleLinesEx(rect, 4.0f, GRAY);
        }
        Raylib.DrawText(text, (int)p.x(), (int)p.y(), size, GRAY);
    }
}
