import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Schedule {
    //------Ассоциации--------------
    private static Universities university;
    private static Faculties faculty;
    private static Institutes institute;
    private static Groups group;
    private static Courses course;
    //------------------------------
    private static ArrayList<String[]> schedule = new ArrayList<String[]>();

    private Schedule(ArrayList<String[]> schedule) {
        this.schedule = schedule;
    }

    public static ArrayList<String[]> getSchedule(String[] dataGroup) {
        new Schedule(getScheduleDataBase(dataGroup));
        return schedule;
    }

    private static ArrayList<String[]> getScheduleDataBase(String[] dataGroup) {
        String[] p = {"нет", "нет", "нет", "нет"};//пустой массив с расписанием
        ArrayList<String[]> pus = new ArrayList<String[]>();
        pus.add(p);
        ArrayList<String[]> scheduleGroup = new ArrayList<String[]>();
        try (Scanner sc = new Scanner(new File("dataBaseSchedule.txt"))) {
            while (sc.hasNext()) {
                String[] split1 = sc.nextLine().split(";");
                String[] split2 = split1[0].split(",");
                String[] split3 = split1[1].split(",");
                if (Arrays.equals(dataGroup, split2)) scheduleGroup.add(split3);
            }
            if (scheduleGroup.size() == 0) {
                return pus;
            } else return scheduleGroup;
        }
        catch (FileNotFoundException ex) {
            return pus;
        }
    }
}