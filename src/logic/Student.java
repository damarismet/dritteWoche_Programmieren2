package logic;

import java.util.ArrayList;

public class Student {

    public Student() {
    }

    private String name;
    private String major;
    private ArrayList<Double> gradeList;

    public Student(String name, String major, ArrayList<Double> gradeList) {
        this.name = name;
        this.major = major;
        this.gradeList = gradeList;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }


    public ArrayList<Double> getGradeList() {
        return gradeList;
    }

    public double getAverage() {
        double lowestgrade;
        double summe;
        double average;
        summe = 0;
        lowestgrade = gradeList.get(0);
        for (int j = 0; j < gradeList.size(); j++) {
            if (lowestgrade > gradeList.get(j)) {
                lowestgrade = gradeList.get(j);
            }
            summe = summe + gradeList.get(j);
        }
        summe = summe - lowestgrade;
        average = summe / ((gradeList.size() - 1));
        return average;
    }

}


