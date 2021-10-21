package com.codecool.enigma;

class RailFence implements Cipher {

    @Override
    public String encrypt(String message) {
        String encryptedText = "";
        boolean check = false;
        int j = 0;
        int row = 3;
        int col = message.length();
        char[][] railFenceArray = new char[row][col];

        for(int i = 0; i < col; i++) {
            if(j == 0 || j == 3 -1)
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
        int row = 3;
        int col = message.length();
        char[][] railsFenceArray = new char[row][col];

        for(int i = 0; i < col; i++) {
            if(j == 0 || j == 3 - 1)
                check = !check;

            railsFenceArray[j][i] = '*';

            if(check)
                j++;
            else
                j--;
        }

        int index = 0;

        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                if(railsFenceArray[i][k] == '*' && index < col) {
                    railsFenceArray[i][k] = message.charAt(index++);
                }
            }

        }

        for(int i = 0; i < col; i++) {
            if(j == 0 || j == 3 - 1)
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
