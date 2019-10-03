import ModelObjects.ResupplyPerSpaceShipPerDistance;
import SpaceShipsAndCalculation.SpaceShipsOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserActionScanner {
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
                break;
            }else if (question.equals("start")){
                System.out.println();
                System.out.println("Enter a distance on MGLT");
                String distance = scanner.nextLine();
                if(distance.equals("quit")){
                    break;
                }else if (validateUserInput(distance)){
                    System.out.println("Invalid input retry again");
                }else {
                    result = callCalculation(distance);
                    for (ResupplyPerSpaceShipPerDistance s: result){
                        System.out.println(s.toString());
                     }
                }
            }
        }
        return result;
    }

    public List<ResupplyPerSpaceShipPerDistance> callCalculation(String distance) {
        List<ResupplyPerSpaceShipPerDistance> result;
        SpaceShipsOperations spaceShipsOperations = new SpaceShipsOperations();
        result = spaceShipsOperations.spaceShipsAndMakeCalculations(Integer.parseInt(distance));
        for (ResupplyPerSpaceShipPerDistance s : result) {
            System.out.println(s.toString());
        }
        return result;
    }

    public boolean validateUserInput(String distance){
        return !distance.matches("-?\\d+(\\.\\d+)?")
                || Double.parseDouble(distance)>Integer.MAX_VALUE
                || Double.parseDouble(distance)<=0;

    }

    public void printEntry(){
        System.out.println();
        System.out.println("=================Select a function=================");
        System.out.println(" start: Calculate total amount of stops by distance");
        System.out.println(" quit: exit");
        System.out.println("===================================================");
        System.out.println();
        System.out.println("Type function");
    }
}
