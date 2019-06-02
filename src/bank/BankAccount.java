package bank;

public class BankAccount{

    private int id, counter = 0;
    private String ownerName;
    private double sold;

    private Currency currency;

    public double getId() {
        return id;
    }


    public String getOwnerName(){
        return ownerName;
    }

    public BankAccount(String ownerName, Currency currency){
        counter++;
        id = counter;
        this.ownerName = ownerName;
        this.currency = currency;
    }

    public void depositMoney(double sum){
        sold += sum;
        System.out.println("You have: " + sold);
    }

    public void depositMoney(double sum, Currency currency){
        if (currency == this.currency){
            depositMoney(sum);
            return;
        }


        if (this.currency == Currency.RON){
            double a = convertToRON(sum, currency);
            depositMoney(a);
            return;
        }
        if (this.currency == Currency.USD){
            double a = convertToUSD(sum, currency);
            depositMoney(a);
            return;
        }
        if (this.currency == Currency.EUR){
            double a = convertToEUR(sum, currency);
            depositMoney(a);
            return;
        }
        if (this.currency == Currency.YEN){
            double a = convertToYEN(sum, currency);
            depositMoney(a);
            return;
        }


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
        System.out.println("Now, you have: " + sold);
    }

    public void withDrawMoney(double sum, Currency currency){
        if (currency == this.currency){
            withdrawMoney(sum);
            return;
        }

        if (this.currency == Currency.RON){
            double a = convertToRON(sum, currency);
            withdrawMoney(a);
            return;
        }
        if (this.currency == Currency.USD){
            double a = convertToUSD(sum, currency);
            withdrawMoney(a);
            return;
        }
        if (this.currency == Currency.EUR){
            double a = convertToEUR(sum, currency);
            withdrawMoney(a);
            return;
        }
        if (this.currency == Currency.YEN){
            double a = convertToYEN(sum, currency);
            withdrawMoney(a);
            return;
        }

    }

    public double convertToUSD(double u, Currency currency){
        if(currency == Currency.RON){
            u = u * 0.23;
            return u;
        }
        if(currency == Currency.EUR){
            u = u * 1.12;
            return u;
        }
        if (currency == Currency.YEN){
            u = u * 0.00915;
            return u;
        }
        return -1;
    }

    public double convertToEUR(double e, Currency currency){
        double d = e;
        if (currency != Currency.USD){
            d = convertToUSD(e, currency);
        }
        e = d * 0.895;
        return e;

    }

    public double convertToRON(double r, Currency currency){
        double d = r;
        if (currency != Currency.USD){
            d = convertToUSD(r, currency);
        }
        r = d * 4.248;
        return r;
    }

    public double convertToYEN(double y, Currency currency) {
        double d = y;
        if (currency != Currency.USD){
            d = convertToUSD(y, currency);
        }
        y = y * 108.28;
        return y;
    }

    public void creditCardNumber(String num){
        int sum=0;
        char[] c = num.toCharArray();

        int[] nr = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            nr[i] = c[i] - 48;
        }

        for (int i = c.length-2; i >= 0; i -= 2) {
            nr[i] = 2 * nr[i];
            if (nr[i] > 9){
                int a=nr[i];
                nr[i] = 0;
                while(a != 0){
                    nr[i] += a % 10;
                    a /= 10;
                }
            }
        }

        for (int i = 0; i < c.length; i++) {
            sum += nr[i];
        }

        if (sum % 10 == 0){
            System.out.println("Valid Card!");
        }else{
            System.out.println("Invalid Card!");
        }

    }


    public Currency getCurrency(){
        return this.currency;
    }


}
