package org.velezreyes.quiz.question6;

public class ScottCola implements Drink {
    @Override
    public String getName() {
        return "ScottCola";
    }

    @Override
    public boolean isFizzy() {
        return true;
    }

    public int getCost() {
        return 75; // ScottCola cuesta 75 centavos.
    }
    
}
