package org.ankit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter Receiver Mail");
        String receiverMail = sc.nextLine();
        System.out.println("Enter Subject");
        String sub = sc.nextLine();
        System.out.println("Enter Message");
        String messages = sc.nextLine();

System.out.println("sending..........");

        EmailSender.sendMail(receiverMail,sub,messages);
    }
}