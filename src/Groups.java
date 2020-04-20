public class Groups {
    private static String[] names;

    private Groups(String[] names) {
        this.names = names;
    }

    public static String[] getNames() {
        new Groups(new String[]{"ПЭ", "ПИ", "ТП"});
        return names;
    }
}
