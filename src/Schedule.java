import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Schedule {
    //------Ассоциации--------------
    private static Universities university;
    private static Faculties faculty;
    private static Institutes institute;
    private static Groups group;
    private static Courses course;
    //------------------------------
    private static String[] schedule;

    private Schedule(String[] schedule) {
        this.schedule = schedule;
    }

    public static String[] getSchedule(String[] dataGroup) {
        new Schedule(getScheduleDataBase(dataGroup));
        return schedule;
    }

    private static String[] getScheduleDataBase(String[] dataGroup) {
        String[] p = {"нет", "нет", "нет", "нет"};//пустой массив с расписанием
        try (Scanner sc = new Scanner(new File("dataBaseSchedule.txt"))) {
            while (sc.hasNext()) {
                String[] split1 = sc.nextLine().split(";");
                String[] split2 = split1[0].split(",");
                String[] split3 = split1[1].split(",");
                if (Arrays.equals(dataGroup, split2)) return split3;
            }
            return p;
        }
        catch (FileNotFoundException ex) {
            return p;
        }
    }
}