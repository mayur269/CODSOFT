public class main {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(5000); // Initial balance of ₹5000
        ATM atm = new ATM(myAccount);
        atm.showATMInterface();
    }
}
