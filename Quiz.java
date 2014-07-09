public class Quiz{
	//data members
	String [] quest = new String[10];
	String [] opt = new String[10];
	String [] ans = new String[10];
	
	int flag;
	int choice;
	/*Constructor for initialization
	*/	
	Quiz(){
	choice=0;
	flag=0;
	}

	//memeber functions
	/*displays the questions 
	*/
	//void displayQuest();
	/*displays the options 
	*/
	//void displayOpt();
	/*Checking the option given by the user
	*/
	//void checkAns(int x);
	
	public static void main(String args[])
	{String name;
		
	System.out.println("Enter your name:");
	name = StdIn.readString();
	System.out.println("Welcome " + name );
	System.out.println("Press any key to continue!!!");
	
	System.out.println("This is level 1\n\n\n");
	

	}}





