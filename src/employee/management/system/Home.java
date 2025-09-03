package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;

public class Home extends JFrame implements ActionListener {

    JButton add, view, update, remove, salaryChart;

    Home() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employee");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);

//        salaryChart = new JButton("Salary Chart");
//        salaryChart.setBounds(735, 200, 150, 40);
//        salaryChart.addActionListener(this);
//        image.add(salaryChart);

        remove = new JButton("Remove Employee");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {

            setVisible(false);
            new AddEmployee();

        } else if (ae.getSource() == view) {

            setVisible(false);
            new ViewEmployee();

        } else if (ae.getSource() == update) {

            setVisible(false);
            new ViewEmployee();

        } else if (ae.getSource() == salaryChart) {

            showSalaryChart();

        } else {

            setVisible(false);
            new RemoveEmployee();

        }
    }

    private void showSalaryChart() {
        // Create a fixed list of designations and salaries
        String[][] data = {
                {"CEO", "200000"},
                {"CTO", "180000"},
                {"CFO", "170000"},
                {"COO", "160000"},
                {"CMO", "160000"},
                {"CIO", "160000"},
                {"IT Director", "150000"},
                {"Software Architect", "140000"},
                {"Development Manager", "130000"},
                {"Project Manager", "120000"},
                {"Technical Lead", "110000"},
                {"Senior Developer", "100000"},
                {"Developer", "90000"},
                {"System Administrator", "85000"},
                {"Database Administrator", "80000"},
                {"Network Engineer", "75000"},
                {"Security Analyst", "70000"},
                {"QA Engineer", "70000"},
                {"Business Analyst", "70000"},
                {"UI/UX Designer", "70000"},
                {"Technical Support", "65000"},
                {"DevOps Engineer", "75000"},
                {"Data Scientist", "120000"},
                {"Machine Learning Engineer", "130000"},
                {"AI Specialist", "140000"},
                {"Blockchain Developer", "110000"},
                {"Cloud Solutions Architect", "140000"},
                {"IT Consultant", "120000"},
                {"Cybersecurity Analyst", "110000"},
                {"Mobile App Developer", "100000"},
                {"Full Stack Developer", "100000"},
                {"Frontend Developer", "90000"},
                {"Backend Developer", "90000"},
                {"IT Support Specialist", "70000"},
                {"Help Desk Technician", "60000"},
                {"Intern", "40000"}
        };

        // Create a new frame for the fixed salary chart
        JFrame chartFrame = new JFrame("Salary Chart");
        chartFrame.setLayout(new BorderLayout());

        // Create a table model and populate it with the fixed data
        DefaultTableModel model = new DefaultTableModel(data, new String[]{"Designation", "Salary (BDT)"});

        // Create the JTable with a custom cell renderer
        JTable salaryTable = new JTable(model) {
            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                return new CustomTableCellRenderer();
            }
        };

        salaryTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        salaryTable.setFont(new Font("Serif", Font.PLAIN, 14));
        salaryTable.setRowHeight(30);

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(salaryTable);

        // Add the JScrollPane to the frame
        chartFrame.add(scrollPane, BorderLayout.CENTER);

        // Set frame properties
        chartFrame.setSize(700, 500);
        chartFrame.setLocationRelativeTo(null);
        chartFrame.setVisible(true);
    }

    private static class CustomTableCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {
        private static final int RIGHT_PADDING = 5; // Adjust the left padding as needed

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // Set the horizontal alignment to the left
            setHorizontalAlignment(SwingConstants.LEFT);
            // Add left padding
            setBorder(BorderFactory.createEmptyBorder(0, RIGHT_PADDING, 0, 0));
            return component;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}
