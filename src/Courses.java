public class Courses {
    private static String[] names;

    private Courses(String[] names1) {
        names = names1;
    }

    public static String[] getNames() {
        new Courses(new String[]{"1", "2", "3", "4", "5", "6"});
        return names;
    }
}
