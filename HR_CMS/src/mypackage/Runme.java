package mypackage;

import mypackage.profile.Gender;
import mypackage.profile.Person;
import java.util.Date;

public class Runme {
    public static void main(String[] args) {
        Person ivanIvanov = new Person("Ivan","Ivanov", new Date(), Gender.MALE);
        Person lolaPetrova = new Person("Lola","Petrova", new Date(), Gender.FEMALE);

        System.out.println(ivanIvanov + " - his code - " + ivanIvanov.hashCode());
        System.out.println(lolaPetrova + " - his code - " + lolaPetrova.hashCode());



    }

}