package com.quizgame.interfaces;

import java.util.List;
import java.util.Map;

public interface Content {

    Map<Integer, String> getQuestions();

    Map<Integer, List<String>> getAnswers();

    Map<Integer, String> getDefeatMessages();

    String getQuestion(int numberQuestion);

    List<String> getAnswer(int numberPairAnswers);
}
