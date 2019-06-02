package bank;

public enum Currency {
    RON(0.23),
    USD(1),
    EUR(1.12),
    YEN(0.00915);

    double currency;

    Currency(double currency){
        this.currency = currency;
    }

    public double getCurreny(){
        return this.currency;
    }

}
