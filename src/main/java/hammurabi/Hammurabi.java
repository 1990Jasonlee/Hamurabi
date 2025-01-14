package hammurabi;               // package declaration
import java.util.InputMismatchException;
import java.util.Random;         // imports go here
import java.util.Scanner;

    public class Hammurabi {         // must save in a file named Hammurabi.java
        Random rand = new Random();  // this is an instance variable
        Scanner scanner = new Scanner(System.in);

        int year = 1;
        int starvationDeaths = 0;
        int immigrants = 5;
        int population = 100;
        int harvest = 3000;
        int acres = 1000;
        int grainEatenByRats = 200;
        int bushels = 2800;
        int newCostOfLand = 19;
        int acresToBuy = 0;


        //New variables

        int bushelsSpent;
        int buyOrSell;
        int acresSold;
        int bushelsToFeed;
        int acresPlanted;
        int plagueBodies;
        int bushelsForPlanting;
        int harvestRatio = 3;
        int immigrantsSum = 5;

        public static void main(String[] args) { // required in every Java program
            new Hammurabi().playGame();
        }

        void playGame() {
            boolean GameOver = false;
            summary();

            while (year < 10 && !GameOver) {


                System.out.println("O Great Hammurabi! It is a new year!\n" +
                        "Would you like to buy or sell land?");

                while (true) {
                    buyOrSell = getNumber("Enter 1 to Buy \nEnter 2 to Sell\n");
                    if (buyOrSell == 1) {
                        bushelsSpent = askHowManyAcresToBuy(newCostOfLand, bushels);
                        acres = acres + (bushels - bushelsSpent) / newCostOfLand;
                        bushels = bushelsSpent;
                        break;
                    } else if (buyOrSell == 2) {
                        acresSold = askHowManyAcresToSell(acres);
                        acres -= acresSold;
                        bushels += acresSold * newCostOfLand;
                        break;
                    } else {
                        System.out.println("Apologies Great Hammurabi, I did not understand you!\n" +
                                "Would you like to buy or sell land?\n");
                    }
                }

                bushelsToFeed = askHowMuchGrainToFeedPeople(bushels);
                System.out.println(bushelsToFeed);
                bushels -= bushelsToFeed;

                acresPlanted = askHowManyAcresToPlant(acres, population, bushels);
                bushelsForPlanting = acresPlanted * 2;
                bushels -= bushelsForPlanting;

                plagueBodies = plagueDeaths(population);        //Supposed to be elsewhere, not in the if statement


                starvationDeaths = starvationDeaths(population, bushelsToFeed);
                if (uprising(population, starvationDeaths) == true) {
//                System.out.println("O great Hammurabi! The population has deemed you unfit for rule! You must Flee! \n" +
//                                "\n Game Over");
                    GameOver = true;
                    break;
                }

                if (starvationDeaths == 0) {
                    immigrants = immigrants(population, acres, bushels);
                    immigrantsSum += immigrants;
                    population += immigrants;
                } else {
                    immigrants = 0;
                }

                population -= starvationDeaths;
                population -= plagueBodies;

                harvest = harvest(acresPlanted);
                bushels += harvest;

                if (acresPlanted == 0){
                    harvestRatio = 0;
                } else {
                    harvestRatio = harvest/acresPlanted;
                }


                grainEatenByRats = grainEatenByRats(bushels);
                bushels -= grainEatenByRats;

                newCostOfLand = newCostOfLand();

                if(year == 10){
                    newCostOfLand();
                    grainEatenByRats(bushels);
                    summary();
                    break;
                }
                year++;

                newCostOfLand();
                grainEatenByRats(bushels);

                summary();
            }
            finalSummary();
            //Add a new gameOver here

        }

        int getNumber(String message) {
            while (true) {
                System.out.print(message);
                try {
                    return scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\"" + scanner.next() + "\" isn't a number!\n");
                }
            }
        }

        public void summary() {
            System.out.println("O great Hammurabi!\n" +
                    "You are in year " + year + " of your ten year rule.\n" +
                    "In the previous year " + starvationDeaths + " people starved to death.\n" +
                    "In the previous year " + immigrants + " people entered the kingdom.\n" +
                    "The population is now " + population + ".\n" +
                    "We harvested " + harvest + " bushels at " + (harvestRatio) + " bushels per acre.\n" +
                    "Rats destroyed " + grainEatenByRats + " bushels, leaving " + (bushels - grainEatenByRats) + " bushels in storage.\n" +
                    "The city owns " + acres + " acres of land.\n" +
                    "Land is currently worth " + newCostOfLand + " bushels per acre.\n" +
                    "-----------------------------------------------------\n");
        }

        public void finalSummary() {
            if (uprising(population,starvationDeaths)) {
                System.out.println("O Hammurabi!\n" +
                        "In only year " + year + " of your rule,\n" +
                        "you have created a disaster, you have been overthrown as ruler.\n" +
                        "GAME OVER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }else
            System.out.println("O great Hammurabi!\n" +
                    "In your " + year + " year rule, " + immigrantsSum + " people entered the kingdom.\n" +
                    "The city owns " + acres + " acres of land.\n" +
                    "Congratulations on your retirement");
        }
        // declare local variables here: grain, population, etc.
        // statements go after the declations

        //other methods go here


        //Starting methods that ask for user input
        //Asks the player how many acres of land to buy, and returns that number.
/*        public int askHowManyAcresToBuy(int price, int bushels) {
            int acresToBuy;

            String message = ("O Great Hammurabi, how many acres of land do you wish to buy?");
            acresToBuy = getNumber(message);

            if (bushels < price) {
                System.out.println("O Great Hammurabi, surely you jest! We only have" + bushels + " bushels left.");
            } else {
                return acresToBuy;
            }

            return 0;//just to get it to work DC
        }*/

        public int askHowManyAcresToBuy(int price, int bushels) {
            boolean start = true;

            while (start = true) {
                System.out.println("O Great Hammurabi, how many acres of land do you wish to buy?\n");
                acresToBuy = scanner.nextInt();
                price = newCostOfLand * acresToBuy;
                if (bushels > price) {
                    bushels -= price;
                    System.out.println("Total price cost " + price + " bushels.");
                    System.out.println("You have " + bushels + " bushels.\n");
                    return bushels;
                } else {
                    System.out.println("O Great Hammurabi, surely you jest! " +
                            "We only have " + bushels + " bushels left. That would cost " + price + " bushels.\n");
                }
            }
            return bushels;
        }

/*        public int askHowManyAcresToSell(int acresOwned) {
            int acresToSell;
            System.out.println("O Great Hammurabi, how many acres of land do you wish to sell?");
            acresToSell = scanner.nextInt();

            if (acresToSell > acresOwned) {
                System.out.println("O Great Hammurabi, surely you jest! We only have" + acresOwned + " acres of land.");
            } else {
                return acresToSell;
            }
            return 0;
        }*/

        public int askHowManyAcresToSell(int acresOwned) {
            //System.out.println("O Great Hammurabi, how many acres of land do you wish to sell?");
            String message = "O Great Hammurabi, how many acres of land do you wish to sell?\n";
            return sanityCheck("acres", message, acresOwned, 0);
        }

/*        public int askHowMuchGrainToFeedPeople(int bushels) {
            int grainToFeed;
            System.out.println("O Great Hammurabi, how much grain do you wish to feed our people?");
            grainToFeed = scanner.nextInt();
           if (bushels < grainToFeed) {
               System.out.println("O Great Hammurabi, surely you jest! We only have" + bushels + " acres of land.");
           } else {
               return grainToFeed;
           }
           return 0; // just to get it to work DC
        }*/

        public int askHowMuchGrainToFeedPeople(int bushels) {
            //System.out.println("O Great Hammurabi, how much grain do you wish to feed our people?");

            String message = "O Great Hammurabi, how much grain do you wish to feed our people?\n";
            return sanityCheck("bushels", message, bushels, 0);
        }

        public int sanityCheck(String resource, String message, int posAmnt, int resDmnd) {

            boolean sane = false;
            //String message = ("O Great Hammurabi, how much " + resource + " do you wish to spend? We have " + resAmnt + " " + resource);
            int userInput;
            while (!sane) {
                userInput = getNumber(message);
                if (posAmnt >= userInput && userInput >= 0) {
                    sane = true;
                    return userInput;
                }
                System.out.println("O Great Hammurabi, surely you jest!" + posAmnt + " is the limit!" + "\n"
                        + "Current resources\n -----------\n" + "Population     " + population + "\n" +
                        "Bushels        " + bushels + "\n" + "Acres          " + acres + "\n" +
                        "Price of of land is currently " + newCostOfLand + " bushels");
            }
            return 0;
        }
/*                System.out.println("O Great Hammurabi, surely you jest! We only have " + posAmnt + " " + resource + "\n"
                +"Current resources\n -----------\n" + "Population     " + population + "\n" +
                "Bushels        " + bushels + "\n" + "Acres          " + acres);*/


 /*       public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
            int acresToPlant;
            System.out.println("O Great Hammurabi, surely you jest! We only have" + acresOwned + " acres of land.");
            acresToPlant = scanner.nextInt();

            if (acresOwned < acresToPlant) {
                System.out.println("O Great Hammurabi, surely you jest! We only have" + acresOwned + " acres of land.");
            } else if (bushels > acresOwned * 2) { //2 bushels per acre of land. Ensure there are enough bushels
                return acresToPlant;
            } else if (acresToPlant > population * 10) {
                return acresToPlant;
            }

            return 0;   //just to get it to work DC
        }*/

/*        public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
            int acresToPlant;
            //2 bushels of grain for 1 acre of land
            //1 person can farm 10 acres of land
            int popPossible = acresOwned/10;
            int bushPossible = bushels/2;
            int possiblePlant;
            boolean sane = false;
            if (popPossible < bushPossible && popPossible < acresOwned){
                possiblePlant = popPossible;
            } else if (bushPossible < popPossible && bushPossible < acresOwned){
                possiblePlant = bushPossible;
            } else {
                possiblePlant = acresOwned;
            }
            System.out.println("O Great Hammurabi, surely you jest! We only have" + acresOwned + " acres of land.");
            acresToPlant = scanner.nextInt();
            while(!sane){
                if (possiblePlant < acresToPlant) {
                    System.out.println("O Great Hammurabi, surely you jest! We only have" + acresOwned + " acres of land.");
                } else if (bushels > acresOwned * 2) { //2 bushels per acre of land. Ensure there are enough bushels
                    return acresToPlant;
                } else if (acresToPlant > population * 10) {
                    return acresToPlant;
                }
            }


            return 0;   //just to get it to work DC
        }*/

        public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {

            int popPossible = acresOwned / 10;
            int bushPossible = bushels / 2;
            int possiblePlant;


            if (population < popPossible) {
                popPossible = population * 10;
            }

            //Following code decides the possible limit based on lowest resource.
            if (popPossible < bushPossible && popPossible < acresOwned) {
                possiblePlant = popPossible;
            } else if (bushPossible < popPossible && bushPossible < acresOwned) {
                possiblePlant = bushPossible;
            } else {
                possiblePlant = acresOwned;
            }
            String message = "O Great Hammurabi! How much acres would you like to plant? \n" +

                    "The limit is " + possiblePlant + ".\n";
            return sanityCheck("Acres", message, possiblePlant, 0);

        }
        //public int playerChoices (int )


        //The methods for random events!
        public int plagueDeaths(int population) {
            int plagueChance = rand.nextInt(100);
            if (plagueChance <= 15) {
                System.out.println("O Great Hammurabi, we've experienced a plague! Half the population has died!");
                return population / 2;
            } else {
                //System.out.println("O Great Hammurabi, another year without the plague!");
                return 0;
            }
        }

        public int starvationDeaths(int population, int bushelsFedtoPeople) {

            if ((bushelsFedtoPeople / 20) < population) {
                System.out.println("O Great Hammurabi! Sad news! We have lost " + (population - (bushelsFedtoPeople / 20)) + " subjects due to starvation!");
                return population - (bushelsFedtoPeople / 20);
            } else {
                System.out.println("O Great Hammurabi! Huzzah, no one has died from starvation!");
                return 0;
            }
        }

        public boolean uprising(int population, int howManyPeopleStarved) {

            double ratio = (double) howManyPeopleStarved / (double) population;
            if (ratio > 0.45) {
                return true;
            } else {
                return false;
            }
        }

        public int immigrants(int population, int acresOwned, int grainInStorage) {
            int newComers = (20 * acresOwned + grainInStorage) / (100 * population)+1;

            if (newComers > 0) {
                //System.out.println("Oh Great Hammurabi! Huzzah, we have " + newComers + " new immigrants!");
                return newComers;
            } else {
                //System.out.println("Oh Great Hammurabi! We have no new immigrants.");
                return 0;
            }
        }

        public int harvest(int acresPlanted) {
            int ranNum = rand.nextInt(1, 7);

            harvest = ranNum * acresPlanted;
            return harvest;
    }

    public int grainEatenByRats(int bushels){
        int ranNum = rand.nextInt(0, 100);

        if (ranNum <= 40){
            int EatenByRats = (rand.nextInt(10, 31)*bushels)/100;
            //System.out.println("Infestation! Rats have eaten " + grainEatenByRats + " bushels!");
            bushels -= EatenByRats;
            grainEatenByRats = EatenByRats;
            return grainEatenByRats;

        }else{
            grainEatenByRats = 0;
            return grainEatenByRats;
        }
    }

    public int newCostOfLand(){
        int costOfLand = rand.nextInt(17, 23);
        //System.out.println("The cost of land is now " + costOfLand + " bushels per acre");
        newCostOfLand = costOfLand;
        return newCostOfLand;
    }
}
