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
    }