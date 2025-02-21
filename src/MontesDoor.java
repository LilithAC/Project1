import java.util.ArrayList;
import java.util.Random;

public class MontesDoor {
    /**
     Have it play this game 10,000 times and not change the door it picked.
     Have it play this game 10,000 times and change the door it picks every time.

     ´Notes:
     ´No scanner, have the game handle everything. ✓
     ´The percentage % is number of wins over total number of trials (10,000)
     ´Program this using Door Objects.  Ie. One of the classes is Door.
     ´Make number of trials configurable. ✓
     ´Answer questions a and b in the comments of your code.
     */

    private int trials;
    private double percent;

    public MontesDoor(int trials) {
        this.trials = trials;
        double winCount = 0;

        for(int i = 0; i < trials; i++) {
            if(play1()) {
                winCount++;
            }
        }
        percent = (winCount/trials) * 100;

        System.out.println("Result: " + percent + "% win rate");
    }

    public boolean play1() {
        Random n = new Random();
        int prizeDoor = n.nextInt(1, 4);

        Door door1 = new Door(prizeDoor == 1);
        Door door2 = new Door(prizeDoor == 2);
        Door door3 = new Door(prizeDoor == 3);

        int choiceDoor = n.nextInt(1, 4);

        if (choiceDoor == prizeDoor) {
            return true;
        } else {
            return false;
        }
    }

    public boolean play2() {
        Random n = new Random();
        int prizeDoor = n.nextInt(1, 4);

        Door door1 = new Door(prizeDoor == 1);
        Door door2 = new Door(prizeDoor == 2);
        Door door3 = new Door(prizeDoor == 3);

        ArrayList<Door> list = new ArrayList<>();
        list.add(door1);
        list.add(door2);
        list.add(door3);

        int choiceDoor = n.nextInt(1, 4);
        //bounds of 0 to 3 for arraylist indexing
        int removeDoor = n.nextInt(0,3);

        //we should not open the door that has the prize or that the player chose
        if (list.get(removeDoor).prize || removeDoor == choiceDoor) {
            removeDoor = n.nextInt(0,3);
        }

        list.remove(removeDoor);
        //bounds are now 0 to 2 because one door was removed
        choiceDoor = n.nextInt(0,2);

        return choiceDoor == prizeDoor;

    }


    public class Door {

        boolean prize;

        public Door(boolean prize) {
            this.prize = prize;
        }
    }


}
