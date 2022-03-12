package hammurabi;               // package declaration
import java.util.Random;         // imports go here
import java.util.Scanner;

    public class Hammurabi {         // must save in a file named Hammurabi.java
        Random rand = new Random();  // this is an instance variable
        Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) { // required in every Java program
            new Hammurabi().playGame();
        }


        void playGame() {
            int year = 0;
            int starvationDeaths = 0;
            int immigrants = 5;
            int population = 100;
            int harvest = 3000;
            int acres = 1000;
            int grainEatenByRats = 200;
            int bushel = 3000;
            int newCostOfLand = 19;

        for (int i = 1 ; i < 11; i++){
            year+=1;
            System.out.println("O great Hammurabi!\n" +
                "You are in year "+ year +" of your ten year rule.\n" +
                "In the previous year " + starvationDeaths + " people starved to death.\n" +
                "In the previous year "+ immigrants +" people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested "+ harvest +" bushels at " + acres/harvest + " bushels per acre.\n" +
                "Rats destroyed "+ grainEatenByRats + " bushels, leaving "+ (bushel-grainEatenByRats) +" bushels in storage.\n" +
                "The city owns "+ acres +" acres of land.\n" +
                "Land is currently worth "+ newCostOfLand +" bushels per acre.");
        }

            // declare local variables here: grain, population, etc.
            // statements go after the declations
        }

        //other methods go here


        //Starting methods that ask for user input
        //Asks the player how many acres of land to buy, and returns that number.
        public int askHowManyAcresToBuy(int price, int bushels) {
            int acresToBuy;
            System.out.println("O Great Hammurabi, how many acres of land do you wish to buy?")

            if (bushels > price) {
                return acresToBuy
            } else {
                System.out.println("You do not have enough bushels to buy this land! You have ")
            }
        }

        public int askHowManyAcresToSell(int acresOwned) {
            int acresToSell;
            System.out.println("O Great Hammurabi, how many acres of land do you wish to sell?")

            if (acresToSell > acresOwned) {
                System.out.println("You do not have enough acres of land to sell!")
            } else {
                return acresToSell;
            }
            return acresToSell;
        }

        public int askHowMuchGrainToFeedPeople(int bushels) {
            int grainToFeed;
            System.out.println("O Great Hammurabi, how much grain do you wish to feed our people?")

           if (bushels < grainToFeed) {
               System.out.println("You do not have that many bushels left!");
           } else {
               return grainToFeed;
           }
        }

        public int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
            int acresToPlant;
            System.out.println("O Great Hammurabi, how many acres of land do you wish to plant?")
            if (acresOwned < bushels) {
                System.out.println("You do not have enough acres of land to plant!");
            } else if (bushels > acresOwned * 2) { //2 bushels per acre of land. Ensure there are enough bushels
                return acresToPlant;
            } else if (acresToPlant > population * 10) {
                return acresToPlant;
            }
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
            return bushelsFedtoPeople%%population;
        }

        public boolen uprising(int population, int howManyPeopleStarved){
            double ratio = howManyPeopleStarved/population;

            if (ratio > 45 ){
                return true;
            } else {
                return false;
            }

        }

        public int immigrants(int population, int acresOwned, int grainInStorage){
            return hold = (20*acresOwned+grainInStorage) / (100 * population) + 1;
        }

        public int harvest(int acres, int bushelsUsedAsSeed){
            int ranNum = rand.nextInt(1, 6);

            if ( acres > bushelsUsedAsSeed){            //If more acres than bushelsUsedAsSeed
                return ranNum*bushelsUsedAsSeed;
            } else if ( acres < bushelsUsedAsSeed){     //vice-versa
                return ranNum*acres
            }
        }

        public int grainEatenByRats(int bushels){
            int ranNum = rand.nextInt(0, 100);
            if (ranNum >= 40){
                return rand.nextInt(10, 30) * bushels;
            }else{
                return boolean;
            }
        }

        public int newCostOfLand(){
            return ranNum = rand.nextInt(17, 23);
        }
    }
}