/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlogin;

/**
 *
 * @author ehartml624
 */
import java.util.Scanner;
public class LoginDriver {
    public static ClassRoster roster;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        roster = new ClassRoster();
        Scanner input = new Scanner(System.in);
        String admin, adminPin;
        boolean loggedIn = false;
        boolean exit = false;
        while (!exit) {
            do {
                System.out.print("Enter in admin ID: ");
                admin = input.nextLine();

                System.out.print("Enter in admin pin: ");
                adminPin = input.nextLine();

                if (admin.equals("123456") && adminPin.equals("9891")) {
                    System.out.println("System Closing");
                    loggedIn = false;
                    exit = true;
                    break;
                }
                else if (!admin.equals("123456") || !adminPin.equals("1989")) {
                    System.out.println("Incorrect Login");
                }
                else {
                    loggedIn = true;
                    System.out.println("Successful log in.");
                }
                
                

            }
            while (!"123456".equals(admin) || !"1989".equals(adminPin));

            
            
            while (loggedIn) {
                int classChoice = -1;
                boolean takingAttendance = false;
                System.out.println("Select class for attendance: ");
                /*
                System.out.println("0. AP Comp Sci");
                System.out.println("1. Programming 1-2");
                System.out.println("2. Game Design 1-2");
                System.out.println("3. Digital Media");
                System.out.println("4. Programming 1-2");
                System.out.println("5. Hudl");*/
                System.out.println("6. Game Club");
                System.out.println("7. Logout");

                do {
                    System.out.print("Select: ");
                    classChoice = input.nextInt();
                    input.nextLine();
                    if (classChoice < 6 || classChoice > 7) {
                        System.out.println("Invalid, please select valid class");
                    }
                }
                while (classChoice < 6 || classChoice > 7);

                String studentId;
                switch (classChoice) {
                    case 6:
                    // load up class roster for after school club
                    takingAttendance = true;
                    break;
                    case 7:
                        loggedIn = false;
                        System.out.println("Logged out");
                        break;
                }
                
                do {
                    System.out.print ("Enter in id: ");
                    studentId = input.nextLine();
                    
                    roster.checkStudentIn(studentId);

                    if (studentId.equals("123456")) {
                        System.out.println("Attendance Recorded");
                        takingAttendance = false;
                    } 
                    else if (roster.studentCheckedIn(studentId)) {
                        System.out.println("Student already checked in");
                    }
                    else if (!roster.inClass(studentId)) {
                        System.out.println("Student id does not match student in class");
                    }
                        
                }
                while (takingAttendance && !roster.inClass(studentId));

                //System.out.println("The following are students not in class:");
                
            }
        }
    }  
}
