package com.cydeo.lossely_coupled;

public class MentorAccount {
    Mentor mentor;

    public MentorAccount(Mentor mentor){
        this.mentor = mentor;
    }

    public void manageAccount() {
        mentor.createAccount();
    }
}
