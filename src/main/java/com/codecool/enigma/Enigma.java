package com.codecool.enigma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class Enigma {

    private static String MENU = "Enigma Manual\n" +
            "Run options: [-h | -e | -d] {CipherName} {FileName} {EncryptionKey}\n" +
            "   -h : displays this menu; other arguments are ignored.\n" +
            "   -e : encrypt and display\n" +
            "   -d : decrypt and display\n" +
            "   CipherName      : cipher to use when encrypting/decrypting; [rot13, rail-fence, morse]\n" +
            "   FileName        : path to file to encrypt/decrypt\n" +
            "   EncryptionKey   : Optional -> must be provided if cipher requires a key";

    public static void main(String[] args) throws EnigmaException, IOException {
        ArgsParser argsParser = new ArgsParser(args);
        handleCipherOperation(argsParser);
    }

    private static void handleCipherOperation(ArgsParser argsParser) throws EnigmaException, IOException {
        if(CipherFactory.isCipherAvailable(argsParser.cipher)){
            Cipher cipher = CipherFactory.getCipherForArgs(argsParser);
            HandleFiles filesHandler = new HandleFiles();
            if(argsParser.option.equalsIgnoreCase("-e")){
                System.out.println(cipher.encrypt(filesHandler.getFileText(argsParser.file)));
            } else if(argsParser.option.equalsIgnoreCase("-d")) {
                System.out.println(cipher.decrypt(filesHandler.getFileText(argsParser.file)));
            } else if(argsParser.option.equalsIgnoreCase("-h")) {
                System.out.println(MENU);
            }
        }

    }

}
