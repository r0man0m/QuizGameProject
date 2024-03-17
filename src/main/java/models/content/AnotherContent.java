package models.content;

import models.games.abstracts.AbstractContent;

import java.util.ArrayList;
import java.util.List;

public class AnotherContent extends AbstractContent {
    public AnotherContent() {
        List<String> pair = new ArrayList<>();
        pair.add("No content!");
        pair.add("No content!");
        getAnswers().put(0,pair);
        getQuestions().put(0,"No content!");
    }

    @Override
    public String getQuestion(Integer numberQuestion) {
        return getQuestions().get(numberQuestion);
    }

    @Override
    public List<String> getAnswer(Integer numberPairAnswers) {
        return getAnswers().get(numberPairAnswers);
    }
}
