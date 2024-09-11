package com.hexaware.pnbbank;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hexaware.pnbbank.Entity.PNBbank_user;
import com.hexaware.pnbbank.pnbRepo.PNBbankRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
        PNBbankRepository rep = context.getBean(PNBbankRepository.class);
        Scanner sc = new Scanner(System.in);
        
        while(true) {
        	System.out.println("1. Open your PNB account");
        	System.out.println("2. Deposit Money");
        	System.out.println("3. Withdraw Money");
        	System.out.println("4. Search for your Account");
        	System.out.println("5. Transfer Amount");
        	System.out.println("6. Close your Account");
        	System.out.println("7. Exit");
        	
        	System.out.print("Enter your Choice -> ");
        	
        	int choice = sc.nextInt();
        	
        	switch(choice) {
        	case 1:
        		System.out.println("Enter Account Number:");
        		int accNo = sc.nextInt();
        		System.out.println("Enter your name as in your Aadhar:");
        		String name = sc.next();
        		PNBbank_user newAcc = new PNBbank_user();
        		newAcc.setAccNo(accNo);
        		newAcc.setName(name);
        		newAcc.setBalance(1000.0);
        		
        		rep.save(newAcc);
        		
        		System.out.println("Account opened");
        		break;
        		
        	case 2:
        		System.out.println("Enter Account number : ");
        		int dep_accNo = sc.nextInt();
        		System.out.println("Enter Amount : ");
        		double dep_amt = sc.nextDouble();
        		Optional<PNBbank_user> deposit = rep.findById(dep_accNo);
        		if(deposit.isPresent()) {
        			PNBbank_user dep_acc = deposit.get();
        			dep_acc.setBalance(dep_acc.getBalance() + dep_amt);
        			
        			rep.save(dep_acc);
        			System.out.println("Amount Credited Successfully");
        		}else {
        			System.out.println("No Such Account number if Found. Enter your correct account number.");
        		}
        		break;
        		
        	case 3:
        		System.out.println("enter Account Number : ");
        		int wid_accNo = sc.nextInt();
        		System.out.println("Enter amount to withdraw : ");
        		double wid_amt = sc.nextDouble();
        		Optional<PNBbank_user> withdraw = rep.findById(wid_accNo);
        		if(withdraw.isPresent()) {
        			PNBbank_user wid_acc = withdraw.get();
        			if(wid_acc.getBalance() >= wid_amt){
        				wid_acc.setBalance(wid_acc.getBalance() - wid_amt);
        				rep.save(wid_acc);
        				
        				System.out.println("Amount Withdrawed.");     					
        			}else {
        				System.out.println("Insufficient Balance.");
        			}	
        		}else {
        			System.out.println("Account number Not Found.");
        		}
        		break;
        		
        	case 4:
        		System.out.print("Enter account number: ");
                int s_accNo = sc.nextInt();
                Optional<PNBbank_user> search = rep.findById(s_accNo);
                if (search.isPresent()) {
                    System.out.println(search.get());
                } else {
                    System.out.println("Account not found.");
                }
                break;
                
                
        	case 5:
        		System.out.print("Enter source account number: ");
                int send_accNo = sc.nextInt();
                System.out.print("Enter target account number: ");
                int rec_accNo = sc.nextInt();
                System.out.print("Enter amount to transfer: ");
                double transfer_amt = sc.nextDouble();
                
                Optional<PNBbank_user> sender = rep.findById(send_accNo);
                Optional<PNBbank_user> reciever = rep.findById(rec_accNo);

                if (sender.isPresent() && reciever.isPresent()) {
                	PNBbank_user sender_acc = sender.get();
                	PNBbank_user reciever_acc = reciever.get();

                    if (sender_acc.getBalance() >= transfer_amt) {
                    	sender_acc.setBalance(sender_acc.getBalance() - transfer_amt);
                    	reciever_acc.setBalance(reciever_acc.getBalance() + transfer_amt);
                        rep.save(sender_acc);
                        rep.save(reciever_acc);
                        System.out.println("Amount transferred successfully.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                } else {
                    System.out.println("One or both accounts not found.");
                }
                break;
                
        	case 6:
                System.out.print("Enter account number to close: ");
                int close_accNo = sc.nextInt();
                Optional<PNBbank_user> close = rep.findById(close_accNo);
                if (close.isPresent()) {
                    rep.deleteById(close_accNo);
                    System.out.println("Account closed.");
                } else {
                    System.out.println("Account not found.");
                }
                break;

            case 7:
                System.out.println("Exiting...");
                sc.close();
                return;

            default:
                System.out.println("Invalid option. Try again.");
        		
        	}
        }
	}

}
