package bank;

public class BankAccount{

    private int id;
    private String ownerName;
    private double sold;

    private Currency currency;

    public double getId() {
        return id;
    }


    public String getOwnerName(){
        return ownerName;
    }



    public double getSold() {
        return sold;
    }

    public void withdrawMoney(double sum){
        if(sum > this.sold){
            System.out.println("You have not enough money!");
            return;
        }
        sold = sold - sum;

    }

    public void withDrawMoney(double sum, Currency currency){
        if (currency == this.currency){
            withdrawMoney(sum);
            return;
        }

        if (currency == Currency.RON){
            Currency.RON.convertToRON();
            return;
        }else if (currency == Currency.USD){
            Currency.USD.convertToUSD();
            return;
        }else if (currency == Currency.EUR){
            Currency.EUR.convertToEUR();
            return;
        }else{
            Currency.YEN.convertToYEN();
            return;
        }

    }

    public Currency getCurrency(){
        return currency;
    }


}
