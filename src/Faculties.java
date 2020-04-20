public class Faculties {
    private static String[] names;

    private Faculties(String[] names) {
        this.names = names;
    }

    public static String[] getNames() {
        new Faculties(new String[]{"Не выбрано","ФИТиКС","ФТНГ","РТФ","ФЭСиУ","ХТФ","ФГО","ФЭОиМ","ФДП",
                                                 "АДМ","АТ","ЗФ","ИСУ","НСТ","ПГС","ЭиУ"});
        return names;
    }
}
