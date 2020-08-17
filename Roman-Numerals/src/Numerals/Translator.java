package Numerals;

import java.util.HashMap;


public class Translator {
    HashMap<String, Integer> numerals;

    public Translator() throws InvalidInputError {
        HashMap<String, Integer> values = new HashMap<>();
        values.put("I", 1);
        values.put("IV", 4);
        values.put("V", 5);
        values.put("IX", 9);
        values.put("X", 10);
        values.put("XL", 40);
        values.put("L", 50);
        values.put("XC", 90);
        values.put("C", 100);
        values.put("CD", 400);
        values.put("D", 500);
        values.put("CM", 900);
        values.put("M", 1000);
        numerals = values;
    }

    public String translateToNumber(String numeral) {
        int itemToReturn = 0;
        StringBuilder numeralBuf = new StringBuilder(numeral);
        for(int i = 0;i < numeralBuf.length(); ++i) {
            if(!Character.isAlphabetic(numeralBuf.charAt(i))) {
                throw new InvalidInputError("Invalid mix of numbers and letters.");
            }
            if(!numerals.containsKey(Character.toString(numeralBuf.charAt(i)))) {
                throw new InvalidInputError("Character " + Character.toString(numeralBuf.charAt(i)) + " is not a valid Roman numeral.");
            }
        }
        for(int i = 0;i < numeralBuf.length(); ++i) {
            if(i < (numeralBuf.length() - 1)) {
                int first = numerals.get(Character.toString(numeralBuf.charAt(i)));
                int second = numerals.get(Character.toString(numeralBuf.charAt(i+1)));
                if(first < second) {
                    first = second - first;
                    itemToReturn += first;
                    ++i;
                }
                else {
                    itemToReturn += numerals.get(Character.toString(numeralBuf.charAt(i)));
                }
            }
            else {
                itemToReturn += numerals.get(Character.toString(numeralBuf.charAt(i)));
            }
        }
        return Integer.toString(itemToReturn);
    }

    public String translateToNumeral(String number) {
        StringBuilder numberBuf = new StringBuilder(number);
        for(int i = 0;i < numberBuf.length(); ++i) {
            if(Character.isAlphabetic(numberBuf.charAt(i))) {
                throw new InvalidInputError("Invalid mix of numbers and letters.");
            }
        }
        int numberToTranslate = Integer.parseInt(number);
        if(numberToTranslate < 0) {
            throw new InvalidInputError("Input cannot be negative.");
        }
        StringBuilder buildNumerals = new StringBuilder();
        while(numberToTranslate > 0) {
            String character = nextItem(numberToTranslate);
            if(character != null) {
                numberToTranslate -= numerals.get(character);
                buildNumerals.append(character);
            }
        }
        return buildNumerals.toString();
    }

    public String nextItem(int value) {
        if(value - numerals.get("M") >= 0) {
            return "M";
        }
        else if(value - numerals.get("CM") >= 0) {
            return "CM";
        }
        else if(value - numerals.get("D") >= 0) {
            return "D";
        }
        else if(value - numerals.get("CD") >= 0) {
            return "CD";
        }
        else if(value - numerals.get("C") >= 0) {
            return "C";
        }
        else if(value - numerals.get("XC") >= 0) {
            return "XC";
        }
        else if(value - numerals.get("L") >= 0) {
            return "L";
        }
        else if(value - numerals.get("XL") >= 0) {
            return "XL";
        }
        else if(value - numerals.get("X") >= 0) {
            return "X";
        }
        else if(value - numerals.get("IX") >= 0) {
            return "IX";
        }
        else if(value - numerals.get("V") >= 0) {
            return "V";
        }
        else if(value - numerals.get("IV") >= 0) {
            return "IV";
        }
        else {
            return "I";
        }
    }
}
