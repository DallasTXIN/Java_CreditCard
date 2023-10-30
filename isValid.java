//Dallas Lawson
//October 30, 2023
//Prof. Bowman
//SDEV200-1AH
//Chapter 6, Assignment 6.31: Credit Card Validation

import java.util.Arrays;

public class isValid {
    public static void main(String[] args) {
        String cardNumber="1358954993914435";
        boolean validCredit = isValidCreditCardNumber(cardNumber);
        if(validCredit)
        {
            System.out.println(cardNumber+" is a valid credit card number.");
        }
        else
        {
            System.out.println(cardNumber+" is not a valid credit card number.");
        }
    }

    public static boolean isValidCreditCardNumber(String cardNumber)
    {
        int[] cardIntArray=new int[cardNumber.length()];
        for(int i=0;i<cardNumber.length();i++)
        {
            char c= cardNumber.charAt(i);
            cardIntArray[i]=  Integer.parseInt(""+c);
        }
        for(int i=cardIntArray.length-2;i>=0;i=i-2)
        {
            int num = cardIntArray[i];
            num = num * 2;
            if(num>9)
            {
                num = num%10 + num/10;
            }
            cardIntArray[i]=num;
        }
        int sum = sumDigits(cardIntArray);
        System.out.println(sum);
        if(sum%10==0)
        {
            return true;
        }
        return false;

    }
    public static int sumDigits(int[] arr)
    {
        return Arrays.stream(arr).sum();
    }
}