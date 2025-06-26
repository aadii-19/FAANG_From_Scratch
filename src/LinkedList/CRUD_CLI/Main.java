package LinkedList.CRUD_CLI;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.println("\nHello "+name);
        while(true){
            System.out.println("==== LINKED LIST MAIN MENU ====");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Update");
            System.out.println("4. Get");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Size");
            System.out.println("8. Reverse");
            System.out.println("9. Convert from Array");
            System.out.println("10. Merge with another List");
            System.out.println("11. Clear");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    while(true){
                        System.out.println("\n--- INSERT MENU ---");
                        System.out.println("1. Insert at First");
                        System.out.println("2. Insert at Last");
                        System.out.println("3. Insert at Index");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Choice: ");
                        int insertChoice = sc.nextInt();

                        if(insertChoice==0) break;

                        System.out.print("Enter value: ");
                        int val = sc.nextInt();
                        switch(insertChoice){
                            case 1:
                                list.insertAtFirst(val);
                                break;
                            case 2:
                                list.insertAtLast(val);
                                break;
                            case 3:
                                System.out.print("Enter index: ");
                                int index = sc.nextInt();
                                list.insertAtIndex(index,val);
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    }
                    break;
                case 2:
                    while (true){
                        System.out.println("\n--- DELETE MENU ---");
                        System.out.println("1. Delete at First");
                        System.out.println("2. Delete at Last");
                        System.out.println("3. Delete at Index");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Choice: ");
                        int deleteChoice = sc.nextInt();

                        if(deleteChoice == 0) break;

                        switch (deleteChoice){
                            case 1:
                                list.deleteAtFirst();
                                break;
                            case 2:
                                list.deleteAtLast();
                                break;
                            case 3:
                                System.out.print("Enter Index: ");
                                int index = sc.nextInt();
                                list.deleteAtIndex(index);
                                break;
                            default:
                                System.out.println("Invalid Choice!");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter index: ");
                    int update_index = sc.nextInt();
                    System.out.println("Enter Value: ");
                    int update_val = sc.nextInt();
                    list.update(update_index,update_val);
                    break;
                case 4:
                    System.out.print("Enter the index: ");
                    int get_index = sc.nextInt();
                    try {
                        int value = list.get(get_index);
                        System.out.println("Value at index " + get_index + " is: " + value);
                    } catch (Exception e) {
                        System.out.println( e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter the element to Search: ");
                    int search_element = sc.nextInt();
                    int foundIndex = list.search(search_element);
                    if (foundIndex != -1) {
                        System.out.println("Element found at index: " + foundIndex);
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;
                case 6:
                    list.display();
                    break;
                case 7:
                    System.out.println("Size of LinkedList is: "+list.getSize());
                    break;
                case 8:
                    System.out.println("The reversed LinkedList: ");
                    list.reverse();
                    list.display();
                    break;
                case 9:
                    System.out.println("Enter Array Size: ");
                    int arr_size = sc.nextInt();
                    int[] arr = new int[arr_size];
                    System.out.print("Enter Elements");
                    for(int i=0; i<arr.length; i++){
                        arr[i] = sc.nextInt();
                    }
                    list.convert(arr);
                    break;
                case 10:
                    System.out.print("Enter size of second list to merge: ");
                    int mergeSize = sc.nextInt();
                    LinkedList second = new LinkedList();
                    System.out.println("Enter " + mergeSize + " sorted elements:");
                    for(int i = 0; i < mergeSize; i++) {
                        second.insertAtLast(sc.nextInt());
                    }
                    list = list.Merge(list, second);
                    System.out.println("Lists merged successfully.");
                    list.display();
                    break;
                case 11:
                    sc.nextLine();
                    System.out.print("Are you Sure? (Y/N)");
                    String ans = sc.nextLine();
                    if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")){
                        list.clear();
                    }
                    break;
                case 0:
                    System.out.println("Goodbye "+name+"!");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
