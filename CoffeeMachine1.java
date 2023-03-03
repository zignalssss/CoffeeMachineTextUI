import java.util.Scanner;


public class CoffeeMachine {
    enum Coffee { ESPRESSO, LATTE, CAPPUCCINO }
    static final int ESPRESSO_WATER_ML_PER_CUP = 250;
    static final int ESPRESSO_MILK_ML_PER_CUP = 0;
    static final int ESPRESSO_BEANS_G_PER_CUP = 16;
    static final int ESPRESSO_PRICE = 4;
    static final int LATTE_WATER_ML_PER_CUP = 350;
    static final int LATTE_MILK_ML_PER_CUP = 75;
    static final int LATTE_BEANS_G_PER_CUP = 20;
    static final int LATTE_PRICE = 7;
    static final int CAPPUCCINO_WATER_ML_PER_CUP = 200;
    static final int CAPPUCCINO_MILK_ML_PER_CUP = 100;
    static final int CAPPUCCINO_BEANS_G_PER_CUP = 12;
    static final int CAPPUCCINO_PRICE = 6;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int cash;
    private static final Scanner scanner = new Scanner(System.in);
    
    CoffeeMachine(int water, int milk, int beans, int cups, int cash) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.cash = cash;
    }

    boolean canMakeCoffee(int waterNeeded, int milkNeeded, int beansNeeded) {
        return water >= waterNeeded &&
                milk >= milkNeeded &&
                beans >= beansNeeded &&
                cups >= 1;
    }

    public void useRawMaterials(int waterNeeded, int milkNeeded, int beansNeeded, int price){
        this.water -= waterNeeded;
        this.milk -= milkNeeded;
        this.beans -= beansNeeded;
        this.cups--;
        this.cash += price;
    }

    public StringBuilder notEnough(int waterNeeded, int milkNeeded, int beansNeeded){
        StringBuilder sb = new StringBuilder();
        if (water < waterNeeded) {
            sb.append("water");
        } else if (milk < milkNeeded) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("milk");
        } else if (beans < beansNeeded) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("coffee beans");
        } else if (cups == 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("disposable cups");
        }
        return sb;
    }

    public int getESPRESSO_WATER_ML_PER_CUP(){
        return this.ESPRESSO_WATER_ML_PER_CUP;
    }

    public int getESPRESSO_MILK_ML_PER_CUP(){
        return this.ESPRESSO_MILK_ML_PER_CUP;
    }

    public int getESPRESSO_BEANS_G_PER_CUP(){
        return this.ESPRESSO_BEANS_G_PER_CUP;
    }

    public int getESPRESSO_PRICE(){
        return this.ESPRESSO_PRICE;
    }

    public int getLATTE_WATER_ML_PER_CUP(){
        return this.LATTE_WATER_ML_PER_CUP;
    }

    public int getLATTE_MILK_ML_PER_CUP(){
        return this.LATTE_MILK_ML_PER_CUP;
    }

    public int getLATTE_BEANS_G_PER_CUP(){
        return this.LATTE_BEANS_G_PER_CUP;
    }

    public int getLATTE_PRICE(){
        return this.LATTE_PRICE;
    }

    public int getCAPPUCCINO_WATER_ML_PER_CUP(){
        return this.CAPPUCCINO_WATER_ML_PER_CUP;
    }

    public int getCAPPUCCINO_MILK_ML_PER_CUP(){
        return this.CAPPUCCINO_MILK_ML_PER_CUP;
    }

    public int getCAPPUCCINO_BEANS_G_PER_CUP(){
        return this.CAPPUCCINO_BEANS_G_PER_CUP;
    }

    public int getCAPPUCCINO_PRICE(){
        return this.CAPPUCCINO_PRICE;
    }


    public int getWater(){
        return this.water;
    }

    public int getMilk(){
        return this.milk;
    }

    public int getBeans(){
        return this.beans;
    }

    public int getCups(){
        return this.cups;
    }

    public int getCash(){
        return this.cash;
    }

    public void setWater(int water){
        this.water = water;
    }

    public void setMilk(int milk){
       this.milk = milk;
    }

    public void setBeans(int beans){
       this.beans = beans;
    }

    public void setCups(int cups){
       this.cups = cups;
    }

    public void setCash(int cash){
       this.cash = cash;
    }

    public void doFillingAddedWater(int addedWater){
        water += addedWater;
    }

    public void doFillingAddedMilk(int addedMilk){
        milk += addedMilk;
    }

    public void doFillingAddedBeans(int addedBeans){
        beans += addedBeans;
    }

    public void doFillingAddedCups(int addedCups){
        cups += addedCups;
    }

}

