import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class WeekValue
    {
        public int number_of_days=7;
        public float[] days = new float[number_of_days];
        public WeekValue(float[] days)
        {
            days = new float[7];
            System.arraycopy(days, 0, this.days, 0, 7);
        }
        //calculate total regular hours
        public float calculateRegularHours()
        {
            float totalHrs = 0f;
            for (float day : days) { //for each loop
                if (day <= 8) {
                    totalHrs += day;
                } else {
                    totalHrs += 8;
                }
            }
            return totalHrs;
        }

        //calculate total overtime hours
        public float calculateOverTimeHours()
        {
            float totalHrs = 0f;
            for (float day : days) {
                if (day > 8) {
                    totalHrs += day - 8;
                }
            }
            return totalHrs;
        }
    };
public class Employee  extends JFrame {
    /*Sorry I have named the days so weird.
    f->short form for first
    D->short form for day
    T/t->short form for third
    S/s->short form for second

     */

        private JTextField empName;
        private JTextField salaryPerHour;
        private JTextField FirstDayOfWeek1;
        private JTextField secondDayOfWeek1;
        private JTextField thirdDayOfWeek1;
        private JTextField fourthDayOfWeek1;
        private JTextField fifthDayOfWeek1;
        private JTextField sixthDayOfWeek1;
        private JTextField seventhDayOfWeek1;
        private JTextField firstDayOfWeek2;
        private JTextField secondDayOfWeek2;
        private JTextField thirdDayOfWeek2;
        private JTextField fourthDayOfWeek2;
        private JTextField fifthDayOfWeek2;
        private JTextField sixthDayOfWeek2;
        private JTextField seventhDayOfWeek2;
        private JTextField regularHours;
        private JTextField regularHoursPayableAmount;
        private JTextField overtimeHours;
        private JTextField overtimePayableAmount;
        private JTextField netPay;
        private JButton processItButton;
        private JButton closeButton;
        private JPanel mainPanel;

        public Employee() {
            processItButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    float[] hoursForWeek1 = {
                            Float.parseFloat(FirstDayOfWeek1.getText()),
                            Float.parseFloat(secondDayOfWeek1.getText()),
                            Float.parseFloat(thirdDayOfWeek1.getText()),
                            Float.parseFloat(fourthDayOfWeek1.getText()),
                            Float.parseFloat(fifthDayOfWeek1.getText()),
                            Float.parseFloat(sixthDayOfWeek1.getText()),
                            Float.parseFloat(seventhDayOfWeek1.getText())
                    };
                    //Reading week2 data
                    float [] hoursForWeek2 = {
                            Float.parseFloat(firstDayOfWeek2.getText()),
                            Float.parseFloat(secondDayOfWeek2.getText()),
                            Float.parseFloat(thirdDayOfWeek2.getText()),
                            Float.parseFloat(fourthDayOfWeek2.getText()),
                            Float.parseFloat(fifthDayOfWeek2.getText()),
                            Float.parseFloat(sixthDayOfWeek2.getText()),
                            Float.parseFloat(seventhDayOfWeek2.getText())};

                    //Creating week objects
                    Week weekOne = new Week(new float[7]);
                    Week weekTwo = new Week(new float[7]);
                    //Copying arrays
                    System.arraycopy(hoursForWeek1, 0, weekOne.days, 0, 7);
                    System.arraycopy(hoursForWeek2, 0, weekTwo.days, 0, 7);

                    float hourPay = Float.parseFloat(salaryPerHour.getText());
                    float regularPay, overPayment, netPayment, overTimeRate = 152.79f/5.5f;


                    regularPay = (weekOne.calcRegular() + weekTwo.calcRegular()) * hourPay;
                    overPayment = (weekOne.calcOvertime() + weekTwo.calcOvertime())* overTimeRate;
                    netPayment = regularPay + overPayment;


                    regularHours.setText(String.format("%.1f",  (regularPay / hourPay)));
                    overtimeHours.setText(String.format("%.1f", (overPayment / overTimeRate)));
                    regularHoursPayableAmount.setText(String.format("%.2f", regularPay));
                    overtimePayableAmount.setText(String.format("%.2f", overPayment));
                    netPay.setText(String.format("%.2f", netPayment));

                }
            });
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    dispose();
                }
            });
        }

        public static void main(String[] args) {
            Employee use= new Employee();
            use.setContentPane(use.mainPanel);
            use.setTitle("GeorgeTown Cleaning Services-Employee PayRoll");
            //JColorChooser(#FFF);
            int width = 1000, height = 400;
            use.setSize(width, height);

            int x = (1390 - width) / 2;
            int y = (760 - height) / 2;
            use.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            use.setVisible(true);

        }
    }


