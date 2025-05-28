import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FinalProject_SortArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String starter;
        int choice = 0;
        
        while (true) {
            System.out.println(" ");
            System.out.println(" - - - - - | | - - - - - - - - - - - - - - - >   S O R T I N G   A R R A Y S   < - - - - - - - - - - - - - - - - | | - - - - -");
            System.out.println(" ");
            System.out.println("                            This program allows a user to Quick Sort, Merge Sort, and Heap Sort");
            System.out.println("                      on different types of data distributions (random, sorted, reversed, nearly sorted)");
            System.out.println(" ");
            System.out.println("                                               Start [ S ]         Close [ C ]");
            System.out.println(" ");
            
            System.out.print("               Enter your choice : ");
            starter = scanner.nextLine();

            if (starter.equals("S") || starter.equals("s")) {
                menu();
                
                while (true) {
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            System.out.print("               Enter your choice: ");
                            choice = scanner.nextInt();
                            validInput = true;
                        } catch (InputMismatchException e) {
                            scanner.next();  
                            System.out.println("                                            Invalid input! Please enter a number."); 
                        }
                    }
                    
  switch (choice) {
    case 1:
        MergeSort();
        int[] mergeArr = generateArray(scanner);
        mergeSortSteps = 0;
        long startTime = System.nanoTime();
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        long endTime = System.nanoTime();
        System.out.println(" ");
        System.out.println("               Merge Sort completed.");
        System.out.println(" ");
        System.out.println("               Number of steps (comparisons + copies): " + mergeSortSteps);
        System.out.println(" ");
        System.out.printf("               Execution time: %.4f ms\n", (endTime - startTime) / 1_000_000.0);
        System.out.println(" ");
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println(" ");
        break;
    case 2:
        SelectionSort();
        int[] selectionArr = generateArray(scanner);
        selectionSortSteps = 0;
        startTime = System.nanoTime();
        selectionSort(selectionArr);
        endTime = System.nanoTime();
        System.out.println(" ");
        System.out.println("        Selection Sort completed.");
        System.out.println(" ");
        System.out.println("        Number of steps (comparisons): " + selectionSortSteps);
        System.out.println(" ");
        System.out.printf("     Execution time: %.4f ms\n", (endTime - startTime) / 1_000_000.0);
        System.out.println(" ");
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println(" ");
        break;
    case 3:
        InsertionSort();
        int[] insertionArr = generateArray(scanner);
        insertionSortSteps = 0;
        startTime = System.nanoTime();
        insertionSort(insertionArr);
        endTime = System.nanoTime();
        System.out.println(" ");
        System.out.println("        Insertion Sort completed.");
        System.out.println(" ");
        System.out.println("        Number of steps (comparisons): " + insertionSortSteps);
        System.out.println(" ");
        System.out.printf("     Execution time: %.4f ms\n", (endTime - startTime) / 1_000_000.0);
        System.out.println(" ");
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println(" ");
        
        break;
    case 0:
        System.out.println("Program exited.");
        scanner.close();
        System.exit(0);
        break;
    default:
                System.out.println("                                                  Invalid choice. Try again.");
        continue;
}

int next = -1;
while (next != 0 && next != 1) {
    System.out.print("Choose next action: [1] Main menu, [0] Exit: ");
    next = getValidInt(scanner, "");
    if (next != 0 && next != 1) {
                System.out.println("");
                System.out.println("                                             Invalid input. Please enter 1 or 0.");
                System.out.println("");
            }
}
if (next == 0) {
    System.out.println("Program exited.");
    scanner.close();
    System.exit(0);
}
    menu();

                    System.out.println();
                }
            } else if (starter.equals("C") || starter.equals("c")) {
                System.out.println("                                                    Program closed. Goodbye!");
                System.exit(0);
            } else {
                invalid();
                System.out.println("                                    Invalid Input. Please type S to start or C to close.");
            }
        }
    }

public static int getValidInt(Scanner scanner, String prompt) {
    int num = -1;
    boolean valid = false;
    while (!valid) {
        try {
            if (!prompt.isEmpty()) System.out.print(prompt);
            num = scanner.nextInt();
            scanner.nextLine(); 
            valid = true;
        } catch (InputMismatchException e) {
                System.out.println("                                             Invalid input! Please enter a number.");
            scanner.nextLine(); 
        }
    }
    return num;
}

    public static void menu() {
        System.out.println(" ");
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - >   S O R T I N G   A R R A Y S   < - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println("           | |                                                                                                   | |");
        System.out.println("           | |                                         [1] Merge Sort                                            | |");
        System.out.println("           | |                                         [2] Selection Sort                                        | |");
        System.out.println("           | |                                         [3] Insertion Sort                                        | |");
        System.out.println("           | |                                                                                                   | |");
        System.out.println("           | |                                         [0] Exit                                                  | |");
        System.out.println("           | |                                                                                                   | |");
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println(" ");
    }

    public static void MergeSort(){
        System.out.println("");
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - - >   M E R G E   S O R T   < - - - - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println("");
        System.out.println("                                           This menu let you merge sort arrays.");
        DataType();
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println("");
    }
    
    public static void SelectionSort(){
        System.out.println("");
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - >   S E L E C T I O N   S O R T   < - - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println("");
        System.out.println("                                           This menu let you sort selection arrays.");
        DataType();
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println("");
    }  
    
    public static void InsertionSort(){
        System.out.println("");
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - >   I N S E R T I O N   S O R T   < - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println("");
        System.out.println("                                           This menu lets you insertion sort arrays.");
        DataType();
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println("");
    }
    
    public static void DataType(){
        System.out.println("");
        System.out.println("                                                   Select Type of Data:");
        System.out.println("                                                       [1] Random");
        System.out.println("                                                       [2] Sorted");
        System.out.println("                                                       [3] Reversed");
        System.out.println("                                                       [4] Nearly Sorted");
        System.out.println("");
    }
    
    public static void ArraySize(){
        System.out.println("");
        System.out.println("                                                    Select Array Size:");
        System.out.println("                                                       [1] 1,000");
        System.out.println("                                                       [2] 10,000");
        System.out.println("                                                       [3] 100,000");
        System.out.println("");
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - | | - - - - -");

    }
    
    // Method to get array input from the user
    public static int[] getArrayInput(Scanner scanner) {
        System.out.print("               Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("               Enter the elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

public static long mergeSortSteps = 0;
public static long selectionSortSteps = 0;
public static long insertionSortSteps = 0;

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
              mergeSortSteps++; 
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
              mergeSortSteps++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        mergeSortSteps++;
        
        }
    }

    public static int[] generateArray(Scanner scanner) {
    int type = 0, sizeChoice = 0;

    // Validate type input
    while (true) {
        System.out.print("               Choose data type [1-4]: ");
        if (scanner.hasNextInt()) {
            type = scanner.nextInt();
            if (type >= 1 && type <= 4) {
                break;
            } else {
                System.out.println("");
                System.out.println("                                    Invalid input! Please enter a number between 1 and 4.");
                System.out.println("");
            }
        } else {
                System.out.println("");
                System.out.println("                                    Invalid input! Please enter a number between 1 and 4.");
                System.out.println("");
            scanner.next(); 
        }
    }

    // Validate sizeChoice input
    while (sizeChoice < 1 || sizeChoice > 3) {
        ArraySize();
        System.out.print("               Choose array size [1-3]: ");
        if (scanner.hasNextInt()) {
            sizeChoice = scanner.nextInt();
            if (sizeChoice < 1 || sizeChoice > 3) {
                invalid();
                System.out.println("                                    Invalid input! Please enter a number between 1 and 3.");
                System.out.println("");
            }
        } else {
                invalid();
                System.out.println("                                    Invalid input! Please enter a number between 1 and 3.");
                System.out.println("");
            scanner.next(); 
        }
    }

    int size = switch (sizeChoice) {
        case 1 -> 1000;
        case 2 -> 10000;
        case 3 -> 100000;
        default -> 1000;
    };

    int[] arr = new int[size];
    Random rand = new Random();

    switch (type) {
        case 1: // Random
            for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size);
            break;
        case 2: // Sorted
            for (int i = 0; i < size; i++) arr[i] = i;
            break;
        case 3: // Reversed
            for (int i = 0; i < size; i++) arr[i] = size - i;
            break;
        case 4: // Nearly Sorted
            for (int i = 0; i < size; i++) arr[i] = i;
            for (int i = 0; i < size / 20; i++) {
                int a = rand.nextInt(size);
                int b = rand.nextInt(size);
                int temp = arr[a];
                arr[a] = arr[b];
                arr[b] = temp;
            }
            break;
    }

    return arr;
}

public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < arr.length; j++) {
            selectionSortSteps++; 
            if (arr[j] < arr[minIdx]) minIdx = j;
        }
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
    }
}

public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
        insertionSortSteps++;

            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

    public static void invalid(){
        System.out.print('\u000C');  
        System.out.println(" ");
        System.out.println(" - - - - - | | - - - - - - - - - - - - - - - >   I N V A L I D   I N P U T   < - - - - - - - - - - - - - - - - - | | - - - - -");
        System.out.println(" ");
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}


