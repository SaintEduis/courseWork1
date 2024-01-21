import java.util.Scanner;

public class Main {
    public static Employee[] storageOfWorkers = new Employee[10];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String lineStripping;
        String checkOfContinue;
        String fullNameOfWorker;
        int department;
        int salary;

        System.out.println("Вы можете внести до 10 сотрудников.");

        for (int i = 0; i < 10; i++) {
            System.out.print("Введите Ф.И.О. сотрудника: ");
            fullNameOfWorker = in.nextLine();
            System.out.print("Введите номер отдела сотрудника: ");
            department = in.nextInt();
            System.out.print("Введите зарплату сотрудника: ");
            salary = in.nextInt();
            lineStripping = in.nextLine();

            storageOfWorkers[i] = new Employee(fullNameOfWorker, department, salary);

            System.out.println("Хотите продолжить?(да/нет)");
            checkOfContinue = in.nextLine();
            if (checkOfContinue.equalsIgnoreCase("нет")) {break;}
        }
    }
}