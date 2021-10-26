package com.codecool.enigma;

import java.util.Arrays;

class CipherFactory {

    static boolean isCipherAvailable(String cipherName) {
        if(cipherName == null) return false;
        String[] validCiphers = new String[]{"morse", "rail-fence", "rot13"};
        if(Arrays.asList(validCiphers).contains(cipherName.toLowerCase())) return true; else return false;
    }

    static Cipher getCipherForArgs(ArgsParser args) throws EnigmaException {
        if (args.cipher.equalsIgnoreCase("morse")) {
            return new MorseCode();
        } else if (args.cipher.equalsIgnoreCase("rail-fence") && args.key != null) {
            return new RailFence(args.key);
        } else if (args.cipher.equalsIgnoreCase("rot13")) {
            return new Rot13();
        } else {
            return null;
        }
    }
}
