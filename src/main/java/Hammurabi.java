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
            int year = 1;
            int starvationDeath = 0;
            int immigrants = 5;
            int population = 100;
            int harvest = 3000;
            int acres = 1000;
            int grainEatenByRats = 200;
            int bushel = 3000;
            int newCostOfLand = 19;

            System.out.println("O great Hammurabi!\n" +
                "You are in year "+ year +" of your ten year rule.\n" +
                "In the previous year " + starvationDeaths + " people starved to death.\n" +
                "In the previous year "+ immigrants +" people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested "+ harvest +" bushels at " + acres/harvest + " bushels per acre.\n" +
                "Rats destroyed "+ grainEatenByRats + " bushels, leaving "+ (bushel-grainEatenByRats) +" bushels in storage.\n" +
                "The city owns "+ acres +" acres of land.\n" +
                "Land is currently worth "+ newCostOfLand +" bushels per acre.");

            // declare local variables here: grain, population, etc.
            // statements go after the declations
        }

        //other methods go here



        //Part two methods

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



    }