package com.quizgame.models.content;

import com.quizgame.models.games.abstracts.AbstractContent;

import java.util.ArrayList;
import java.util.List;

public class UfoContent extends AbstractContent {

    public UfoContent() {
        List<String> pair = new ArrayList<>();
        getQuestions().put(0, "Ви втрачаєте пам'ять, прийняти виклик НЛО?");
        getQuestions().put(1, "Ви прийняли виклик. Піднятися на капітанський місток?");
        getQuestions().put(2, "Ви піднялися на місток. Хто ви?");
        getQuestions().put(3, "Вас повернули додому. Перемога!");
        pair.add("Прийняти виклик");
        pair.add("Відхилити виклик");
        getAnswers().put(0, pair);
        pair = new ArrayList<>();
        pair.add("Піднятися на місток");
        pair.add("Відмовитися підніматися на місток");
        getAnswers().put(1, pair);
        pair = new ArrayList<>();
        pair.add("Розповісти всю правду про себе");
        pair.add("Збрехати просебе");
        getAnswers().put(2, pair);
        getDefeatMessages().put(0, "Ви відхилили виклик. Поразка");
        getDefeatMessages().put(1, "Ви не пійшли на переговори. Поразка");
        getDefeatMessages().put(2, "Ваша брехня була викрита. Поразка");
    }

    @Override
    public String getQuestion(int numberQuestion) {
        return getQuestions().get(numberQuestion);
    }

    @Override
    public List<String> getAnswer(int numberPairAnswers) {
        return getPairAnswers(numberPairAnswers);
    }


}
