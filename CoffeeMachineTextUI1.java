import java.util.Scanner;

public class CoffeeMachineTextUI extends CoffeeMachine{
    private static final Scanner scanner = new Scanner(System.in);

    CoffeeMachineTextUI(int water, int milk, int beans, int cups, int cash) {
        super(water, milk, beans, cups, cash);
    }

    public void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int price) {
        if (canMakeCoffee(waterNeeded, milkNeeded, beansNeeded)) {
            System.out.println("I have enough resources, making you a coffee!");
            useRawMaterials(waterNeeded, milkNeeded, beansNeeded, price);
        } else {
            StringBuilder sb = notEnough(waterNeeded, milkNeeded, beansNeeded);
            System.out.printf("Sorry, not enough %s!\n", sb.toString());
        }
    }

    public void makeEspresso() {
        makeCoffee(getESPRESSO_WATER_ML_PER_CUP(),
                getESPRESSO_MILK_ML_PER_CUP(),
                getESPRESSO_BEANS_G_PER_CUP(),
                getESPRESSO_PRICE());
    }

    public void makeLatte() {
        makeCoffee(getLATTE_WATER_ML_PER_CUP(),
                getLATTE_MILK_ML_PER_CUP(),
                getLATTE_BEANS_G_PER_CUP(),
                getLATTE_PRICE());
    }

    public void makeCappuccino() {
        makeCoffee(getCAPPUCCINO_WATER_ML_PER_CUP(),
                getCAPPUCCINO_MILK_ML_PER_CUP(),
                getCAPPUCCINO_BEANS_G_PER_CUP(),
                getCAPPUCCINO_PRICE());
    }

    public void doBuyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String option = scanner.next();
        if (option.equals("back")) {
            // go back to main
        } else {
            int coffeeType = Integer.parseInt(option);
            Coffee coffee = Coffee.values()[coffeeType - 1];

            switch (coffee) {
                case ESPRESSO -> makeEspresso();
                case LATTE -> makeLatte();
                case CAPPUCCINO -> makeCappuccino();
                default -> {
                }
                // do nothing
            }
        }
    }
    public void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", getWater());
        System.out.printf("%d ml of milk\n", getMilk());
        System.out.printf("%d g of coffee beans%n", getBeans());
        System.out.printf("%d disposable cups%n", getCups());
        System.out.printf("$%d of money%n", getCash());
    }

    public void doTakeMoney() {
        System.out.println("I gave you $" + getCash());
        setCash(0);
    }
    public void doFilling() {
        System.out.println("Write how many ml of water you want to add:");
        int addedWater = scanner.nextInt();
        doFillingAddedWater(addedWater);

        System.out.println("Write how many ml of milk you want to add:");
        int addedMilk = scanner.nextInt();
        doFillingAddedMilk(addedMilk);

        System.out.println("Write how many grams of coffee beans you want to add:");
        int addedBeans = scanner.nextInt();
        doFillingAddedBeans(addedBeans);

        System.out.println("Write how many disposable cups you want to add:");
        int addedCups = scanner.nextInt();
        doFillingAddedCups(addedCups);
    }
    public boolean execute(String action) {
        boolean done = false;
        switch (action) {
            case "buy" -> doBuyCoffee();
            case "fill" -> doFilling();
            case "take" -> doTakeMoney();
            case "remaining" -> printState();
            case "exit" -> {
                done = true;
            }
            default -> {
            }
            // do nothing
        }
        return done;
    }

    public static void main(String[] args) {
        CoffeeMachineTextUI machine = new CoffeeMachineTextUI(400, 540, 120, 9, 550);
        boolean done = false;
        do {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            done = machine.execute(action);
        } while (!done);
    }
}
