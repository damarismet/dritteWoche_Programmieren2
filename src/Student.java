import java.util.ArrayList;

public class Student {

    public Student() {
    }

    private String name;
    private String major;
    private ArrayList<Double> gradeList = new ArrayList<>();

    public Student(String name, String major, ArrayList<Double> gradeList) {
        this.name = name;
        this.major = major;
        this.gradeList = gradeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public ArrayList<Double> getGradeList() {
        return gradeList;
    }

    public void setGradeList(ArrayList<Double> gradeList) {
        this.gradeList = gradeList;
    }

    static void displayAverageGrades(ArrayList<Student> studentList) {
        double summe = 0;
        double lowestgrade = 0;
        double average = 0;

        for (Student student : studentList) {
            summe = 0;
            lowestgrade = student.getGradeList().get(0);
            for (int j = 0; j < student.getGradeList().size(); j++) {
                if (lowestgrade > student.getGradeList().get(j)) {
                    lowestgrade = student.getGradeList().get(j);
                }
                summe = summe + student.getGradeList().get(j);
            }
            summe = summe - lowestgrade;
            average = summe / ((student.getGradeList().size() - 1));
            System.out.println("The average grade for " + student.getName() + " (" + student.getMajor() + ") is: " + Math.round(average * 10) / 10.0);
        }
    }
}


