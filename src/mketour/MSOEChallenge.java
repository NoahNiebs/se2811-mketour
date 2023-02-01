package mketour;

import mketour.actors.Car;
import mketour.actors.Subject;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;

import java.util.ArrayList;

public class MSOEChallenge extends AbstractChallenge {

    private boolean hasTouchedCar = false;
    private Text MSOEChallengePrompt;
    private Text compiledWord;

    private Text finalMessage;

    private boolean isCompleted = false;

    private String MSOEWord = "****";
    MSOEChallenge(Pane challengePane) {
        super(challengePane);
        MSOEChallengePrompt = new Text("\nChallenge: Find all the letters in MSOE\nGoal: MSOE");
        compiledWord = new Text("Found: ****");
        finalMessage = new Text("");
        challengePane.getChildren().addAll(MSOEChallengePrompt,compiledWord, finalMessage);
    }

    @Override
    public void update(Subject subject) {

        if (!isCompleted) {
            if (!subject.getClass().getSimpleName().equals("Car")) {
                throw new IllegalArgumentException("MSOE Challenge must only have car observers");
            }

            Car car = (Car) subject;


            String plateNumber = car.getName().split(":")[1];
            for (int i = 0; i < "MSOE".length(); i++) {
                for (int j = 0; j < plateNumber.length(); j++) {
                    if (MSOEWord.charAt(i) == '*' && "MSOE".charAt(i) == plateNumber.charAt(j)) {
                        MSOEWord = MSOEWord.substring(0, i) + "MSOE".charAt(i) + MSOEWord.substring(i + 1);

                    }
                }

            }
            compiledWord.setText("Found: " + MSOEWord);
            if (MSOEWord.equals("MSOE")) {
                isCompleted = true;
                finalMessage.setText("MSOE Challenge Completed");
            }
        }

    }
}
