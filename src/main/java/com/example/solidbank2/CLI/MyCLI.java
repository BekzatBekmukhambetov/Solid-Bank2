package com.example.solidbank2.CLI;

import com.example.solidbank2.domain.account.AccountType;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class MyCLI implements CLIUI{
    Scanner scanner;
    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }
    MyCLI() {
        this.scanner = new Scanner(System.in);
    }


    public Scanner getScanner() {
        return  scanner;
    }

    @Override
    public double requestClientAmount() {
        System.out.println("Type Amount of Money");
        return scanner.nextDouble();
    }

    @Override
    public String requestClientAccountNumber() {
        System.out.println("Type account ID:");
        return scanner.nextLine();
    }

    @Override
    public AccountType requestAccountType() {
        switch (scanner.nextLine()) {
            case "CHECKING":
                return AccountType.CHECKING;
            case "SAVING":
                return AccountType.SAVING;
            case "FIXED":
                return AccountType.FIXED;
        }
        return null;
    }
}
