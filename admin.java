public class admin extends user { 
    private Bank bank;
    public admin(String userName, String pin){
        this.userName = userName;
        this.pin = pin;
        this.bank = new Bank();
    
    }//end admin
    @Override 
    public void mnenu() {
        System.out.println("Welcome Admin " + userName);
        System.out.println("1. Create User");
        System.out.println("2. Delete User");
        System.out.println("3. View All Users");
        System.out.println("4. Exit");
    }//end menu
    @Override public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            mnenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    viewAllUsers();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }//end start
    @Override
    String getReport(){
        return "Admin Report for " + userName;
    }
}

