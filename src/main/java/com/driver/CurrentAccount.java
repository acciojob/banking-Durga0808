package com.driver;

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
        while(!isvalid(tradeLicenseId)){
            char arr[]=tradeLicenseId.toCharArray();
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]==arr[i+1]) {
                    char temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            tradeLicenseId=new String(arr);
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
