/*This menu driven program of to do list is originally written by Manish Tiwari. This is just for learning and improving my skills 
*/
import java.util.*;
public class ToDoList {
    public static HashMap<Integer, String> user_list = new HashMap<Integer, String>();
    public static HashMap<Integer, String> user_list_completed = new HashMap<Integer, String>();
    static void start(){
      System.out.println("####################################################################");
      System.out.println("To Do List Menu: ");
      System.out.println("1. Create To Do List");
      System.out.println("2. View To Do List");
      System.out.println("3. Mark item completed in To Do List");
      System.out.println("4. Exit");
      System.out.println("####################################################################");
      System.out.println();
      System.out.println("Please select the operation you want to perform");
      Scanner sc = new Scanner(System.in);
      int option = sc.nextInt();
      switch(option){
        case 1:
            create_to_do_list();
            break;
        case 2:
            view_to_do_list(user_list);
            break;
        case 3:
            mark_complete_to_do_list(user_list, user_list_completed);
            break;
        case 4:
            System.out.println("Thank you for using our To Do List");
            break;
        default:
            System.out.println("Invalid User Input");
            start();
      }
    }
    
    static void display(){
        for(int key : user_list.keySet()){
            System.out.println(key + ". " + user_list.get(key));
        }
    }
    
    static void create_to_do_list(){
        int i = 1;
        System.out.println("Please enter your items: ");
        Scanner sc_user = new Scanner(System.in);
        while(sc_user.hasNext()){
            String str = sc_user.nextLine();
            user_list.put(i, str);
            System.out.println("Do you want to add more items? (Y/N)");
            sc_user.hasNext();
            if (!sc_user.nextLine().equalsIgnoreCase("y")) {
                break;
            }
            i++;
        }
        System.out.println("Your To do list is created.");
        System.out.println();
        start();
    }
    
    static void view_to_do_list(HashMap<Integer, String> user_list){
        System.out.println("Your created to-do list: ");
        display();
        System.out.println();
        start();
    }
    
    static void mark_complete_to_do_list(HashMap<Integer, String> user_list, HashMap<Integer, String> user_list_completed){
        Scanner sc_user_num = new Scanner(System.in);
        System.out.println("Which item you want to marked as completed ?");
        display();
        System.out.println("Please make sure before marking any item completed, this operation cannot be undone.");
        System.out.println("Press(Y/N) Y for continue and N for main menu");
        if (!sc_user_num.nextLine().equalsIgnoreCase("Y")) {
            start();
        }
        System.out.println("Please enter number: ");
        while(sc_user_num.hasNext()){
            int entered_value = sc_user_num.nextInt();
            if(user_list.containsKey(entered_value)){
                user_list_completed.put(entered_value, user_list.get(entered_value));
                user_list.remove(entered_value);
            }
            else{
                System.out.println("Wrong user input. There is no such item in the list.");
                break;
            }
            System.out.println("Press Y now.");
            sc_user_num.hasNext();
            if (!sc_user_num.nextLine().equalsIgnoreCase("y")) {
                break;
            }
        }
        if(user_list.size() != 0){
            System.out.println("Pending items in To Do List: ");
            display();
            System.out.println();
            System.out.println("Mark Completed items in To Do List: ");
            for(int key_completed : user_list_completed.keySet()){
            System.out.println(key_completed + ". " + user_list_completed.get(key_completed));
            }
            System.out.println();
        }
        else{
            System.out.println("Hurrah! You have completed all the items in to do list.");
            System.out.println();
        }
        System.out.println();
        start();
    }
    
    public static void main(String args[]) {
      start();
    }
}