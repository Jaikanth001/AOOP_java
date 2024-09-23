package solid;

public class Main {
    public static void main(String[] args) {
        // SRP
        Employee emp = new Employee("John Doe", "Developer");
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        System.out.println("Salary: " + salaryCalculator.calculateSalary(emp));

        // OCP
        Shape rectangle = new Rectangle(5, 10);
        Shape circle = new Circle(7);
        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Circle Area: " + circle.calculateArea());

        // LSP
        Bird bird = new Bird();
        bird.fly();
        Bird ostrich = new Ostrich();
        try {
            ostrich.fly();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        // ISP
        Worker robot = new Robot();
        robot.work();
        Worker human = new Human();
        human.work();
        ((Eater) human).eat();

        // DIP
        MessageService emailService = new EmailService();
        MessageService smsService = new SMSService();
        MyApplication app = new MyApplication(emailService);
        app.sendMessage("Hello via Email");
        app = new MyApplication(smsService);
        app.sendMessage("Hello via SMS");
    }
}
