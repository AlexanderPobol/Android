package com.pobol.home;


public class VictorCategory {

    public Categories category;

    public enum Categories {
        FRUIT(R.array.questions_fruit, R.array.answers_fruit, R.drawable.ic_1_fruit),
        FASHION(R.array.questions_fash, R.array.answers_fash, R.drawable.ic_2_fashion),
        FOOTBALL(R.array.questions_foot, R.array.answers_foot, R.drawable.ic_3_football),
        GEOGRAPHY(R.array.questions_geo, R.array.answers_geo, R.drawable.ic_4_geo),
        ANIMAL(R.array.questions_animals, R.array.answers_animals, R.drawable.ic_5_animal),
        MATH(R.array.questions_math, R.array.answers_math, R.drawable.ic_6_math),
        SPORT(R.array.questions_sport, R.array.answers_sport, R.drawable.ic_7_sport),
        ANATOMY(R.array.questions_anatomy, R.array.answers_anatomy, R.drawable.ic_8_anatomy),
        MONEY(R.array.questions_money, R.array.answers_money, R.drawable.ic_9_money),
        AUTO(R.array.questions_auto, R.array.answers_auto, R.drawable.ic_10_auto),
        CITY(R.array.questions_city, R.array.answers_city, R.drawable.ic_11_city),
        SWEETS(R.array.questions_sweets, R.array.answers_sweets, R.drawable.ic_12_cake),
        HISTORY(R.array.questions_history, R.array.answers_history, R.drawable.ic_13_history),
        ASTRONOMY(R.array.questions_astronomy, R.array.answers_astronomy, R.drawable.ic_14_astro),
        PHYSICS(R.array.questions_physics, R.array.answers_physics, R.drawable.ic_15_physic),
        TECHNOLOGY(R.array.questions_technology, R.array.answers_technology, R.drawable.ic_16_technology);

        public int questionsXML;
        public int answerXML;
        public int imageXML;

        private Categories(int questionsXML, int answerXML, int imageXML) {
            this.questionsXML = questionsXML;
            this.answerXML = answerXML;
            this.imageXML = imageXML;
        }

        private Categories() {
        }
    }

    public VictorCategory(Categories category) {

        this.category = category;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "category=" + category;
    }
}
