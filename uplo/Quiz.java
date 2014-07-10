//import java.util.Scanner;


public class Quiz {
	
	//static String[] quest = new String[2];
	static String temp;
	static int i,choiceSelected,points=0,playerSeq=0,currentPlayer;
      //	static Scanner StdIn = new Scanner(System.in);
	
	static String[] playerName = new String[10]; 
	static int[] playerId = new int[10];
	static int[] playerPoints = new int[10];
	static String[] quest = {"Grand Central Terminal, Park Avenue, New York is the world's?","hi","your"};
	static String[] options = {"1.largest railway station 2.highest railway station  3.longest railway station  4.None of the above","aa","bb"};
	static int[]	ans = {2,3,5};
	static int[] randQues = new int[10];
						
	
	
						/*this function allow user to randomly generate questions
						 * by using a random generator , decleared in Random library/import
						 */
						void Shuffle(){
						//Random rgen = new Random();  // Random number generator
						
						//Initialize the array
						for (int i=0; i<3; i++) {
						    randQues[i] = i;
						}
				
						//Shuffle by exchanging each element randomly
						for (int i=0; i<3; i++) {
						    int randomPosition = StdRandom.uniform(3);
						    int temp = randQues[i];
						    randQues[i] = randQues[randomPosition];
						    randQues[randomPosition] = temp;
						}
						}
						
						
						
						/*Prints a random questions with 4 options, when PLAY game is selected
						 * asks user for his/her ans and Returns the selected ans 
						 */
						 int PrintQues(int i)
						{	int ans;
							System.out.println(quest[randQues[i]] + " ");
							System.out.println(options[randQues[i]]);
							System.out.println("Your ans: ");
							ans=StdIn.readInt();
							return ans;
							}
						 
						 
						 /*prints questions and for each correct ans
						  * it adds +5 points if ans given is incorrect displays the total points and returns to Main Menu
						  */
						  void Play()
						 {
							 int key,id,flag=0;
							 System.out.println("Enter Player Id:");   //palyers name
								 id = StdIn.readInt();						//to read player name
								 
								 flag=SearchPlayerId(id);
								 if(flag==0)
								 {
									 System.out.println("Regestration is Required!!!");
									 Register();
								 }
								
								
								System.out.println("Welcome to the Quiz Game ");
								
								System.out.println("Press 1 key to continue ");
								key = StdIn.readInt();
								
								 
								 if(key == 1)
								{
									System.out.println("Quiz Starts in 5 sec");
									
									//-----------------------timer here-------------------------------------------------
									
									for(int i=0;i<3;i++)
									{
										choiceSelected = PrintQues(i);
										if(choiceSelected == ans[randQues[i]])
										{
											playerPoints[currentPlayer]+=5;
											System.out.println("Your Answer is Correct !!! You earned " + playerPoints[currentPlayer] + " points");
										}else
										{
											System.out.println("You have give the incorrect Answer, Please try again later");
											System.out.println("Total Points earned " + playerPoints[currentPlayer] +" Points");
											ChoiceMenu(0);
										}//end of else
									}//end of for
									
									}//end of if

						 }//end of play
						  
						  
						  /*takes name and palyerid and stores it into the array called playername and playerid
						   * 
						   */
						  
						  void Register(){	
							  int tempId;
							  System.out.println("Enter Your First Name in Lower Case:");
							  playerName[playerSeq] = StdIn.readString();
							  tempId = GetId();
							  	for(i=0;i<10;i++)
								  if(tempId == playerId[i])
								  {
									  System.out.println("Player ID already exist!! Enter new ID");
									  GetId();	  
								  }else{playerId[playerSeq]=tempId;
									  System.out.println("Registration Successful for " + playerName[playerSeq]);
									  playerSeq+=1;
									  ChoiceMenu(tempId);
								  }
							  	
						  }
	
						/*Displays the username with his/her score 
						 * 
						 */
			                                                                               		
						  void Score(){
							  System.out.println("Player Name				" +
							  		"Points");
							  for(int i=0;i<10;i++)
							  {
							  System.out.println(playerName[i] + "				" + playerPoints[i]);
							  }
						  }
						  
						  /*finds the id of the player if it exit in playerid array
						   * 
						   */
						  
						  int SearchPlayerId(int id)
						  { int flag=0;
							  for(int i = 0;i<10;i++)
							  {
								  if(id == playerId[i])
									  {
									  currentPlayer=i;
									  flag=1;
									  break;}
							  }
							  return flag;
							  
						  }
						  
						  /*it accept the id for a player
						   * 
						   */
						  int GetId(){
							  int tempId;
							  System.out.println("Enter a 4 digit id:");
							  tempId = StdIn.readInt();
							  return tempId;
						  }
				
						  /*allows user to select an option like play Register Instruction Scores and Exit
						   * 
						   */
						  void ChoiceMenu(int PlayerId)
						  {int choice;
							  System.out.println("====================================WELCOME TO QUIZ GAME==========================================================================");
								System.out.println("	1.Play\n	2.Register\n	3.Instructions\n	4.Scores\n	5.Exit");
								System.out.println("\n\n	Select Any Option:");
								choice=StdIn.readInt();
								switch(choice)
								{
								case 1:			Play();	
												break;
								case 2:			Register();
												break;
								case 3:			//level.Instruction();
												break;
								case 4:			Score();
												break;
								case 5:			//ExitGame()
												break;
								default:	System.out.println("Invalid choice");	
								}
}
				
/*main function which create an obeject called level for class quiz and dynanamically allocates memory for class quiz by calling a constructor 
 * 	
 */
public static void main(String args[])
{	Quiz level = new Quiz();
	
	level.Shuffle();
	level.ChoiceMenu(0);
	

	
}//end of main
}//end of class
