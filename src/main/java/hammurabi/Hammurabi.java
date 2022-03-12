package hammurabi;               // package declaration
import java.util.Random;         // imports go here
import java.util.Scanner;

    public class Hammurabi {         // must save in a file named Hammurabi.java
        Random rand = new Random();  // this is an instance variable
        Scanner scanner = new Scanner(System.in);

        int year = 0;
        int starvationDeaths = 0;
        int immigrants = 5;
        int population = 100;
        int harvest = 3000;
        int acres = 1000;
        int grainEatenByRats = 200;
        int bushels = 3000;
        int newCostOfLand = 19;

        public static void main(String[] args) { // required in every Java program
            new Hammurabi().playGame();
        }


        void playGame() {
            boolean notGameOver = true;
            summary();
            while (year < 11 && notGameOver) {
                askHowManyAcresToBuy(newCostOfLand(),bushels);
            }
            if (uprising()== true){
                notGameOver = false;}
        }

//            int getNumber(String message){
//                while (true) {
//                    System.out.print(message);
//                    try {
//                        return scanner.nextInt();
//                    }
//                    catch (InputMismatchException e) {
//                        System.out.println("\"" + scanner.next() + "\" isn't a number!");
//                    }
//                }
//            }


        public void summary(){
            System.out.println("O great Hammurabi!\n" +
                "You are in year "+ year +" of your ten year rule.\n" +
                "In the previous year " + starvationDeaths + " people starved to death.\n" +
                "In the previous year "+ immigrants +" people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested "+ harvest +" bushels at " + acres/harvest + " bushels per acre.\n" +
                "Rats destroyed "+ grainEatenByRats + " bushels, leaving "+ (bushels-grainEatenByRats) +" bushels in storage.\n" +
                "The city owns "+ acres +" acres of land.\n" +
                "Land is currently worth "+ newCostOfLand +" bushels per acre.");
        }

            // declare local variables here: grain, population, etc.
            // statements go after the declations

        //other methods go here


        //Starting methods that ask for user input
        //Asks the player how many acres of land to buy, and returns that number.
        public int askHowManyAcresToBuy(int price, int bushels) {
            int acresToBuy;

            System.out.println("O Great Hammurabi, how many acres of land do you wish to buy?");
            acresToBuy = scanner.nextInt();

            if (bushels < price) {
                System.out.println("O Great Hammurabi, surely you jest! We only have" + bushels + " bushels left.");
            } else {
                return acresToBuy;
            }

            return 0;//just to get it to work DC
        }

        public int askHowManyAcresToSell(int acresOwned) {
            int acresToSell;
            System.out.println("O Great Hammurabi, how many acres of land do you wish to sell?");
            acresToSell = scanner.nextInt();

            if (acresToSell > acresOwned) {
                System.out.println("O Great Hammurabi, surely you jest! We only have" + acresOwned + " acres of land.");
            } else {
                return acresToSell;
            }
            return 0;
        }

        public int askHowMuchGrainToFeedPeople(int bushels) {
            int grainToFeed;
            System.out.println("O Great Hammurabi, how much grain do you wish to feed our people?");
            grainToFeed = scanner.nextInt();
           if (bushels < grainToFeed) {
               System.out.println("O Great Hammurabi, surely you jest! We only have" + bushels + " acres of land.");
           } else {
               return grainToFeed;
           }

           return 0; // just to get it to work DC
        }

        public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
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
        }

        public int plagueDeaths(int population){
            int plagueChance = rand.nextInt(100);
            if(plagueChance >= 1) {
                return population / 2;
            } else {
                return population;
            }
        }

        public int starvationDeaths(int population, int bushelsFedtoPeople){
            return bushelsFedtoPeople%population;
        }

        public boolean uprising(){
            double howManyPeopleStarved = 0;
            double ratio = howManyPeopleStarved/population;

            if (ratio > 45 ){
                return true;
            } else {
                return false;
            }

        }

        public int immigrants(int population, int acresOwned, int grainInStorage){
            return (20*acresOwned+grainInStorage) / (100 * population) + 1;
        }

        public int harvest(int acres, int bushelsUsedAsSeed){
            int ranNum = rand.nextInt(1, 6);

            if ( acres > bushelsUsedAsSeed){            //If more acres than bushelsUsedAsSeed
                return ranNum*bushelsUsedAsSeed;
            } else {                                    //vice-versa
                return ranNum*acres;
            }
        }

        public int grainEatenByRats(int bushels){
            int ranNum = rand.nextInt(0, 100);
            if (ranNum >= 40){
                return rand.nextInt(10, 30) * bushels;
            }else{
                return bushels;
            }
        }

        public int newCostOfLand(){
            return rand.nextInt(17, 23);
        }
    }
