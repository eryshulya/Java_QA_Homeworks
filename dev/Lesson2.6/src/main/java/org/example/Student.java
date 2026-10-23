package org.example;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Student {
   private String name;
   private String group;
   private int course;
   private Map<String,Integer> grades;
   private static final int MAX_COURSE = 6;
    public Student(String name, String group, int course,Map<String,Integer> grades){
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }
    public void setCourse(int course) {
        this.course = course;
    }
    public String getName() {
        return name;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public int getCourse() {
        return course;
    }
    public double getAverageGrades(){
        int sumGrades = 0;
        double averageGrade = 0;
        if (grades == null || grades.isEmpty()){
            return 0.0;
        }
      for (int value : grades.values()){
          sumGrades+=value;
      }
      averageGrade = sumGrades/grades.values().size();
      return averageGrade;
    }
    public static Set<Student> delete(Set<Student> students){
        Set<Student> set = new HashSet<>();
     for (Student student : students){
         double average = student.getAverageGrades();
         if(average >= 3){
            set.add(student);
         }
     }
     return set;
    }
    public static void transferStudents(Set<Student> students){
         for (Student student: students){
             if(student.getAverageGrades() >= 3 && student.getCourse() < MAX_COURSE){
               student.setCourse(student.getCourse() + 1);
             }
         }
    }
    public static void printStudents(Set<Student> students,int course){
        for (Student student: students){
            if(student.getCourse() == course){
                System.out.println(student.getName());
            }
        }
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }
}
