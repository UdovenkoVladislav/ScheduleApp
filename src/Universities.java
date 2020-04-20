public class Universities {
    private static String[] names;

    private Universities(String[] names) {
        this.names = names;
    }

    public static String[] getNames() {
        new Universities(new String[]{"ОмГТУ", "СибАДИ"});
        return names;
    }
}
