package com.riddle;

import java.util.*;

public class GameEngine{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        List<Riddle> riddleList = new ArrayList<>();
        riddleList.add(new Riddle("What has keys but no locks?", "Keyboard", "It's on your desk."));
        riddleList.add(new Riddle("What gets wetter as it dries?", "Towel", "You use it after a shower."));
        riddleList.add(new Riddle("What has a neck but no head?", "Bottle", "It holds liquids."));
        riddleList.add(new Riddle("What has a face and two hands but no arms or legs?", "Clock", "It helps you keep track of your college lecture times."));
        riddleList.add(new Riddle("I have keys, but no locks. I have a space, but no room. You can allow entrance, but never leave. What am I?","Keyboard", "You are likely using one right now to write your Java code."));

        Collections.shuffle(riddleList);

        int score = 0;
        int lives = 3;

        System.out.println("Welocome to Showan Riddle ");
        System.out.println("You have"+lives+"lives");
        System.out.println("¡Suerte!");

        for(Riddle r : riddleList) {
            if(lives<=0) break;

            System.out.println("here it is:"+r.question);
            System.out.println("Your answer:");
            String userAnswer = sc.nextLine();

            if(userAnswer.trim().equalsIgnoreCase(r.answer)){
                System.out.println("CORRECT!,you found it!");
                score+=10;
            }
            else{
                  lives--;
                  System.out.println("WRONG!");
                  System.out.println("Would you like to try for -5 points ? (yes/no)");

                  if(sc.nextLine().trim().equalsIgnoreCase("yes")){
                    
                    System.out.println(r.hint);
                    System.out.println("Try Again !");
                    userAnswer = sc.nextLine();

                    if(userAnswer.trim().equalsIgnoreCase(r.answer)){
                        System.out.println("CORRECT!");
                        score+=5;
                    }
                    else{
                        lives--;
                        System.out.println("AGAIN WRONG!");
                        System.out.println("Lives Remaining:"+lives);
                    }

                  }
                  else{
                    lives--;
                    System.out.println("WRONG!");
                    System.out.println("Lives Remaining:"+lives);

                  }
            }
        }
        System.out.println("GAME DONEEE !");
        System.out.println("Final Score"+score);
        sc.close();

    } 
}