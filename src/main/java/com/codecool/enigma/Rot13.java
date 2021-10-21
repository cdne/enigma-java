package com.codecool.enigma;

import java.util.HashMap;
import java.util.Map;

class Rot13 implements Cipher {
    private Map<Character, Character> map;

    public Rot13() {
        map = new HashMap<>();
        initializeMap();
    }

    @Override
    public String encrypt(String message) {
        String encrypted = "";
        for(int i = 0; i < message.length(); i++){
            if(Character.isLetter(message.charAt(i)))
                encrypted += String.valueOf(encryptLetter(message.toLowerCase().charAt(i)));
            else
                encrypted += message.charAt(i);
        }
        return encrypted;
    }

    @Override
    public String decrypt(String message) {
        String decrypted = "";
        for(int i = 0; i < message.length(); i++) {
            if(Character.isLetter(message.charAt(i)))
                decrypted += String.valueOf(decryptLetter(message.toLowerCase().charAt(i)));
            else
                decrypted += message.charAt(i);
        }
        return decrypted;
    }

    private char encryptLetter(char letter) {
        return map.get(letter);
    }

    private char decryptLetter(char letter) {
        for(Map.Entry<Character, Character> entry : map.entrySet()){
            if(letter == entry.getValue()) {
                return entry.getKey();
            }
        }
        return letter;
    }

    private void initializeMap(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
        String rot13Alphabet = "NOPQRSTUVWXYZABCDEFGHIJKLM".toLowerCase();
        for(int i = 0; i < alphabet.length();i++) {
            map.put(alphabet.charAt(i), rot13Alphabet.charAt(i));
        }
    }

}
