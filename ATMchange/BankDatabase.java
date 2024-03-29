public class BankDatabase {
    private Account[] accounts; // array of Accounts

    public BankDatabase() {
        accounts = new Account[4]; // just 4 accounts for testing
        accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
        accounts[1] = new Account(8765, 5678, 200.0, 400.0);  
        accounts[2] = new Account(1111, 1111, 300.0, 400.0);  
        accounts[3] = new Account(12121, 8989, 500.0, 700.0);  
    }
   
    private Account getAccount(int accountNumber) {
        for (Account currentAccount : accounts)
        {
            // return current account if match found
            if (currentAccount.getAccountNumber() == accountNumber)
                return currentAccount;
        } // end for

        return null;
    //      return null; // if no matching account was found, return null
    } 

    public boolean findNumberAccount(int userAccountNumber){
        Account userAccount = getAccount(userAccountNumber);

        // if account exists, return result of Account method validatePIN
        if (userAccount != null) {
            return true;
        }else {
            return false; // account number not found, so return false
        }
    }
    
    public boolean authenticateUser(int userAccountNumber, int userPIN) {
        // attempt to retrieve the account with the account number
        Account userAccount = getAccount(userAccountNumber);

        // if account exists, return result of Account method validatePIN
        if (userAccount != null) {
            return userAccount.validatePIN(userPIN);
        }
        else {
            return false; // account number not found, so return false
        }
    } 

    public double getAvailableBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getAvailableBalance();
    } 

    public double getTotalBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getTotalBalance();
    } 

    public void credit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).credit(amount);
    }

    public void debit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).debit(amount);
    } 
   
} 