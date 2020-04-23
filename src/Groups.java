public class Groups {
    private static String[] names;

    private Groups(String[] names1) {
        names = names1;
    }

    public static String[] getNames() {
        new Groups(new String[]{"ПЭ", "ПИ", "ТП", "Архитектура"});
        return names;
    }
}
