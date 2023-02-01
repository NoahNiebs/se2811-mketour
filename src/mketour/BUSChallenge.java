package mketour;

import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import mketour.actors.Car;
import mketour.actors.Subject;

public class BUSChallenge extends AbstractChallenge {

    private boolean challengeStarted = false;
    private Text BUSChallengePrompt;
    private Text compiledWord;

    private Text finalMessage;

    private String BUSWord = "***";
    BUSChallenge(Pane challengePane) {
        super(challengePane);
        compiledWord = new Text("");
        BUSChallengePrompt = new Text("");
        finalMessage = new Text("");
        challengePane.getChildren().addAll(BUSChallengePrompt, compiledWord, finalMessage);

    }

    @Override
    public void update(Subject subject) {


        if (!challengeCompleted) {
            if (!challengeStarted && subject.getClass().getSimpleName().equals("Bus")) {
                challengeStarted = true;
                BUSChallengePrompt.setText("\nChallenge: Find all the letters in BUS\nGoal: BUS");
                compiledWord.setText("Found: ***");

            }
            if (challengeStarted && subject.getClass().getSimpleName().equals("Car")) {
                Car car = (Car) subject;
                String plateNumber = car.getName().split(":")[1];
                for (int i = 0; i < "BUS".length(); i++) {
                    for (int j = 0; j < plateNumber.length(); j++) {
                        if (BUSWord.charAt(i) == '*' && "BUS".charAt(i) == plateNumber.charAt(j)) {
                            BUSWord = BUSWord.substring(0, i) + "BUS".charAt(i) + BUSWord.substring(i + 1);

                        }
                    }

                }
                compiledWord.setText("Found: " + BUSWord);
            }
            if (BUSWord.equals("BUS")) {
                challengeCompleted = true;
                finalMessage.setText("BUS Challenge Completed");
            }

        }
    }
}
