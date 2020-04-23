public class Universities {
    private static String[] names;

    private Universities(String[] names1) {
        names = names1;
    }

    public static String[] getNames() {
        new Universities(new String[]{"ОмГТУ", "СибАДИ"});
        return names;
    }
}
