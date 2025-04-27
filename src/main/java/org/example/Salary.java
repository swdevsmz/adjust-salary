package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Salary {

    public BigDecimal[] adjustSalary(final BigDecimal[] salaries) {

        final int lastYearIndex = salaries.length - 1;
        final BigDecimal[] adjustedSalaries = new BigDecimal[salaries.length];

        System.arraycopy(salaries, 0, adjustedSalaries, 0, salaries.length);

        int currentYearIndex = 0;

        while (currentYearIndex <= lastYearIndex) {

            int changeYearIndex = currentYearIndex + 1;

            // 現在年から最終年までループし、給与が同じではない年を探査
            while (changeYearIndex <= lastYearIndex) {
                if (!salaries[changeYearIndex].equals(salaries[currentYearIndex])) {
                    break;
                } else {
                    changeYearIndex++;
                }
            }

            if (changeYearIndex <= lastYearIndex) {
                 // 最終年までに給与が同じではない年がある場合

                // 現在の給料と変更時の給料との差額を算出し、
                // 期間で割り、毎年期の給料に差額を加減する
                final BigDecimal startSalary = salaries[currentYearIndex];
                final BigDecimal endSalary = salaries[changeYearIndex];
                final int duration = changeYearIndex - currentYearIndex;

                final BigDecimal diffSalary = (endSalary.subtract(startSalary))
                                        .divide(BigDecimal.valueOf(duration), RoundingMode.DOWN);

                // 翌年から給料が変更する前年までを調整する
                for (int i = currentYearIndex + 1; i < changeYearIndex; i++) {
                    adjustedSalaries[i] = adjustedSalaries[i - 1].add(diffSalary);
                }

                currentYearIndex = changeYearIndex;


            } else {
                // 変更点がない場合は次年度へ
                currentYearIndex++;
            }
        }

        return adjustedSalaries;
    }

}
