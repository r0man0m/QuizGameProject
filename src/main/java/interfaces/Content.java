package interfaces;

import java.util.List;
import java.util.Map;

public interface Content {

    Map<Integer, String>getQuestions();
    Map<Integer, List<String>>getAnswers();
     Map<Integer, String> getDefeatMessages();
    public String getQuestion(Integer numberQuestion);
    public List<String> getAnswer(Integer numberPairAnswers);
}
