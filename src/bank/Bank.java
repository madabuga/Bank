package bank;

public class Bank {

    private int counter = 0;

    private BankAccount[] bankAccounts = new BankAccount[7];

    private Bank(){
    }


    public void registerBankAccount(BankAccount account){
        if(counter + 1 > this.bankAccounts.length) {
            doubleArray();
        }
        System.out.println("A new bank account have been added!" + account.getId());
        bankAccounts[counter] = account;
        counter++;
    }

    public void doubleArray(){
        BankAccount[] nouArray = new BankAccount[bankAccounts.length * 2];

        for (int i = 0; i < bankAccounts.length; i++) {
            nouArray[i] = bankAccounts[i];
        }
        bankAccounts = nouArray;
    }

    public void deleteBankAccount(BankAccount account) {
        int i = findIdBankAccount(account);
        if (i == -1) {
            System.out.println("That account doesn't exist!");
            return;
        }

        for (int j = i; j < counter - 1; j++) {
            bankAccounts[j] = bankAccounts[j + 1];
        }
        System.out.println("S-a STERS un contribuabil " + account.getId());
        bankAccounts[counter - 1] = null;
        counter--;

    }

    public int findIdBankAccount(BankAccount bankAccount){
        int low = 0;
        int high = counter;
        while(low <= high){
            int mid = (low + high)/2;
            if(bankAccount.getId() < mid){
                high = mid - 1;
            }
            if(bankAccount.getId() > mid){
                low = mid + 1;
            }
            if(bankAccount.getId() == mid){
                return mid;
            }
        }

        return -1;
    }

    public int getNumberOfTotalAccounts(){
        return counter;
    }


}
