import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Gui {

    //------Ассоциации--------------
    private static Universities universityClass;
    private static Faculties facultyClass;
    private static Institutes instituteClass;
    private static Groups groupClass;
    private static Courses courseClass;
    private static Schedule scheduleClass;
    //------------------------------

    public static void App() {
        //Создадим окно и установим заголовок
        final JFrame window = new JFrame("Расписание занятий");

        //Событие "закрыть" при нажатии по крестику окна
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Создадим панель
        JPanel panel = new JPanel(new GridLayout(2, 1));

        //Создадим кнопки
        JButton button = new JButton("Показать расписание");

        //Создадим выпадающие списки
        JComboBox university = new JComboBox(universityClass.getNames());
        JComboBox faculty = new JComboBox(facultyClass.getNames());
        JComboBox institute = new JComboBox(instituteClass.getNames());
        JComboBox group = new JComboBox(groupClass.getNames());
        JComboBox course = new JComboBox(courseClass.getNames());

        //Создадим надписи возле списков
        JLabel university_1 = new JLabel("   Выберите Университет:");
        JLabel faculty_1 = new JLabel("   Выберите Факультет:");
        JLabel institute_1 = new JLabel("   Выберите Институт:");
        JLabel group_1 = new JLabel("   Выберите Группу:");
        JLabel course_1 = new JLabel("   Выберите Курс:");

        JPanel panel_data = new JPanel(new GridLayout(6, 2, 10, 10));
        panel_data.add(university_1);
        panel_data.add(university);

        panel_data.add(faculty_1);
        panel_data.add(faculty);

        panel_data.add(institute_1);
        panel_data.add(institute);

        panel_data.add(group_1);
        panel_data.add(group);

        panel_data.add(course_1);
        panel_data.add(course);

        DefaultTableModel model = new DefaultTableModel();
        JTable tableSchedule = new JTable(model);
        model.addColumn("Дата");
        model.addColumn("Время");
        model.addColumn("Дисциплина");
        model.addColumn("Преподаватель");

        JScrollPane scrollPane = new JScrollPane(tableSchedule);

        //Событие для кнопки "Показать расписание"
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] dataGroup = {
                        university.getSelectedItem().toString(),
                        faculty.getSelectedItem().toString(),
                        institute.getSelectedItem().toString(),
                        group.getSelectedItem().toString(),
                        course.getSelectedItem().toString()
                };
                ArrayList<String[]> sch = scheduleClass.getSchedule(dataGroup);
                for(String[] sch1 : sch){
                    model.addRow(sch1);
                }
            }
        });

        //Добавим кнопки и поля на панель
        panel.add(panel_data);
        panel_data.add(button);
        panel.add(scrollPane);

        //Добавим панель в окно
        window.getContentPane().add(panel);
        window.pack();

        //Разместим программу по центру
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
