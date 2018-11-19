import java.util.Scanner;

public class lab3 {
    public static void main(String[] args) {

    	// Loop over the Scanner
        // Split each line into the task and the corresponding number (if one exists)
        // Depending on what the input task was, preform the corresponding function
        //      (ie) insert, maximum, extractMax, isEmpty, or print
        // Hint: Use a switch-case statement

        // Don't forget to close your Scanner!
    	Scanner scan = new Scanner(System.in);
    	String input;
        String task;

        int input_number = Integer.parseInt(scan.nextLine());
        pQueue<Integer> pQueue = new pQueue<Integer>(input_number);
        while (scan.hasNext()){
            input = scan.nextLine();
            String[] phrases = input.split(" ");
            task = phrases[0];
            switch(task) {
            	case "insert":
                    pQueue.insert(Integer.parseInt(phrases[1]));
                break;
                case "maximum":
                    Comparable<Integer> max = pQueue.maximum();
                    System.out.println(max);
                break;
                case "extractMax":
                    Comparable<Integer> removemax = pQueue.extractMax();
                    System.out.println(removemax);
                break;
                case "isEmpty":
                    if (pQueue.isEmpty() == true){
                        System.out.println("Empty");
                    }
                    else{
                        System.out.println("Not Empty");
                    }
                break;
                case "build":
                    String[] arr = phrases[1].replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\s","").split(",");
                    Integer[] input_array = new Integer[arr.length + 1];
                    for(int j = 1; j < input_array.length; j++){
                    input_array[j] = Integer.parseInt(arr[j-1]);
                    }
                    pQueue.build(input_array);
                break;
                case "print":
                    pQueue.print();
                break;
                }
            }
        scan.close();
}
}
