import java.util.Arrays;

public class Schedule {
    //------Ассоциации--------------
    private static Universities university;
    private static Faculties faculty;
    private static Institutes institute;
    private static Groups group;
    private static Courses course;
    //------------------------------
    private static String[] schedule;
    private static String[][] scheduleGroup;

    private Schedule(String[] schedule) {
        this.schedule = schedule;
    }

    public static String[] getSchedule(String[] dataGroup) {
        new Schedule(new String[]{"20.04.2020", "11:35", "Конструирование ПО", "Убалехт"});
        String[] groupInfo = {university.getNames()[0],faculty.getNames()[1],
                institute.getNames()[0],group.getNames()[0],course.getNames()[2]};
        if (Arrays.equals(dataGroup, groupInfo)) {
            return schedule;
        }
        else {
            return new String[]{"нет", "нет", "нет", "нет"};
        }
    }
}