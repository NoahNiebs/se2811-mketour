package mketour;


import mketour.actors.Subject;
import javafx.scene.layout.Pane;
public abstract class AbstractChallenge {

    protected boolean challengeCompleted;

    Pane challengePane;

    AbstractChallenge(Pane challengePane) {
        this.challengeCompleted = false;
        this.challengePane = challengePane;
    }

    public abstract void update(Subject subject);
}
