package Grazioso;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<monkey> monkeyList = new ArrayList<monkey>();
    // Instance variables (if needed)
    //variables needed to instantiate a new monkey and dog
    
	
    

    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);

        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
        displayMenu();
        String input = scnr.next();
        
        while(!input.equals("q")) {
        	if(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") || input.equals("6")) {
        		if(input.equals("1")) {
        			intakeNewDog(scnr); //intakes new dog
        		} else if(input.equals("2")) {
        			intakeNewMonkey(scnr);//intakes new monkey
        		} else if(input.equals("3")) {
        			reserveAnimal(scnr); // reserves an animal
        		} else if(input.equals("4")) {
        			printAnimals("dog"); //prints all dogs
        		} else if(input.equals("5")) {
        			printAnimals("monkey"); //prints all monkeys
        		} else if(input.equals("6")) {
        			printAnimals("available");// prints all in service and available animals
        		}
        		
        	} else {
        		System.out.println("ERROR: Invalid input");
        	}
        	
        	input = scnr.next();
        }
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
        
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {

    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String dogName = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(dogName)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        
        System.out.println("Please input " + dogName + "'s breed");
        String dogBreed = scanner.nextLine();
        
        System.out.println("Please input " + dogName + "'s gender");
        String dogGender = scanner.nextLine();
        
        System.out.println("Please input " + dogName + "'s age");
        String dogAge = scanner.nextLine();
        
        System.out.println("Please input " + dogName + "'s weight");
        String dogWeight = scanner.nextLine();
        
        
        System.out.println("Please input " + dogName + "'s acquisition date");
        String dogDoA = scanner.nextLine();
        
        System.out.println("Please input " + dogName + "'s country of acquisition");
        String dogCoA = scanner.nextLine();
        
        System.out.println("Please input " + dogName + "'s training status");
        String dogTraining = scanner.nextLine();
        
        System.out.println("Please input " + dogName + "'s reserve status");
        boolean dogReserve = scanner.nextBoolean();
        scanner.nextLine(); //gets rid of leftover /n
        
        System.out.println("Please input " + dogName + "'s service country");
        String dogServiceC = scanner.nextLine();

        // Add the code to instantiate a new dog and add it to the appropriate list
        dogList.add(new Dog(dogName, dogBreed, dogGender, dogAge, dogWeight, dogDoA, dogCoA, dogTraining, dogReserve, dogServiceC));   
        }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            scanner.nextLine();
            String monkeyName = scanner.nextLine();
            //input validation
             for(monkey monkey: monkeyList) {
            	if(monkey.getName().equalsIgnoreCase(monkeyName)) {
            		System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
            	}
             }	
            //prompts user for inputs
            System.out.println("Please input " + monkeyName + "'s species");
            String monkeySpecies = scanner.nextLine();
            
            while(!monkeySpecies.equalsIgnoreCase("Capuchin") && !monkeySpecies.equalsIgnoreCase("Guenon") && !monkeySpecies.equalsIgnoreCase("Macaque") && !monkeySpecies.equalsIgnoreCase("Marmoset") && !monkeySpecies.equalsIgnoreCase("Sqirrell monkey") && !monkeySpecies.equalsIgnoreCase("Tamarin") ) {
            	System.out.println("ERROR: Invalid monkey type");
            	monkeySpecies = scanner.nextLine();
            }
            
            System.out.println("Please input " + monkeyName + "'s gender");
            String monkeyGender = scanner.nextLine();
            
            System.out.println("Please input " + monkeyName + "'s age");
            String monkeyAge = scanner.nextLine();
            
            System.out.println("Please input " + monkeyName + "'s weight");
            String monkeyWeight = scanner.nextLine();
            
            System.out.println("Please input " + monkeyName + "'s tail length");
            String tailLength = scanner.nextLine();
            
            System.out.println("Please input " + monkeyName + "'s body length");
            String bodyLength = scanner.nextLine();
            
            System.out.println("Please input " + monkeyName + "'s height");
            String height = scanner.nextLine();
            
            System.out.println("Please input " + monkeyName + "'s acquisition date");
            String monkeyDoA = scanner.nextLine();
            
            System.out.println("Please input " + monkeyName + "'s country of acquisition");
            String monkeyCoA = scanner.nextLine();
            
            System.out.println("Please input " + monkeyName + "'s training status");
            String monkeyTraining = scanner.nextLine();
            
            System.out.println("Please input " + monkeyName + "'s reserve status");
            boolean monkeyReserve = scanner.nextBoolean();
            scanner.nextLine(); //gets rid of leftover /n
            
            System.out.println("Please input " + monkeyName + "'s service country");
            String monkeyServiceC = scanner.nextLine();
            
            
            monkeyList.add(new monkey(monkeyName, monkeySpecies, monkeyGender, monkeyAge, monkeyWeight, monkeyDoA, monkeyCoA, monkeyTraining, monkeyReserve, monkeyServiceC, tailLength, bodyLength, height));
           
            
            
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
        	int count = 0;
            System.out.println("Are you looking for a monkey or dog?");
            String animalType = scanner.nextLine();
            
            System.out.println("What country are you in?");
            String animalCountry = scanner.nextLine();
            
            if(animalType.equalsIgnoreCase("monkey")) {
            	
            	for(monkey monkey: monkeyList) {
            		if(monkey.getReserved() == false && monkey.getInServiceLocation().equalsIgnoreCase(animalCountry) && monkey.getInServiceLocation().equalsIgnoreCase("in service")) {
            			System.out.println("Name: " + monkey.getName());
            			System.out.println("Species:" + monkey.getSpecies());
            			System.out.println("Reserved: " + monkey.getReserved());
            			System.out.println("Training Status: " + monkey.getTrainingStatus());
            			
            			monkey.setReserved(true);
            			break;
            		} else {
            			count++; //increments a counter if that monkey isn't available
            		}
            		
            		if(count == monkeyList.size()) { //determines if there are no monkeys available
            			System.out.println("There are no monkey's available in this country");
            			count = 0;
            		}
            	}
            } else if(animalType.equalsIgnoreCase("dog")) {
            	for(Dog dog: dogList) {
            		if(dog.getReserved() == false && dog.getInServiceLocation().equalsIgnoreCase(animalCountry) && dog.getInServiceLocation().equalsIgnoreCase("in service")) {
            			System.out.println("Name: " + dog.getName());
            			System.out.println("Reserved: " + dog.getReserved());
            			System.out.println("Training Status: " + dog.getTrainingStatus());
            			
            			dog.setReserved(true);
            			break;
            		} else {
            			count++;//increments count if that dog isn't available
            		}
            		
            		if(count == dogList.size()) { //determines if there are no dogs available
            			System.out.println("There are no dog's available in this country");
            			count = 0;
            		}
            		
            	}
            }
        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String listType) {
        	int count = 0;
        	if(listType.equals("dog")) {
        		for(Dog dog : dogList) {
        			System.out.println("Name: " + dog.getName());
        			System.out.println("Country of acquisition: " + dog.getAcquisitionLocation());
        			System.out.println("Training status: " + dog.getTrainingStatus());
        			System.out.println("Reserved: " + dog.getReserved());
        			System.out.println("---------------------------"); //divider between animals
        		}
        	} else if(listType.equals("monkey")) {
        		for(monkey monkey : monkeyList) { //iterates through monkeyList and prints necessary info
        			System.out.println("Name: " + monkey.getName());
        			System.out.println("Country of acquisition: " + monkey.getAcquisitionLocation());
        			System.out.println("Training status: " + monkey.getTrainingStatus());
        			System.out.println("Reserved: " + monkey.getReserved());
        			System.out.println("---------------------------"); //divider between animals
        			     
        		}
        	} else if(listType.equals("available")) {
        		System.out.println("Available dogs:");
        		for(Dog dog: dogList)  { //Iterates through dogList
        			if(dog.getReserved() == false && dog.getTrainingStatus().equals("in service")) { //if the dog is not reserved and in service prints all necessary information
        				System.out.println("Name: " + dog.getName());
            			System.out.println("Country of acquisition: " + dog.getAcquisitionLocation());
            			System.out.println("Training status: " + dog.getTrainingStatus());
            			System.out.println("---------------------------"); //divider between animals
        			} else {
        				count++;
        			}
        			
        			if(count == dogList.size()) {
        				System.out.println("I'm sorry, all of our dogs are reserved"); //message if all monkeys are reserved
        				count = 0;
        			}
        		}
        		System.out.println("Available monkeys:");
        		for(monkey monkey: monkeyList) { //Iterates through monkeyList
        			if(monkey.getReserved() == false && monkey.getTrainingStatus().equals("in service")) { //if the monkey is not reserved and in service it prints necessary info
        				System.out.println("Name: " + monkey.getName());
            			System.out.println("Country of acquisition: " + monkey.getAcquisitionLocation());
            			System.out.println("Training status: " + monkey.getTrainingStatus());
            			System.out.println("---------------------------"); //divider between animals
        			} else {
        				count++;
        			}
        			
        			if(count == monkeyList.size()) {
        				System.out.println("I'm sorry, all of our monkeys are reserved"); //message if all monkeys are reserved
        				count = 0;
        			}
        			
        		}
        	}
            

        }
        
}

