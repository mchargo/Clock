package twentyOneSticks;
public class TwentyOneSticks 
{
    public static void main(String[] args) 
    {
        Window window = new Window();
        
        int numSticks = 21;
        int numToTake;
        window.println("Would you like to go first? Y/n");
        String goFirst = window.nextLine();
        int min = 1;
        int max = 2;
        boolean playing= true;
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
        }
    }
}