package in.freshnews.getnews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Students {
    private String name;
    private int grade;

    ArrayList<String> courseCollection;

    public Students(String name, int grade) {
        this.name = name;
        this.grade = grade;
        this.courseCollection = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public ArrayList<String> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(ArrayList<String> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public void addCourses(String courseName){
        courseCollection.add(courseName);
    }
    public void removeCourses(String courseName){
        courseCollection.remove(courseName);
    }
    public String displayStudentInfo(){
        return "name: " +getName()+" Grade: " +getGrade()+" courses: " +getCourseCollection();
    }


}
public class Demo {
    public static void main(String[] args) {
        Students S1 = new Students("jassi",12);
     /*   ArrayList coursecol = new ArrayList<>();
       coursecol.add("biology");
        coursecol.add("physics");
        S1.setCourseCollection(coursecol);*/

    //    S1.setCourseCollection(Arrays.asList("biology","khs"));


        S1.addCourses("Hindi");
        S1.addCourses("english");
        S1.addCourses("sanskrit");
        S1.removeCourses("english");
        String c = S1.displayStudentInfo();
        System.out.println(c);
    }
}
