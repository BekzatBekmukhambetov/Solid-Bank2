package com.example.solidbank2.conrtollers;

import com.example.solidbank2.CLI.AccountBasicCLI;
import com.example.solidbank2.CLI.MyCLI;
import com.example.solidbank2.CLI.TransactionDepositCLI;
import com.example.solidbank2.CLI.TransactionWithdrawCLI;
import com.example.solidbank2.dao.TransactionDAO;
import com.example.solidbank2.domain.Transaction;
import com.example.solidbank2.domain.account.Account;
import com.example.solidbank2.domain.account.AccountType;
import com.example.solidbank2.service.AccountListingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Tag(name = "AccountController")
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private String clientID = "1";

    private MyCLI myCLI;
    private AccountBasicCLI accountBasicCLI;
    private TransactionDepositCLI transactionDepositCLI;
    private TransactionWithdrawCLI transactionWithdrawCLI;

    private AccountListingService accountListingService;
    private TransactionDAO transactionDAO;

    public AccountController(MyCLI myCLI,
                             AccountBasicCLI accountBasicCLI,
                             TransactionDepositCLI transactionDepositCLI,
                             TransactionWithdrawCLI transactionWithdrawCLI,
                             AccountListingService accountListingService,
                             TransactionDAO transactionDAO) {

        this.myCLI = myCLI;
        this.accountBasicCLI = accountBasicCLI;
        this.transactionDepositCLI = transactionDepositCLI;
        this.transactionWithdrawCLI = transactionWithdrawCLI;
        this.accountListingService = accountListingService;
        this.transactionDAO=transactionDAO;
    }

    @Operation(summary = "Print All Accounts")
    @GetMapping("")
    public List<Account> findAll(){
       return accountBasicCLI.getAccounts(clientID);
    }

    @Operation(summary = "Create New Account", description = "Account type : FIXED,SAVING,CHECKING")
    @PostMapping("")
    public ResponseEntity<String> createAccount(@RequestParam("account_type") String account_type){
        try{
            AccountType type = AccountType.valueOf(account_type);
            accountBasicCLI.createAccountRequest(type,clientID);
            return new ResponseEntity<>("Account created",HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>("Provide correct Type",HttpStatus.NOT_FOUND);
        }

    }
    @Operation(summary = "Get Account by ID")
    @GetMapping("/{account_id}")
    public ResponseEntity<Account> getById(@PathVariable String account_id) throws AccountNotFoundException {
        try {
           Account account=accountBasicCLI.getAccount(account_id);
            return new ResponseEntity<>(account,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(summary = "Delete Account")
    @DeleteMapping("/{account_id}")
        public ResponseEntity<String> deleteById(@PathVariable String account_id){
            boolean Account = accountListingService.deleteAccountById(account_id);
            if(Account){
                return new ResponseEntity<>("Account: "+account_id + " deleted", HttpStatus.OK);
            }
            return  new ResponseEntity<>("Account: "+account_id+ " Not Founded",HttpStatus.NOT_FOUND);
        }
    @Operation(summary = "Deposit Money")
    @PostMapping("/{account_id}/deposit")
    public ResponseEntity<String> depositMoney(@PathVariable String account_id,@RequestParam("money_amount")Double amount)throws Exception{
        try {
            transactionDepositCLI.depositMoney(account_id,amount);
            return new ResponseEntity<>("successful deposit of the amount: "+amount+" from "+account_id, HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deposit failed: " + e.getMessage());
        }
    }
    @Operation(summary = "Withdraw Money")
    @PostMapping("/{account_id}/withdraw")
    public ResponseEntity<String> withdrawMoney(@PathVariable String account_id,@RequestParam("money_amount")Double amount) throws Exception {
        try {
            transactionWithdrawCLI.withdrawMoney(account_id, amount);
            return new ResponseEntity<>("successful withdrawal of the amount: "+amount+" from "+account_id, HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Withdrawal failed: " + e.getMessage());
        }

    }
    @Operation(summary = "Print All Transactions")
    @GetMapping("/{account_id}/transactions")
    public List<Transaction> getAllTransaction(@PathVariable String account_id){
        return transactionDAO.findAllByClientID(account_id);
    }
    



}
