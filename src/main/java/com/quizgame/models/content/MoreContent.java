package com.quizgame.models.content;

import com.quizgame.models.games.abstracts.AbstractContent;

import java.util.ArrayList;
import java.util.List;

public class MoreContent extends AbstractContent {
    public MoreContent() {
        List<String> pair = new ArrayList<>();
        pair.add("No content!");
        pair.add("No content!");
        getAnswers().put(0, pair);
        getQuestions().put(0, "No content!");
    }

    @Override
    public String getQuestion(int numberQuestion) {
        return getQuestions().get(numberQuestion);
    }

    @Override
    public List<String> getAnswer(int numberPairAnswers) {
        return getAnswers().get(numberPairAnswers);
    }
}
