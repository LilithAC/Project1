import java.util.*;

public class Birthday {
    private double percent;

    public Birthday(int people, int trials) {
        int winCount = 0;

        for (int i = 0; i < trials; i++) {
            //amount of people are initialized with random birthdates
            List<String> birthdays = new ArrayList<>();

            Random n = new Random();
            for (int j = 0; j < people; j++) {
                int month = n.nextInt(1,13);
                int date = n.nextInt(1, 32);
                Person person = new Person(month, date);
                birthdays.add(person.birthday);
            }

            for (String birthday : birthdays) {
                //if a birthday apprears in the list more than once, then 2 people share a birthday
                if (Collections.frequency(birthdays, birthday) > 1) {
                    winCount++;
                    break;
                }
            }
        }

        percent =  ((double) winCount/trials) * 100;
        System.out.println("Result: " + percent + "% chance of sharing a brithday");
        System.out.println();
    }

    public class Person {
        String birthday;

        public Person(int month, int date) {
            birthday = month + "/" + date;
        }
    }
}
