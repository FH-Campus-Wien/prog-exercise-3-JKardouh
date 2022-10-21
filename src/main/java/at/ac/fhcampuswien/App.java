package at.ac.fhcampuswien;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        int[] array = {3,9,1,5,8};
        checkDigit(array); //6

        String test = "my naMe iSn't aliCe";
        camelCase(test); //5

        int[] Array1 = {1,2,3,4,5};
        int[]  Array2 = {100,99,60,44,2};
        swapArrays(Array1, Array2); //4


        //3
        int NumberToGuess= randomNumberBetweenOneAndHundred();
        guessingGame(NumberToGuess);

        long[] generatedNumbs = lcg(0); //2

        oneMonthCalendar(30,6);
    }

    public static void oneMonthCalendar(int daysNumb,int dayCol){

        String block = "   ";
        int offset = dayCol -1 ;
        int row = 1;
        for(int k = 0 ; k < offset; k++){
            System.out.print(block);
        }
        int colCounter = dayCol;
        for (int i = 1; i <= daysNumb ; i++){
            if (colCounter == 7){
                if (i < 10){
                System.out.println(" "+i+ " ");
                row++;
                }
                else {
                System.out.println( i+ " ");
                row++;
                }
                colCounter = 0;
            }
            else{
                if (i < 10) System.out.print(" "+ i+ " ");
                else   System.out.print( i+ " ");
            }
            colCounter++;
        }
        if(row == 5 ){
        System.out.println();
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();;
        return random.nextInt(100) + 1;
    }
    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int tryCount = 1, input;

        do{
            System.out.print("Guess number " + tryCount + ": ");
            if(tryCount == 10){
                System.out.println("You lost! Have you ever heard of divide & conquer?"); break;
            }
            input = scanner.nextInt();
            if(input == numberToGuess){
                System.out.println("You won wisenheimer!");
                break;
            }
            if(input > numberToGuess) System.out.println("The number AI picked is lower than your guess.");
            if(input < numberToGuess) System.out.println("The number AI picked is higher than your guess.");
            tryCount++;
        }
        while(input != numberToGuess && tryCount <= 10);
    }

    public static long[] lcg(long seed) {
        long[] generatedNumbs = new long[10];
        int m = Integer.MAX_VALUE + 1;
        int c = 12345;
        int a = 1103515245;

        for (int i = 0; i < 10; i ++) {
            seed =  (a * seed + c) % m;
            generatedNumbs[i] = seed;
        }
        return generatedNumbs;
    }

    public static int checkDigit(int[] array) {
        int sum = 0;

        for (int i = 0; i <= array.length - 1; i++) {
            sum = sum + array[i] * (i + 2);
        }
        System.out.println(sum);
        int difference = 11 - (sum % 11);
        if (difference == 10) difference = 0;
        else if (difference == 11) difference = 5;
        return difference;
    }

    public static boolean swapArrays(int[] array1, int[] array2) {
        if (array1.length == array2.length) {
            int[] temp = new int[array1.length];
            for (int i = 0; i < array1.length; i++) {
                temp[i] = array1[i];
                array1[i] = array2[i];
                array2[i] = temp[i];
            }
            return true;
        }
        return false;
    }

    public static String camelCase(String test) {
        char [] testArray= test.toCharArray();
        String result = "";
        int firstWordLetterPos = 0;

        for (int i = 0 ; i <= testArray.length - 1 ; i++){
            if (testArray[i] == ' ')  firstWordLetterPos = 0;

            else {
                if((testArray[i] >= 'a' && testArray[i] <= 'z') || (testArray[i] >= 'A' && testArray[i] <= 'Z'))
                {
                    if (testArray[i] >= 'a' && testArray[i] <= 'z')
                    testArray[i] = (char) (testArray[i] - 32); //go capital

                    if (firstWordLetterPos >=  1 && (testArray[i] >= 'A' && testArray[i] <= 'Z')){
                        testArray[i] = (char) (testArray[i] + 32);
                     }
                    result += testArray[i];
                    firstWordLetterPos ++;
                }
            }
        }
        return result;
    }
}