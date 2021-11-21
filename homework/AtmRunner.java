package com.galeeva.homework;

public class AtmRunner {

    public static void main(String[] args) {
        Atm atm = new Atm(10, 2, 10);
        atm.addBanknote20(10);
        atm.addBanknote50(2);
        atm.addBanknote100(1);
        System.out.println(atm.toString());
        boolean withdrawMoney = atm.withdrawMoney(110);
        System.out.println(withdrawMoney);
    }
}
