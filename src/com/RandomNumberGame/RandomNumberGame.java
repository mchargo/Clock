package com.RandomNumberGame;
import java.util.*;


public class RandomNumberGame {

	public static void main(String[] args) 
	{
		Scanner playerGuess = new Scanner(System.in);
		boolean playing = true;
		int attempts = 0;
		while(playing)
		{
		int guess;
		Random generator = new Random();
		int value = generator.nextInt(100);
		
		while(attempts<2)
		{
		System.out.println("Guess: ");
		guess = playerGuess.nextInt();
		if(guess == value)
		{
			System.out.println("Congrats! You guessed correct!");
			playing=false;
		}else if(guess>value){
			System.out.println("The value is lower than your guess. Please try again.");
			
		}else if(guess<value){
			System.out.println("The value is higher than your guess. Please try again");
		}
		attempts++;
		}
		System.out.println("Final Guess: ");
		guess = playerGuess.nextInt();
		if(guess==value)
		{
		System.out.println("Congrats! You Guessed Correct! The value was: " + value);
		playing= false;
		}else if(guess!=value){
			System.out.println("The correct value was: " + value);
			playing=  false;
		}

	}
	}

}
