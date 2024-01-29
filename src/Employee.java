public class Employee {
    private String fullNameOfWorker;
    private int department;
    private int salary;
    private int id;
    private static int idCount;

    public Employee(String fullNameOfWorker, int department, int salary) {
        this.fullNameOfWorker = fullNameOfWorker;
        this.department = department;
        this.salary = salary;
        this.id = idCount;
        idCount++;
    }

    public String getFullNameOfWorker() {
        return this.fullNameOfWorker;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return fullNameOfWorker + " " + department + " " + salary + " " + id;
    }
}