public class Employee {
    private String fullNameOfWorker;
    private int department;
    private int salary;
    private int id;
    private static int idCount = 0;

    public Employee(String fullNameOfWorker, int department, int salary) {
        this.fullNameOfWorker = fullNameOfWorker;
        this.department = department;
        this.salary = salary;
        this.id = idCount;
        idCount++;
    }

    public String getFullNameOfWorker() {return this.fullNameOfWorker;}
    public int getDepartment() {return this.department;}
    public int getSalary() {return this.salary;}
    public int getId() {return this.id;}

    public void setDepartment(int department) {this.department = department;}
    public void setSalary(int salary) {this.salary = salary;}

    @Override
    public String toString() {return fullNameOfWorker + " " + department + " " + salary + " " + id;}

    public static void allWorkerFullInfo() {
        for (int i = 0; i < idCount; i++) {
            System.out.println(Main.storageOfWorkers[i].toString());
        }
    }

    public static int costsPerMonth() {
        int salaryAmount = 0;

        for (int i = 0; i < idCount; i++) {
            salaryAmount += Main.storageOfWorkers[i].salary;
        }

        return salaryAmount;
    }

    public static Employee minWorkerSalary() {
        int minSalary = Main.storageOfWorkers[0].salary;
        int workerId = 0;

        for (int i = 1; i < idCount; i++) {
            if (Main.storageOfWorkers[i].salary < minSalary) {minSalary = Main.storageOfWorkers[i].salary; workerId = i;}
        }

        return Main.storageOfWorkers[workerId];
    }

    public static Employee maxWorkerSalary() {
        int maxSalary = Main.storageOfWorkers[0].salary;
        int workerId = 0;

        for (int i = 1; i < idCount; i++) {
            if (Main.storageOfWorkers[i].salary > maxSalary) {maxSalary = Main.storageOfWorkers[i].salary; workerId = i;}
        }

        return Main.storageOfWorkers[workerId];
    }

    public static int averageSalary() {return costsPerMonth() / (idCount);}

    public static void allWorkersName() {
        for (int i = 0; i < idCount; i++) {
            System.out.println(Main.storageOfWorkers[i].fullNameOfWorker);
        }
    }

    public static void salaryIndexation(int percent) {
        for (int i = 0; i < idCount; i++) {
            int newSalary = (int)(Main.storageOfWorkers[i].salary + (Main.storageOfWorkers[i].salary * percent / 100));
            Main.storageOfWorkers[i].setSalary(newSalary);
        }
    }

    public  static Employee minWorkerSalary(int department) {
        int minSalary = Employee.maxWorkerSalary().salary;
        int workerId = 0;

        for (int i = 0; i < idCount; i++) {
            if (Main.storageOfWorkers[i].department == department && Main.storageOfWorkers[i].salary <= minSalary) {
                minSalary = Main.storageOfWorkers[i].salary;
                workerId = i;
            }
        }

        return Main.storageOfWorkers[workerId];
    }

    public  static Employee maxWorkerSalary(int department) {
        int maxSalary = Employee.minWorkerSalary().salary;
        int workerId = 0;

        for (int i = 0; i < idCount; i++) {
            if (Main.storageOfWorkers[i].department == department && Main.storageOfWorkers[i].salary >= maxSalary) {
                maxSalary = Main.storageOfWorkers[i].salary;
                workerId = i;
            }
        }

        return Main.storageOfWorkers[workerId];
    }

    public static int costsPerMonth(int department) {
        int salaryAmount = 0;

        for (int i = 0; i < idCount; i++) {
            if (Main.storageOfWorkers[i].department == department) {
                salaryAmount += Main.storageOfWorkers[i].salary;
            }
        }

        return salaryAmount;
    }

    public static int averageSalary(int department) {
        int salaryAmount = 0;
        int numbOfWorkers = 0;

        for (int i = 0; i < idCount; i++) {
            if (Main.storageOfWorkers[i].department == department) {
                salaryAmount += Main.storageOfWorkers[i].salary;
                numbOfWorkers++;
            }
        }

        return salaryAmount / numbOfWorkers;
    }

    public static void salaryIndexation(int department, int percent) {
        for (int i = 0; i < idCount; i++) {
            if (Main.storageOfWorkers[i].department == department) {
                int newSalary = (int) (Main.storageOfWorkers[i].salary + (Main.storageOfWorkers[i].salary * percent / 100));
                Main.storageOfWorkers[i].setSalary(newSalary);
            }
        }
    }

    public static void allWorkerFullInfo(int department) {
        for (int i = 0; i < idCount; i++) {
            if (Main.storageOfWorkers[i].department == department) {
                System.out.println(Main.storageOfWorkers[i].fullNameOfWorker + " " +
                        Main.storageOfWorkers[i].salary + " " + Main.storageOfWorkers[i].id);
            }
        }
    }

    public static void salaryMoreThanNumb(int numb) {
        for (int i = 0; i < idCount; i++) {
            if (Main.storageOfWorkers[i].salary >= numb) {
                System.out.println(Main.storageOfWorkers[i].fullNameOfWorker + " " +
                        Main.storageOfWorkers[i].salary + " " + Main.storageOfWorkers[i].id);
            }
        }
    }

    public static void salaryLessThanNumb(int numb) {
        for (int i = 0; i < idCount; i++) {
            if (Main.storageOfWorkers[i].salary < numb) {
                System.out.println(Main.storageOfWorkers[i].fullNameOfWorker + " " +
                        Main.storageOfWorkers[i].salary + " " + Main.storageOfWorkers[i].id);
            }
        }
    }
}