package com.quizgame.models.games.abstracts;

import com.quizgame.interfaces.Content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractContent implements Content {
    private final Map<Integer, String> questions = new HashMap<>();
    private final Map<Integer, List<String>> pairAnswers = new HashMap<>();
    private final Map<Integer, String> defeatMessages = new HashMap<>();

    @Override
    public Map<Integer, String> getQuestions() {
        return questions;
    }

    @Override
    public Map<Integer, List<String>> getAnswers() {
        return pairAnswers;
    }

    @Override
    public Map<Integer, String> getDefeatMessages() {
        return defeatMessages;
    }

    public List<String> getPairAnswers(Integer numberPairAnswers) {
        return getAnswers().get(numberPairAnswers);
    }

}
