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
import java.util.ArrayList;
public class ClassRoster {
    private ArrayList<Student> studentList;
    private ArrayList<Student> presentStudents;
    private ArrayList<Student> absentStudents;
    
    public ClassRoster () {
        absentStudents = new ArrayList<Student>();
        
        absentStudents.add(new Student("111111", "John"));
        absentStudents.add(new Student("222222", "James"));
        absentStudents.add(new Student("333333", "Jacob"));
    }
    
    public void LoadRoster (String file) {
        
    }
    
    public boolean inClass (String sentId) {
        for (int i = 0; i < studentList.size(); i++) {
            if (sentId.equals(studentList.get(i).getId())) {
                return true;
            }
        }
        return false;
    }
    
    public void checkStudentIn (String sentId) {
        for (int i = 0; i < absentStudents.size(); i++) {
            if (sentId.equals(absentStudents.get(i).getId())) {
                presentStudents.add(new Student(absentStudents.get(i).getId(), absentStudents.get(i).getName()));
                absentStudents.remove(i);
            }
        }
    }
    
    public boolean studentCheckedIn (String sentId) {
        for (int i = 0; i < presentStudents.size(); i++) {
            if (sentId.equals(presentStudents.get(i).getId())) {
                return true;
            }
        }
        return false;
    }
    
}
