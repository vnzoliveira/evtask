package com.evtask.myproject.entities;

import com.evtask.myproject.entities.exception.CVVException;
import com.evtask.myproject.entities.exception.ExpiryDateException;
import com.evtask.myproject.entities.exception.InvalidCardException;

import java.time.YearMonth;

/*
Class that represents the Object CreditCard in our little app.
 */

public class CreditCard {
    private String cardNum;
    private String cvv;
    private YearMonth expiryDate;

    public String getCardNum() {
        return cardNum;
    }

    /*
    Get the card number input formatted with a mask and remove its spaces.
     */
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum.replace(" ", "");
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public YearMonth getExpirationDateString() {
        return expiryDate;
    }

    public void setExpirationDateString(YearMonth expirationDateString) {
        this.expiryDate = expirationDateString;
    }

    /*
    Use the addressed rule from the task to validate the length of the card number.
     */
    public boolean verifyPanNumber(){
        if (cardNum.length() >= 16 && cardNum.length() <= 19){
            return true;
        }
        else{
            throw new InvalidCardException("The card number is invalid. Please, check your info.");
        }
    }

    /*
    use correctLength variable to stipulate whether CVV has 3 or 4 digits (AMEX card)
     */
    public boolean isCvvCorrect(){
        String digits = cardNum.substring(0, 2);
        boolean amexCvv = digits.equals("34") || digits.equals("37");
        int correctLength = 3;
        if (amexCvv){
            correctLength = 4;
        }
        if (correctLength == cvv.length()){
            return true;
        }
        else{
            throw new CVVException("Invalid CVV. Please, check your info (AMEX cards have a 4 digit CVV).");
        }
    }

    /*
    Little Luhn's Algorithm to get to the correct last digit
     */
    protected String getCalculatedCheckDigit(){
        int [] digits = formatCardStringToInt();
        for (int i = digits.length - 1; i >= 0; i -= 2){
            digits[i] += digits[i];
            if (digits[i] >= 10){
                digits[i] = digits[i] - 9;
            }
        }
        int sum = 0;
        for (int i : digits) {
            sum += i;
        }
        sum *= 9;
        String digit = String.valueOf(sum);
        return digit.substring(digit.length() - 1);
    }

    protected int[] formatCardStringToInt() {
        int[] digits = new int[cardNum.length()];
        for (int i = 0; i < cardNum.length(); i++) {
            digits[i] = Character.getNumericValue(cardNum.charAt(i));
        }
        return digits;
    }

    /*
    Get the last digit calculated and compares with our card number to validate it.
     */
    public boolean CardNumDigitCheck(){
        char checkDigit = cardNum.charAt(cardNum.length() - 1);
        String digit = getCalculatedCheckDigit();
        if (checkDigit == digit.charAt(0)){
            return true;
        }
        else{
            throw new InvalidCardException("Card number is invalid. Please, check your info.");
        }
    }

    /*
    Uses java 8 time features to format and store expiry date MM/yy correctly.
     */
    public boolean isExpiryDateValid(){
        YearMonth presentTime = YearMonth.now();
        if (expiryDate.isAfter(presentTime)){
            return true;
        }
        else{
            throw new ExpiryDateException("The expiry date must be AFTER present time ("+presentTime+")");
        }
    }

}
