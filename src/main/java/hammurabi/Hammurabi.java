package hammurabi;               // package declaration
import java.util.InputMismatchException;
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
            boolean GameOver = false;
            summary();
            while (year < 11 && !GameOver) {  //(year < 11 && !GameOver)
                bushels -= askHowMuchGrainToFeedPeople(bushels);
                //askHowManyAcresToBuy(newCostOfLand(), bushels);


                if (uprising(population, starvationDeaths) == true) {
                    GameOver = true;
                }
                year++;
                summary();
            }
        }

            int getNumber(String message){
                while (true) {
                    System.out.print(message);
                    try {
                        return scanner.nextInt();
                    }
                    catch (InputMismatchException e) {
                        System.out.println("\"" + scanner.next() + "\" isn't a number!");
                    }
                }
            }


        public void summary(){
            System.out.println("O great Hammurabi!\n" +
                "You are in year "+ year +" of your ten year rule.\n" +
                "In the previous year " + starvationDeaths + " people starved to death.\n" +
                "In the previous year "+ immigrants +" people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested "+ harvest +" bushels at " + (harvest/acres) + " bushels per acre.\n" +
                "Rats destroyed "+ grainEatenByRats + " bushels, leaving "+ (bushels-grainEatenByRats) +" bushels in storage.\n" +
                "The city owns "+ acres +" acres of land.\n" +
                "Land is currently worth "+ newCostOfLand +" bushels per acre.");
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
            int acresToBuy;

            String message = ("O Great Hammurabi, how many acres of land do you wish to buy?");
            acresToBuy = getNumber(message);

            if (bushels < price) {
                System.out.println("O Great Hammurabi, surely you jest! We only have" + bushels + " bushels left.");
            } else {
                return acresToBuy;
            }

            return 0;//just to get it to work DC
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
            System.out.println("O Great Hammurabi, how many acres of land do you wish to sell?");
            return sanityCheck("acres", acresOwned, 0);
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
            System.out.println("O Great Hammurabi, how much grain do you wish to feed our people?");
            return sanityCheck("bushels", bushels, 0);
        }

        public int sanityCheck(String resource, int resAmnt, int resDmnd){
            boolean sane = false;
            String message = ("O Great Hammurabi, how much " + resource + " do you wish to feed our people? We have " + resAmnt+". \n");
            int userInput;
            while(!sane){
                userInput = getNumber(message);
                if(resAmnt > userInput){
                    sane = true;
                    return userInput;
                }
                System.out.println("O Great Hammurabi, surely you jest! We only have " + resAmnt + " " + resource);
            }
            return 0;
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

        //public int playerChoices (int )


        //The methods for random events!
        public int plagueDeaths(int population){
            int plagueChance = rand.nextInt(100);
            if(plagueChance >= 15) {
                System.out.println("O Great Hammurabi, we've experienced a plague! Half the population has died!");
                return population / 2;
            } else {
                System.out.println("O Great Hammurabi, another year without the plague!");
                return population;
            }
        }

        public int starvationDeaths(int population, int bushelsFedtoPeople){

            if(bushelsFedtoPeople%population != 0){
                System.out.println("O Great Hammurabi! Sad news! We have lost " + bushelsFedtoPeople%population + " due to starvation!");
                return bushelsFedtoPeople%population;
            } else {
                System.out.println("O Great Hammurabi! Huzzah, no one has died from starvation!");
                return bushelsFedtoPeople%population;
            }
        }

        public boolean uprising(int population, int howManyPeopleStarved){
            double ratio = howManyPeopleStarved/population;
            if (ratio > 0.45 ){
                return true;
            } else {
                return false;
            }
        }

        public int immigrants(int population, int acresOwned, int grainInStorage){
            int newComers = (20*acresOwned+grainInStorage) / (100 * population) + 1;

            if (newComers > 0) {
                //System.out.println("Oh Great Hammurabi! Huzzah, we have " + newComers + " new immigrants!");
                return newComers;
            }
            else {
                //System.out.println("Oh Great Hammurabi! We have no new immigrants.");
                return 0;
            }
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
                int grainEatenByRats = rand.nextInt(10, 30)*bushels;
                //System.out.println("Infestation! Rats have eaten " + grainEatenByRats + " bushels!");
                return rand.nextInt(10, 30) * bushels;
            }else{
                return 0;
            }
        }

        public int newCostOfLand(){
            int costOfLand = rand.nextInt(17, 23);
            //System.out.println("The cost of land is now " + costOfLand + " bushels per acre");
            return costOfLand;
        }
    }
