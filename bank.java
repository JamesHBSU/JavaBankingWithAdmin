public class bank {
    private arrayList<customer> customers;
    public bank(){
        customers = new customers();
       loadAccounts(); 
    }//end bank
    public void addCustomer(Customer customer){
        customers.add(customers);
        saveAccounts();
    }//end addCustomer
    public void viewCustomers(){
        for(Customer customer : customers){
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Customer Balance: " + customer.getBalance());
            System.out.println("---------------------------");
        }//end for
    }//end viewCustomers
    public static void Customer searchCustomer(String userName){
        for(Customer customer : customers){
            if(customer.getuserName().equals(userName)){
                return customer;
            }//end if
            }//end for
            return null;
        }//end searchCutomer
        public void deleteCustomer(String userName){
            Customer customer = searchCustomer(userName);
            if(customer != null){
                customers.remove(customer);
                saveAccounts();
            }
            else{
                System.out.println("Customer not found.");
            }//end else
        }//end deleteCustomer
    }//end bank

