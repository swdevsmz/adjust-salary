package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SalaryTest {

    final Salary target = new Salary();

    @Test
    void adjustSalaryHandlesSingleYear() {
        final BigDecimal[] salaries = {BigDecimal.valueOf(50000)};
        final BigDecimal[] expected = {BigDecimal.valueOf(50000)};
        assertArrayEquals(expected, target.adjustSalary(salaries));
    }

    @Test
    void adjustSalaryHandlesConstantSalaries() {
        final BigDecimal[] salaries = {BigDecimal.valueOf(50000), BigDecimal.valueOf(50000), BigDecimal.valueOf(50000)};
        final BigDecimal[] expected = {BigDecimal.valueOf(50000), BigDecimal.valueOf(50000), BigDecimal.valueOf(50000)};
        assertArrayEquals(expected, target.adjustSalary(salaries));
    }

    @Test
    void adjustSalaryHandlesIncrementalSalaries() {
        final BigDecimal[] salaries = {BigDecimal.valueOf(50000), BigDecimal.valueOf(60000)};
        final BigDecimal[] expected = {BigDecimal.valueOf(50000), BigDecimal.valueOf(60000)};
        assertArrayEquals(expected, target.adjustSalary(salaries));
    }

    @Test
    void adjustSalaryHandlesGradualIncrease() {
        final BigDecimal[] salaries = {BigDecimal.valueOf(50000), BigDecimal.valueOf(50000), BigDecimal.valueOf(60000)};
        final BigDecimal[] expected = {BigDecimal.valueOf(50000), BigDecimal.valueOf(55000), BigDecimal.valueOf(60000)};
        assertArrayEquals(expected, target.adjustSalary(salaries));
    }

    @Test
    void adjustSalaryHandlesMultipleChanges() {
        final BigDecimal[] salaries = {BigDecimal.valueOf(50000), BigDecimal.valueOf(50000), BigDecimal.valueOf(60000), BigDecimal.valueOf(60000), BigDecimal.valueOf(70000)};
        final BigDecimal[] expected = {BigDecimal.valueOf(50000), BigDecimal.valueOf(55000), BigDecimal.valueOf(60000), BigDecimal.valueOf(65000), BigDecimal.valueOf(70000)};
        assertArrayEquals(expected, target.adjustSalary(salaries));
    }

    @Test
    void adjustSalaryHandlesEmptyArray() {
        final BigDecimal[] salaries = {};
        final BigDecimal[] expected = {};
        assertArrayEquals(expected, target.adjustSalary(salaries));
    }

    @Test
    void adjustSalaryHandlesNegativeSalaries() {
        final BigDecimal[] salaries = {BigDecimal.valueOf(-50000), BigDecimal.valueOf(-40000), BigDecimal.valueOf(-40000),BigDecimal.valueOf(-30000)};
        final BigDecimal[] expected = {BigDecimal.valueOf(-50000), BigDecimal.valueOf(-40000), BigDecimal.valueOf(-35000),BigDecimal.valueOf(-30000)};
        assertArrayEquals(expected, target.adjustSalary(salaries));
    }
}