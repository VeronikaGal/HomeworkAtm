package com.galeeva.homework;

/**
 * Создать класс, описывающий банкомат.
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 20, 50 и 100.
 * Сделать методы для добавления денег в банкомат.
 * Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение - успешность выполнения операции.
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 */
public class Atm {

    private int banknote20;
    private int banknote50;
    private int banknote100;

    public Atm(int banknote20, int banknote50, int banknote100) {
        this.banknote20 = banknote20;
        this.banknote50 = banknote50;
        this.banknote100 = banknote100;
    }

    public void addBanknote20(int banknote) {
        banknote20 += banknote;
    }

    public void addBanknote50(int banknote) {
        banknote50 += banknote;
    }

    public void addBanknote100(int banknote) {
        banknote100 += banknote;
    }

    public boolean withdrawMoney(int sumMoney) {
        int have = banknote100 * 100 + banknote50 * 50 + banknote20 * 20;
        if (have < sumMoney) {
            System.out.println("Don't have enough money. Available amount: " + have);
            return false;
        } else if (sumMoney % 10 != 0) {
            System.out.println("Wrong amount of money");
            return false;
        } else if (sumMoney % 20 != 0 && sumMoney < 50) {
            System.out.println("Wrong amount of money");
            return false;
        } else {
            print(sumMoney);
            return true;
        }
    }

    public void print(int sumMoney) {
        if (sumMoney % 100 == 10 || sumMoney % 100 == 30) {
            int amount100 = sumMoney / 100 - 1;
            int amount20 = (sumMoney - amount100 * 100 - 50) / 20;
            System.out.println("Banknote with a face value of 100: " + amount100 + "\nBanknote with a face value of 50: 1" +
                    "\nBanknote with a face value of 20: " + amount20);
        } else if (sumMoney % 50 == 10 || sumMoney % 50 == 30) {
            int amount100 = sumMoney / 100;
            int amount20 = (sumMoney - amount100 * 100) / 20;
            System.out.println("Banknote with a face value of 100: " + amount100 + "\nBanknote with a face value of 50: 0" +
                    "\nBanknote with a face value of 20: " + amount20);
        } else {
            int amount100 = sumMoney / 100;
            int amount50 = (sumMoney - amount100 * 100) / 50;
            int amount20 = (sumMoney - amount100 * 100 - amount50 * 50) / 20;
            System.out.println("Banknote with a face value of 100: " + amount100 + "\nBanknote with a face value of 50: " + amount50 +
                    "\nBanknote with a face value of 20: " + amount20);
        }
    }

    @Override
    public String toString() {
        return "Atm{" +
                "banknote20=" + banknote20 +
                ", banknote50=" + banknote50 +
                ", banknote100=" + banknote100 +
                '}';
    }
}


