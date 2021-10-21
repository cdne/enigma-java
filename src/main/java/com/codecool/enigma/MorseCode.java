package com.codecool.enigma;

import java.util.HashMap;
import java.util.Map;

class MorseCode implements Cipher {
    private Map<Character, String> morseCodeMap;

    public MorseCode() {
        this.morseCodeMap = new HashMap<>();
        initializeMorseCodeMap();
    }

    @Override
    public String encrypt(String message) {
        String encrypted = "";
        for(int i = 0; i < message.length(); i++){
            if(Character.isLetter(message.charAt(i)))
                encrypted += morseCodeMap.get((message.toUpperCase().charAt(i))) + " ";
            else if(message.charAt(i) == ' ')
                encrypted += "/ ";

        }
        return encrypted;
    }

    @Override
    public String decrypt(String message) {
        String[] textArray = message.split("\\s+");
        String decrypted = "";
        boolean characterIsFound = false;

        for(int i = 0; i < textArray.length;i++) {
            characterIsFound = false;
            for(Map.Entry<Character, String> entry : morseCodeMap.entrySet()){
                if(textArray[i].equalsIgnoreCase(entry.getValue())) {
                    decrypted += entry.getKey();
                }
                else if(textArray[i].equals("/") && !characterIsFound){
                    decrypted += " ";
                    characterIsFound = true;
                }
            }
        }

        return decrypted;
    }

    private void initializeMorseCodeMap(){
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
        morseCodeMap.put('0', "-----");
    }
}
