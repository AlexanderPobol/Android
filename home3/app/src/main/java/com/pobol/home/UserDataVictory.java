package com.pobol.home;

public class UserDataVictory {
    private VictorCategory.Categories category;
    private Answer answer;
    public enum Answer {YES, NO, NO_ANSWER}

    public UserDataVictory(VictorCategory.Categories category, Answer answer) {
        this.category = category;
        this.answer = answer;
        this.answer=answer;
    }

    public VictorCategory.Categories getCategory() {
        return category;
    }

    public void setCategory(VictorCategory.Categories category) {
        this.category = category;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
