/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

/**
 *
 * @author boonjv
 */
public class HealthyMealBuilder extends MealBuilder {
    //add code here
    @Override
    public void buildEntree() {
        theMeal.setEntree("Chicken Sandwich");
    }

    @Override
    public void buildSide() {
        theMeal.setSide("Carrot Sticks");
    }

    @Override
    public void buildDrink() {
        theMeal.setDrink("Diet Cola");
    }
}
