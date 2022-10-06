import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reader {

    public static ArrayList<Student> readData(File file){
        ArrayList<Student> studentList = new ArrayList<Student>();
        String studentName = "";
        String major = "";

        HashMap<String,String> majors = (HashMap<String, String>) readMajorMap();

        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                ArrayList<Double> listOfDouble = new ArrayList<Double>();
                String text = scanner.nextLine();
                String[] elements = text.split(", ");

                boolean firstItem = true;

                for(String s: elements){
                    if (firstItem){
                        studentName = s;
                        firstItem = false;
                    } else {
                        if (majors.containsKey(s)) {
                            major = majors.get(s);
                        }
                        else {
                            listOfDouble.add(Double.parseDouble(s));
                        }
                    }
                }
                Student student = new Student(studentName, major, listOfDouble);
                studentList.add(student);
            }
            scanner.close();
        }catch (IOException e){
            System.out.println(e);
        }
        return studentList;
    }

    public static Map<String, String> readMajorMap() {
        HashMap<String, String> map = new HashMap<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/damarismettler/Desktop/Studium FHNW/3. Semester/Programmieren2/zweiteWoche_Prorgammieren2/src/ch/fhnw/HW/major-map.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] keyValuePair = line.split("\t");
                if (keyValuePair.length > 1) {
                    String key = keyValuePair[0].trim();
                    String value = keyValuePair[1].trim();
                    map.put(key, value);
                }
                else {
                    System.out.println("No Key:Value found in line, ignoring: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}