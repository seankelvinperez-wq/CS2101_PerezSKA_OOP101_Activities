import java.util.Scanner;

class Menu {
    String fud;
    int aytem;
    double prays;

    Menu(String fud, int aytem, double prays) {
        this.fud = fud;
        this.aytem = aytem;
        this.prays = prays;
    }
}

class Student {
    double dis;
    double disPrice;
    double Total;

    Student(double price, double discountRate) {
        this.dis = discountRate;
        this.disPrice = this.dis * price;
        this.Total = price - this.disPrice;
    }
}

public class main {
    public static void main(String[] args) {
        Menu firstMenu = new Menu("Fries", 1, 30);
        Menu secondMenu = new Menu("Burger", 2, 50);
        Menu thirdMenu = new Menu("SpudTatas", 3, 200);
        Menu fourthMenu = new Menu("CLVB", 4, 120);
        Menu fifthMenu = new Menu("Brownies", 5, 30);
        int totalItems = 0;
        double totalBeforeDis = 0;
        double totalDis = 0;
        double finalPrice = 0;

        String again = "Y";

        while (again.equalsIgnoreCase("Y")) {
            Scanner input = new Scanner(System.in);
            System.out.println("=====   MENU    =====");
            System.out.printf("1. Fries      - $%.2f%n", firstMenu.prays);
            System.out.printf("2. Burger     - $%.2f%n", secondMenu.prays);
            System.out.printf("3. SpudTatas  - $%.2f%n", thirdMenu.prays);
            System.out.printf("4. CLVB       - $%.2f%n", fourthMenu.prays);
            System.out.printf("5. Brownies   - $%.2f%n", fifthMenu.prays);
            System.out.print("Enter item number: ");
            int choi = input.nextInt();
            while (choi < 1 || choi > 5) {
                System.out.println("Invalid Character. Choose again: ");
                choi = input.nextInt();
            }
            System.out.print("Enter quantity: ");
            int quanti = input.nextInt();

            System.out.print("Are you a Student? (Y/N): ");
            String answer = input.next();

            double price = 0;

            switch (choi) {
                case 1: price = firstMenu.prays; break;
                case 2: price = secondMenu.prays; break;
                case 3: price = thirdMenu.prays; break;
                case 4: price = fourthMenu.prays; break;
                case 5: price = fifthMenu.prays; break;
            }

            double subtotal = price * quanti;
            System.out.printf("Subtotal: $%.2f%n", subtotal);

            boolean isStu = answer.equalsIgnoreCase("Y");


            double bulkRate = (subtotal > 500) ? 0.05 : 0.0;

            double discountRate;
            if (isStu) {
                discountRate = 0.10 + bulkRate;
            } else {
                discountRate = bulkRate;
            }

            Student s = new Student(subtotal, discountRate);

            System.out.printf("Discount: $%.2f%n", s.disPrice);
            System.out.printf("Total: $%.2f%n", s.Total);

            // Add this order to the running totals
            totalItems += quanti;
            totalBeforeDis += subtotal;
            totalDis += s.disPrice;
            finalPrice += s.Total;

            System.out.print("Do you want to order again? (Y/N): ");
            again = input.next();
        }

        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n", totalBeforeDis);
        System.out.printf("Total discount: $%.2f%n", totalDis);
        System.out.printf("Final amount: $%.2f%n", finalPrice);
        System.out.printf("Thank you for ordering!%n");

    }
}
