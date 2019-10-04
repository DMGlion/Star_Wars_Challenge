import ModelObjects.ResupplyPerSpaceShipPerDistance;
import SpaceShipsAndCalculation.SpaceShipsOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Initialising class for the command line interface to acces the functionality implemented.
 * 1-quit function
 * 2-Calculate qty of supllies required per distance on MGLT.
 */
public class UserActionScanner {

    /**
     * input scanner class for command line interface to inform user of functions
     * @return Generic Model object which so far only include name of spaceship and calculation of resupplies
     */
    public List<ResupplyPerSpaceShipPerDistance> actionScanner() {
        List<ResupplyPerSpaceShipPerDistance> result = new ArrayList<ResupplyPerSpaceShipPerDistance>();
        SpaceShipsOperations spaceShipsOperations = new SpaceShipsOperations();
        System.out.println();
        System.out.println("        Welcome to the intergalactic travel        ");

        Scanner scanner=new Scanner(System.in);
        while (true) {

            printEntry();
            String question = scanner.nextLine();

            if(question.equals("quit")){
                System.out.println("See you have a good travel");
                break;
            }else if (validateFunctionInputUser(question)){
                System.out.println();
                System.out.println("Enter a distance on MGLT");
                String distance = scanner.nextLine();
                if(distance.equals("quit")){
                    System.out.println("See you have a good travel");
                    break;
                }else if (!validateUserInput(distance)){
                    System.out.println("Invalid input retry again");
                }else {
                    result = callCalculation(distance);

                    if (result.get(0).getErrMessage()!=null){
                        System.out.println(result.get(0).getErrMessage());
                    }else {
                        //display SpaceShips
                        displaySpaceShips(result);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Validate user inputs in relation of choosing the functionality
     * @param question input value by the user
     * @return boolean
     */
    public boolean validateFunctionInputUser(String question) {
        if(question.equals("start")){
            return true;
        }
        System.out.println();
        System.out.println("Please select and appropriate function from the ones described below ");
        return false;
    }

    /**
     * This function call the calculation after the user input and all the validation process
     * @param distance distance on MGLT
     * @return list of star ships using the object model ResupplyPerSpaceShipPerDistance
     */
    public List<ResupplyPerSpaceShipPerDistance> callCalculation(String distance) {
        List<ResupplyPerSpaceShipPerDistance> result;
        SpaceShipsOperations spaceShipsOperations = new SpaceShipsOperations();
        result = spaceShipsOperations.spaceShipsAndMakeCalculations(Integer.parseInt(distance));

        return result;
    }

    /**
     * Validate MGLT user input disaloing any type of character apart from numeric
     * and values not over Max Interger and also not inferior to 0
     * @param distance distance to travle on MGLT
     * @return boolean
     */
    public boolean validateUserInput(String distance){
        return distance.matches("-?\\d+(\\.\\d+)?")
                && Double.parseDouble(distance)>0
                && Double.parseDouble(distance)<Integer.MAX_VALUE;
    }

    /**
     * Print functions available to the user
     */
    public void printEntry(){
        System.out.println();
        System.out.println("=================Select a function=================");
        System.out.println(" start: Calculate total amount of stops by distance");
        System.out.println(" quit: exit");
        System.out.println("===================================================");
        System.out.println();
        System.out.println("Type function");
    }

    /**
     * Display the result required by the user, space ships name and qty of resupplies
     * @param result list of space ships using object model class ResupplyPerSpaceShipPerDistance
     */
    public void displaySpaceShips(List<ResupplyPerSpaceShipPerDistance> result){
        for (ResupplyPerSpaceShipPerDistance s: result){
            System.out.println(s.getName() + ": " + s.getResuply());
        }
    }
}
