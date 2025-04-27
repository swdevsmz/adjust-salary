package org.example;

import java.math.BigDecimal;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {

        final BigDecimal[] salaries = new BigDecimal[]{
            BigDecimal.valueOf(5000000), // 0
                    BigDecimal.valueOf(6000000), // 1
                    BigDecimal.valueOf(5000000), // 2
                    BigDecimal.valueOf(10000000), // 3
                    BigDecimal.valueOf(10000000), // 4
                    BigDecimal.valueOf(10000000), // 5
                    BigDecimal.valueOf(8000000), // 6
                    BigDecimal.valueOf(8000000), // 7
                    BigDecimal.valueOf(8000000), // 8
                    BigDecimal.valueOf(12000000), // 9
                    BigDecimal.valueOf(12000000), // 10
                    BigDecimal.valueOf(-32000000), // 9
        };

        // 給料が次の変更点までに滑らかな線になる一次関数的に上がる、下がるように調整する
        final BigDecimal[] adjustedSalaries = new Salary().adjustSalary(salaries);

        for (BigDecimal salary : adjustedSalaries) {
            System.out.println(salary);
        }
    }
}