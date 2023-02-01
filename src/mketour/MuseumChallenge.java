package mketour;

import mketour.actors.MobileEntity;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.image.ImageView;
import mketour.actors.Subject;

import javafx.scene.image.Image;


public class MuseumChallenge extends AbstractChallenge {

    Pane artPane;

    Text finalMessage;
    MuseumChallenge(Pane challengePane) {
        super(challengePane);
        artPane = new Pane();
        finalMessage = new Text("");
        challengePane.getChildren().addAll(new Text("Challenge: Find art"), artPane, finalMessage);

    }

    @Override
    public void update(Subject subject) {
        if (!challengeCompleted) {
            challengeCompleted = true;
            Image image = new Image(CityMap.class.getResource("img/wood-gatherer.png").toString(), CityMap.MIN_CHALLENGES_WIDTH, CityMap.MIN_CHALLENGES_WIDTH, true, true);
            artPane.getChildren().addAll(new ImageView(image));
            finalMessage.setText("Artistic work found");

        }


    }
}
