package com.cydeo.lossely_coupled;

public class CydeoApp {
    public static void main(String[] args) {

        FullTimeMentor fullTimeMentor = new FullTimeMentor();
        PartTimeMentor partTimeMentor = new PartTimeMentor();

        MentorAccount mentor = new MentorAccount(fullTimeMentor);
         MentorAccount mentor2 = new MentorAccount(partTimeMentor);

         mentor.manageAccount();
         mentor2.manageAccount();
    }
}
