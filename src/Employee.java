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

    public static int costsPerMonth() {
        int salaryAmount = 0;

        for (int i = 0; i < idCount; i++) {
            salaryAmount += Main.storageOfWorkers[i].salary;
        }

        return salaryAmount;
    }

    public static int minWorkerSalary() {
        int minSalary = Main.storageOfWorkers[0].salary;

        for (int i = 1; i < idCount; i++) {
            if (Main.storageOfWorkers[i].salary < minSalary) {minSalary = Main.storageOfWorkers[i].salary;}
        }

        return minSalary;
    }

    public static int maxWorkerSalary() {
        int maxSalary = Main.storageOfWorkers[0].salary;

        for (int i = 1; i < idCount; i++) {
            if (Main.storageOfWorkers[i].salary > maxSalary) {maxSalary = Main.storageOfWorkers[i].salary;}
        }

        return maxSalary;
    }

    public static float averageSalary() {return costsPerMonth() / (idCount);}

    public static void allWorkersName() {
        for (int i = 0; i < idCount; i++) {
            System.out.println(Main.storageOfWorkers[i].fullNameOfWorker);
        }
    }
}