import java.util.Scanner;

public class EmployeeBook {
    Scanner in = new Scanner(System.in);
    private static Employee[] storageOfWorkers;

    public EmployeeBook(int length) {
        storageOfWorkers = new Employee[length];
    }

    public static Employee[] getStorageOfWorkers() {return storageOfWorkers;}

    public void addWorker(Employee newWorker) {
        for(int i = 0; i < 10; i++) {
            if (storageOfWorkers[i] == null) {
                storageOfWorkers[i] = newWorker;
                break;
            }
        }
    }

    public void deleteWorker(String name) {
        for(int i = 0; i < 10; i++) {
            if (storageOfWorkers[i].getFullNameOfWorker().equals(name)) {
                storageOfWorkers[i] = null;
                break;
            }
        }
    }

    public void deleteWorker(int id) {
        for(int i = 0; i < 10; i++) {
            if (storageOfWorkers[i].getId() == id) {
                storageOfWorkers[i] = null;
                break;
            }
        }
    }

    public void changeWorker(String name) {
        String answerLine;
        String lineStripping;

        System.out.println("Вы хотите изменить зарплату сотрудника?(да/нет)");
        answerLine = in.nextLine();

        if (answerLine.equalsIgnoreCase("да")) {
            int newSalary;

            System.out.print("Введите новую зарплату: ");
            newSalary = in.nextInt();
            lineStripping = in.nextLine();

            for (int i = 0; i < 10; i++) {
                if (storageOfWorkers[i].getFullNameOfWorker().equals(name)) {
                    storageOfWorkers[i].setSalary(newSalary);
                    break;
                }
            }
        }

        System.out.println("Вы хотите изменить отдел сотрудника?(да/нет)");
        answerLine = in.nextLine();

        if (answerLine.equalsIgnoreCase("да")) {
            int newDepartment;

            System.out.print("Введите новый отдел: ");
            newDepartment = in.nextInt();
            lineStripping = in.nextLine();

            for (int i = 0; i < 10; i++) {
                if (storageOfWorkers[i].getFullNameOfWorker().equals(name)) {
                    storageOfWorkers[i].setDepartment(newDepartment);
                    break;
                }
            }
        }
    }

    public void workerNamesByDepartment() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Работники " + i + 1 + " отдела:");

            for (int j = 0; j < 10; j++) {
                if (storageOfWorkers[j].getDepartment() == (i + 1)){
                    System.out.println("\t" + storageOfWorkers[j].getFullNameOfWorker());
                }
            }
        }
    }

    public void allWorkerFullInfo() {
        for (int i = 0; i < Employee.getIdCount(); i++) {
            System.out.println(storageOfWorkers[i].toString());
        }
    }

    public void costsPerMonth() {
        int salaryAmount = 0;

        for (int i = 0; i < Employee.getIdCount(); i++) {
            salaryAmount += storageOfWorkers[i].getSalary();
        }

        System.out.println(salaryAmount);
    }

    public void minWorkerSalary() {
        int minSalary = storageOfWorkers[0].getSalary();
        int workerId = 0;

        for (int i = 1; i < Employee.getIdCount(); i++) {
            if (storageOfWorkers[i].getSalary() < minSalary) {minSalary = storageOfWorkers[i].getSalary(); workerId = i;}
        }

        System.out.println(storageOfWorkers[workerId].toString());
    }

    public void maxWorkerSalary() {
        int maxSalary = storageOfWorkers[0].getSalary();
        int workerId = 0;

        for (int i = 1; i < Employee.getIdCount(); i++) {
            if (storageOfWorkers[i].getSalary() > maxSalary) {maxSalary = storageOfWorkers[i].getSalary(); workerId = i;}
        }

        System.out.println(storageOfWorkers[workerId].toString());
    }

    public void averageSalary() {
        int salaryAmount = 0;

        for (int i = 0; i < Employee.getIdCount(); i++) {
            salaryAmount += storageOfWorkers[i].getSalary();
        }

        System.out.println(salaryAmount / (Employee.getIdCount()));
    }

    public void allWorkersName() {
        for (int i = 0; i < Employee.getIdCount(); i++) {
            System.out.println(storageOfWorkers[i].getFullNameOfWorker());
        }
    }

    public void salaryIndexation(int percent) {
        for (int i = 0; i < Employee.getIdCount(); i++) {
            int newSalary = (int)(storageOfWorkers[i].getSalary() + (storageOfWorkers[i].getSalary() * percent / 100));
            storageOfWorkers[i].setSalary(newSalary);
        }
    }

    public void minWorkerSalary(int department) {
        int minSalary;
        int iCount = 0;

        while (true) {
            if (storageOfWorkers[iCount].getDepartment() == department) {
                minSalary = storageOfWorkers[iCount].getSalary();
                break;
            }
            else {
                iCount++;
            }
        }

        int workerId = 0;

        for (int i = iCount; i < Employee.getIdCount(); i++) {
            if (storageOfWorkers[i].getDepartment() == department && storageOfWorkers[i].getSalary() <= minSalary) {
                minSalary = storageOfWorkers[i].getSalary();
                workerId = i;
            }
        }

        System.out.println(storageOfWorkers[workerId]);
    }

    public void maxWorkerSalary(int department) {
        int maxSalary = 0;
        int workerId = 0;

        for (int i = 0; i < Employee.getIdCount(); i++) {
            if (storageOfWorkers[i].getDepartment() == department && storageOfWorkers[i].getSalary() >= maxSalary) {
                maxSalary = storageOfWorkers[i].getSalary();
                workerId = i;
            }
        }

        System.out.println(storageOfWorkers[workerId]);
    }

    public void costsPerMonth(int department) {
        int salaryAmount = 0;

        for (int i = 0; i < Employee.getIdCount(); i++) {
            if (storageOfWorkers[i].getDepartment() == department) {
                salaryAmount += storageOfWorkers[i].getSalary();
            }
        }

        System.out.println(salaryAmount);
    }

    public void averageSalary(int department) {
        int salaryAmount = 0;
        int numbOfWorkers = 0;

        for (int i = 0; i < Employee.getIdCount(); i++) {
            if (storageOfWorkers[i].getDepartment() == department) {
                salaryAmount += storageOfWorkers[i].getSalary();
                numbOfWorkers++;
            }
        }

        System.out.println(salaryAmount / numbOfWorkers);
    }

    public void salaryIndexation(int department, int percent) {
        for (int i = 0; i < Employee.getIdCount(); i++) {
            if (storageOfWorkers[i].getDepartment() == department) {
                int newSalary = (int) (storageOfWorkers[i].getSalary() + (storageOfWorkers[i].getSalary() * percent / 100));
                storageOfWorkers[i].setSalary(newSalary);
            }
        }
    }

    public void allWorkerFullInfo(int department) {
        for (int i = 0; i < Employee.getIdCount(); i++) {
            if (storageOfWorkers[i].getDepartment() == department) {
                System.out.println(storageOfWorkers[i].getFullNameOfWorker() + " " +
                        storageOfWorkers[i].getSalary() + " " + storageOfWorkers[i].getId());
            }
        }
    }

    public void salaryMoreThanNumb(int numb) {
        for (int i = 0; i < Employee.getIdCount(); i++) {
            if (storageOfWorkers[i].getSalary() >= numb) {
                System.out.println(storageOfWorkers[i].getFullNameOfWorker() + " " +
                        storageOfWorkers[i].getSalary() + " " + storageOfWorkers[i].getId());
            }
        }
    }

    public void salaryLessThanNumb(int numb) {
        for (int i = 0; i < Employee.getIdCount(); i++) {
            if (storageOfWorkers[i].getSalary() < numb) {
                System.out.println(storageOfWorkers[i].getFullNameOfWorker() + " " +
                        storageOfWorkers[i].getSalary() + " " + storageOfWorkers[i].getId());
            }
        }
    }
}