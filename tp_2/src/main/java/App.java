import java.util.*;
import java.util.stream.DoubleStream;

public class App {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Mohamed","IT",70000));
        employees.add(new Employee("Zineb","RH",8000));
        employees.add(new Employee("Ahmed","Marketing",12000));

        System.out.println("Utiliser mapToDouble et sum pour calculer la somme totale des salaires de tous les\n" + "employés.");

        double totalSalary  = employees.stream()
                .flatMapToDouble(employee -> DoubleStream.of(employee.getSalary()))
                .sum();
        System.out.println(totalSalary );

        System.out.println("Utiliser sorted pour trier la liste des employés par ordre alphabétique du nom.");

        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        System.out.println("Utiliser min pour trouver l'employé avec le salaire le plus bas.");

        Optional<Employee> employeeWithLowestSalary  = employees.stream()
                .min(Comparator.comparing(Employee::getSalary));
        System.out.println(employeeWithLowestSalary);


        Scanner scanner= new Scanner(System.in);
        System.out.print("Saisissez la valeur du salaire : ");
        double valeurSalaire = scanner.nextDouble();

        System.out.println("Utiliser filter pour obtenir la liste des employés ayant un salaire supérieur à une valeur\n" + "donnée.");
        employees.stream()
                .filter(employee -> employee.getSalary()>valeurSalaire)
                .forEach(System.out::println);


        System.out.println("Utilisez reduce pour trouver l'employé avec le salaire le plus élevé dans l'ensemble de\n" + "l'entreprise.");

        Optional<Employee> employeeWithHighestSalary = employees.stream()
                .reduce((employee1, employee2) -> employee1.getSalary() > employee2.getSalary() ? employee1 : employee2);
        System.out.println(employeeWithHighestSalary);

        System.out.println("Utilisez reduce pour concaténer les noms de tous les employés");

        String concatenatedNames = employees.stream()
                 .map(Employee::getName)
                 .reduce("",(name1, name2) -> name1 + " " + name2);
        System.out.println(concatenatedNames);



    }
}
