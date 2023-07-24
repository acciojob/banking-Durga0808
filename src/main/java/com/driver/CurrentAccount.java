package com.driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!isvalid(tradeLicenseId)){
            List<Character> chars = new ArrayList<>();
            for (char c : tradeLicenseId.toCharArray()) {
                chars.add(c);
            }

            // Rearrange characters to create a valid license ID
            Collections.shuffle(chars);

            StringBuilder sb=new StringBuilder();
            for (char c : chars) {
               sb.append(c);
            }

            if (isvalid(sb.toString())) {
               tradeLicenseId=sb.toString();
            } else {
                throw new Exception("Valid License can not be generated");
            }
        }
    }
    private boolean isvalid (String id){

        for(int i=0;i<id.length()-1;i++){
            if(id.charAt(i)==id.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

}
