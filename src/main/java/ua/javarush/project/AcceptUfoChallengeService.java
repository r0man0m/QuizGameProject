package ua.javarush.project;

import ua.javarush.project.answers.UFOAnswer;

import static ua.javarush.project.AppContent.STEP_1_ACCEPTED;
import static ua.javarush.project.AppContent.STEP_1_NOT_ACCEPTED;

public class AcceptUfoChallengeService {

    public UFOAnswer call(boolean isAccepted) {
        UFOAnswer answer;
        if (isAccepted) {
            answer = new UFOAnswer(STEP_1_ACCEPTED);
        } else {
            answer = new UFOAnswer(STEP_1_NOT_ACCEPTED);
        }
        return answer;
    }
}
