import java.util.ArrayList;
import java.util.Random;

public class MontesDoor {

    public MontesDoor(int trials) {

        double winCount = 0;

        for(int i = 0; i < trials; i++) {
            if(play1()) {
                winCount++;
            }
        }
        double percent = (winCount/trials) * 100;

        System.out.println("Result: " + percent + "% win rate");
    }

    //has person choose door and not switch
    //returns about 1/3 winrate
    public boolean play1() {
        Random n = new Random();
        int prizeDoor = n.nextInt(1, 4);

        //randomly choose prize door
        Door door1 = new Door(prizeDoor == 1);
        Door door2 = new Door(prizeDoor == 2);
        Door door3 = new Door(prizeDoor == 3);

        ArrayList<Door> doors = new ArrayList<>();
        doors.add(door1);
        doors.add(door2);
        doors.add(door3);

        int choiceDoor = choose(doors.size());

        return doors.get(choiceDoor).prize;
    }

    //has person choose door and then switch
    //returns about 1/2 winrate
    public boolean play2() {
        int prizeDoor = choose(3);

        Door door1 = new Door(prizeDoor == 0);
        Door door2 = new Door(prizeDoor == 1);
        Door door3 = new Door(prizeDoor == 2);

        ArrayList<Door> doors = new ArrayList<>();
        doors.add(door1);
        doors.add(door2);
        doors.add(door3);

        int choiceDoor = choose(doors.size());
        int removeDoor = choose(doors.size());

        while (removeDoor == prizeDoor || removeDoor == choiceDoor) {
            removeDoor = choose(doors.size());
        }

        doors.remove(removeDoor);
        choiceDoor = choose(doors.size());

        return doors.get(choiceDoor).prize;

    }

    public int choose(int size) {
        return new Random().nextInt(0, size);
    }


    public class Door {

        boolean prize;

        public Door(boolean prize) {
            this.prize = prize;
        }
    }


}
