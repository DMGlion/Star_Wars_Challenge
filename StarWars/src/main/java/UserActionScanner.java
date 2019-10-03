import ModelObjects.ResupplyPerSpaceShipPerDistance;
import SpaceShipsAndCalculation.SpaceShipsOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserActionScanner {
    public List<ResupplyPerSpaceShipPerDistance> ActionScanner(){
        List<ResupplyPerSpaceShipPerDistance> result = new ArrayList<ResupplyPerSpaceShipPerDistance>();
        SpaceShipsOperations spaceShipsOperations = new SpaceShipsOperations();
        System.out.println();
        System.out.println("        Welcome to the intergalactic travel        ");

        Scanner scanner=new Scanner(System.in);
        while (true) {

            System.out.println();
            System.out.println("=================Select a function=================");
            System.out.println(" start: Calculate total amount of stops by distance");
            System.out.println(" quit: exit");
            System.out.println("===================================================");
            System.out.println();
            System.out.println("Type function");
            String question = scanner.nextLine();
            if(question.equals("quit")){
                break;
            }else if (question.equals("start")){
                System.out.println();
                System.out.println("Enter a distance on MGLT");
                String distance = scanner.nextLine();
                if(distance.equals("quit")){
                    break;
                }else if (!distance.matches("-?\\d+(\\.\\d+)?")){
                    System.out.println("Invalid input retry again");
                }else {
                    result = spaceShipsOperations.SpaceShipsAndMAkeCAlculations(1000000);
                    for (ResupplyPerSpaceShipPerDistance s: result){
                        System.out.println(s.toString());
                     }
                }
            }
        }

        return result;
    }
}
