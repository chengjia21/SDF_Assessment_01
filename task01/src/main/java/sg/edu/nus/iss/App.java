package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        Double $last = 0.0;

        while (true) {
            
            String calculatorInput = sc.nextLine();
            String[] userInputArray = calculatorInput.split(" ");
            // System.out.println(Arrays.toString(userInputArray)); //for testing

            Double num1 = 0.0;
            Double num2 = 0.0;

            if (calculatorInput.equals("exit")){
                System.out.println("Bye bye");
                break;
                }
            else{
        
                
            if (userInputArray[0].equals("$last")){
                num1 = $last;
            }
            else{
                num1 = Double.parseDouble(userInputArray[0]);
            }
            
            String operator = userInputArray[1];

            if (userInputArray[2].equals("$last")) {
                num2 = $last;
            } else {
                num2 = Double.parseDouble(userInputArray[2]);
            }
            
            Double result = 0.0;

            
        // String.format("%,.4f", d) // for formatting to a certain no. of decimal places

          switch (operator) {
            case "+":
                result = num1 + num2;
                $last = result;
                System.out.println(result);
                break;
            case "-":
                result = num1 - num2;
                $last = result;
                System.out.println(result);
                break;
            case "*":
                result = num1 * num2;
                $last = result;
                System.out.println(result);
                break;
            case "/":
                result = num1 / num2;
                $last = result;
                System.out.println(result);
                break;

            default:
            System.out.println("Unsupported Operation\n");
                break;
            }
          } 
        }
        }  
    }

