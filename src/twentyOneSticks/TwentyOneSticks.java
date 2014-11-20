package twentyOneSticks;
public class TwentyOneSticks 
{
	public static void main(String[] args) 
	{
		Window window = new Window();

		window.println("How many computer players? (max 3)");
		
		// change this however you want
		// my fix
		int numPlayers = 0;
		boolean problem = true;
		
		// while there is still a problem, lets keep asking
		// for a number.
		while(problem)
		{
			try
			{
				// get the number from the window input
				numPlayers= window.nextInt();
				
				// if we get to this point, then everything is ok!
				problem = false;
			}catch(Exception e)
			{
				// there was not a valid number inputted!
				numPlayers = -1;
				problem = true; // there was a problem.
				System.out.println("That was not a number.");
			}
		}
		// end fix
		
		int numSticks = 21;
		int numToTake;
		int min = 1;
		int max = 2;
		boolean playing= true;
		int compTurns = 1;
		boolean compPlayers = true;
		while(compPlayers)
		{
			if(numPlayers==1 || numPlayers==2 || numPlayers==3)
			{	
				window.println("Would you like to go first? Y/n");
				String goFirst = window.nextLine();
				switch(numPlayers)
				{
				case 1:

					while(playing)
					{
						if(goFirst.equals("Y")||goFirst.equals("y"))
						{
							if(numSticks==21)
							{
								window.println("Player goes first");
							}
							window.println("There are " + numSticks + " sticks");
							window.println("How many sticks would you like to take (1 or 2)?");
							numToTake = window.nextInt();
							if(numToTake==min||numToTake==max)
							{
								numSticks = numSticks - numToTake;
								if(numSticks<=0)
								{
									window.println("You Lose!");
									playing = false;
								}else{
									if((numSticks-2) % 3 ==0 || numSticks-2==0)
									{
										numToTake=1;
									}else{
										numToTake=2;
									}
									window.println("The Computer took " + numToTake + " sticks");
									numSticks = numSticks - numToTake;
									if(numSticks<=0)
									{
										window.println("You Win!");
										playing = false;
									}
								}
							}
							if(!(numToTake==min||numToTake==max))
							{
								window.println("Cheater! You input an invalid number of sticks! Try Again!");
							}
						}else if(goFirst.equalsIgnoreCase("N")|| goFirst.equals("n"))
						{
							if(numSticks==21)
							{
								window.println("Computer goes first");
							}
							if(numSticks-2 %3 ==0||numSticks-2 ==0)
							{
								numToTake=1;
							}else{
								numToTake=2;
							}
							window.println("Computer takes " + numToTake + " sticks");
							numSticks= numSticks - numToTake;
							if(numSticks<=0)
							{
								window.println("You Win!");
								playing = false;
							}else{
								window.println("There are " + numSticks + " sticks");
								window.println("How many sticks would you like to take (1 or 2)?");
								numToTake=window.nextInt();
								if(numToTake==min||numToTake==max)
								{
									numSticks = numSticks - numToTake;
									if(numSticks<=0)
									{
										window.println("You Lose!");
										playing = false;
									}
								}
								while(!(numToTake==min||numToTake==max))
								{
									window.println("Cheater! You input an invalid number of sticks! Try Again!");
									window.println("How many sticks would you like to take (1 or 2)?");
									numToTake=window.nextInt();
								}
							}
						}else{
							window.println("Invalid input. Please try again.");
							window.println("Would you like to go first? Y/n");
							goFirst = window.nextLine();
							continue;
						}
						if(!playing)
						{
							window.println("Would you like to play again (Y/n)?");
							String playAgain = window.nextLine();
							if(playAgain.equals("Y")||playAgain.equals("y"))
							{
								playing = true;
								numSticks=21;
							}
							if(playAgain.equalsIgnoreCase("N")||playAgain.equals("n"))
							{
								window.println("Thanks for playing...Cry baby!");
							}
						}    
					} compPlayers = false;




				case 2:

					while(playing)
					{
						if(goFirst.equals("Y")||goFirst.equals("y"))
						{
							if(numSticks==21)
							{
								window.println("Player goes first");
							}
							window.println("There are " + numSticks + " sticks");
							window.println("How many sticks would you like to take (1 or 2)?");
							numToTake = window.nextInt();
							if(numToTake==min||numToTake==max)
							{
								numSticks = numSticks - numToTake;
								if(numSticks<=0)
								{
									window.println("You Lose!");
									playing = false;
								}else{
									compTurns=1;
									while(compTurns<=2)
									{
										if((numSticks-2) % 3 ==0 || numSticks-2==0)
										{
											numToTake=1;
										}else{
											numToTake=2;

										}
										window.println("Computer " + compTurns + " took " + numToTake + " sticks");
										numSticks = numSticks - numToTake;
										compTurns++;
									}
									compTurns=0;
									if(numSticks<=0)
									{
										window.println("You Win!");
										playing = false;
									}

								}
							}
							if(!(numToTake==min||numToTake==max))
							{
								window.println("Cheater! You input an invalid number of sticks! Try Again!");
							}
						}else if(goFirst.equalsIgnoreCase("N")|| goFirst.equals("n"))
						{
							if(numSticks==21)
							{
								window.println("Computer goes first");
							}
							compTurns=1;
							while(compTurns<=2)
							{
								if(numSticks-2 %3 ==0||numSticks-2 ==0)
								{
									numToTake=1;
								}else{
									numToTake=2;
								}
								window.println("Computer " + compTurns + " takes " + numToTake + " sticks");
								numSticks= numSticks - numToTake;
								compTurns++;
							}
							if(numSticks<=0)
							{
								window.println("You Win!");
								playing = false;
							}

							if(numSticks>=1)
							{
								window.println("There are " + numSticks + " sticks");
								window.println("How many sticks would you like to take (1 or 2)?");
								numToTake=window.nextInt();
								if(numToTake==min||numToTake==max)
								{
									numSticks = numSticks - numToTake;
									if(numSticks<=0)
									{
										window.println("You Lose!");
										playing = false;
									}
									compTurns=0;
								}
								while(!(numToTake==min||numToTake==max))
								{
									window.println("Cheater! You input an invalid number of sticks! Try Again!");
									window.println("How many sticks would you like to take (1 or 2)?");
									numToTake=window.nextInt();
								}
							}
						}else{
							window.println("Invalid input. Please try again.");
							window.println("Would you like to go first? Y/n");
							goFirst = window.nextLine();
							continue;
						}
						if(!playing)
						{
							window.println("Would you like to play again (Y/n)?");
							String playAgain = window.nextLine();
							if(playAgain.equals("Y")||playAgain.equals("y"))
							{
								playing = true;
								numSticks=21;
							}
							if(playAgain.equalsIgnoreCase("N")||playAgain.equals("n"))
							{
								window.println("Thanks for playing...Cry baby!");
							}
						}	
					}compPlayers=false;



				case 3:
					while(playing)
					{
						if(goFirst.equals("Y")||goFirst.equals("y"))
						{
							if(numSticks==21)
							{
								window.println("Player goes first");
							}
							window.println("There are " + numSticks + " sticks");
							window.println("How many sticks would you like to take (1 or 2)?");
							numToTake = window.nextInt();
							if(numToTake==min||numToTake==max)
							{
								numSticks = numSticks - numToTake;
								if(numSticks<=0)
								{
									window.println("You Lose!");
									playing = false;

								}else{
									compTurns=1;
									while(compTurns<=3)
									{
										if((numSticks-2) % 3 ==0 || numSticks-2==0)
										{
											numToTake=1;
										}else{
											numToTake=2;

										}
										window.println("Computer " + compTurns + " took " + numToTake + " sticks");
										numSticks = numSticks - numToTake;
										compTurns++;
									}
									if(numSticks<=0)
									{
										window.println("You Win!");
										playing = false;
									}
								}
							}
							compTurns=0;
							if(!(numToTake==min||numToTake==max))
							{
								window.println("Cheater! You input an invalid number of sticks! Try Again!");
							}
						}else if(goFirst.equalsIgnoreCase("N")|| goFirst.equals("n"))
						{
							if(numSticks==21)
							{
								window.println("Computer goes first");
							}
							compTurns=1;
							while(compTurns<=3)
							{
								if(numSticks-2 %3 ==0||numSticks-2 ==0)
								{
									numToTake=1;
								}else{
									numToTake=2;
								}
								window.println("Computer " + compTurns + " takes " + numToTake + " sticks");
								numSticks= numSticks - numToTake;
								compTurns++;
							}
							if(numSticks<=0)
							{
								window.println("You Win!");
								playing = false;
							}else{
								window.println("There are " + numSticks + " sticks");
								window.println("How many sticks would you like to take (1 or 2)?");
								numToTake=window.nextInt();
								if(numToTake==min||numToTake==max)
								{
									numSticks = numSticks - numToTake;
									if(numSticks<=0)
									{
										window.println("You Lose!");
										playing = false;
									}
									compTurns=0;
								}
								while(!(numToTake==min||numToTake==max))
								{
									window.println("Cheater! You input an invalid number of sticks! Try Again!");
									window.println("How many sticks would you like to take (1 or 2)?");
									numToTake=window.nextInt();
								}
							}
						}else{
							window.println("Invalid input. Please try again.");
							window.println("Would you like to go first? Y/n");
							goFirst = window.nextLine();
							continue;
						}
						if(!playing)
						{
							window.println("Would you like to play again (Y/n)?");
							String playAgain = window.nextLine();
							if(playAgain.equals("Y")||playAgain.equals("y"))
							{
								playing = true;
								numSticks=21;
							}
							if(playAgain.equalsIgnoreCase("N")||playAgain.equals("n"))
							{
								window.println("Thanks for playing...Cry baby!");
							}
						}	
					}compPlayers=false;


				default:
					if(!(numPlayers==1||numPlayers==2||numPlayers==3))
					{
						window.println("Invalid number of computer players. Please try again.");
						window.println("How many computer players? (max 3)");
						numPlayers = window.nextInt();
					}
				}
			}else if(!(numPlayers==1||numPlayers==2||numPlayers==3)){
				window.println("Invalid number of computer players. Please try again.");
				window.println("How many computer players? (max 3)");
				numPlayers = window.nextInt();

			}
		}
	}
}