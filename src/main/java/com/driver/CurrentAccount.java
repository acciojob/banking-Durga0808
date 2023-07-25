package com.driver;



public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {

        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000.0);
        this.tradeLicenseId = tradeLicenseId;
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!isvalid(tradeLicenseId)){
            int fr[]=new int [26];
            for(int i=0;i<tradeLicenseId.length();i++){
                char c=tradeLicenseId.charAt(i);
                fr[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            int i=0;
            char prev='*';
            while(i<tradeLicenseId.length()){
                int maxi=0;int id=0;
                for(int j=0;j<26;j++){
                    if(fr[j]>maxi&&prev!=(char)(j+'a')){
                        maxi=fr[j];
                        //prev=j+'a';
                        id=j;
                    }
                    if(maxi==0){
                        sb=null;
                        break;
                    }
                    prev=(char)(id+'a');
                    sb.append(prev);
                    fr[id]--;
                    i++;
                }
            }

            if (isvalid(sb.toString())) {
               tradeLicenseId=sb.toString();
            } else {
                throw new Exception("Valid License can not be generated");
            }
        }
    }
    private boolean isvalid (String id){
        if(id.length()==0){
            return false;
        }
        for(int i=0;i<id.length()-1;i++){
            if(id.charAt(i)==id.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

}
