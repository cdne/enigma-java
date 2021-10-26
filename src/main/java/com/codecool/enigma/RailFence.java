package com.codecool.enigma;

class RailFence implements Cipher {

    private int key;

    RailFence(String key) {
        this.key = Integer.parseInt(key);
    }

    @Override
    public String encrypt(String message) {
        String encryptedText = "";
        boolean check = false;
        int j = 0;
        int row = key;
        int col = message.length();
        char[][] railFenceArray = new char[row][col];

        for(int i = 0; i < col; i++) {
            if(j == 0 || j == row - 1)
                check = !check;

            railFenceArray[j][i] = message.charAt(i);

            if(check)
                j++;
            else
                j--;
        }

        for(int i = 0; i < railFenceArray.length; i++){
            for(int k = 0;k < railFenceArray[i].length; k++){
                if(railFenceArray[i][k] != 0)
                    encryptedText += railFenceArray[i][k];
            }
        }

        return encryptedText;
    }

    @Override
    public String decrypt(String message) {
        String decryptedText = "";
        boolean check = false;
        int j = 0;
        int row = key;
        int col = message.length();
        char[][] railsFenceArray = new char[row][col];

        for(int i = 0; i < col; i++) {
            if(j == 0 || j == key - 1)
                check = !check;

            railsFenceArray[j][i] = '*';

            if(check)
                j++;
            else
                j--;
        }

        int index = 0;
        check = false;

        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                if(railsFenceArray[i][k] == '*' && index < col) {
                    railsFenceArray[i][k] = message.charAt(index++);
                }
            }
        }

        j = 0;
        for(int i = 0; i < col; i++) {
            if(j == 0 || j == key - 1)
                check = !check;
            decryptedText += railsFenceArray[j][i];

            if(check)
                j++;
            else
                j--;
        }
        return decryptedText;
    }
}
