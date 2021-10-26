package com.codecool.enigma;

import java.util.Arrays;

class ArgsParser {

    String option;
    String cipher;
    String file;
    String key;

    ArgsParser(String[] args) throws EnigmaException {
        if(args.length == 0){
            option = "-h";
        } else {
            parseArguments(args);
            validNumberOfArguments();
            validateRailFence();
        }
    }

    private void parseArguments(String[] args) throws EnigmaException {
        for (String argument : args) {
            option = validateArgument(argument, new String[]{"-h", "-d", "-e"}, option);
            cipher = validateArgument(argument, new String[]{"morse", "rail-fence", "rot13"}, cipher);
            if (argument.contains(".txt")) {
                file = argument;
            } else {
                key = argument;
            }
        }
    }

    private String validateArgument(String argument, String[] validArguments, String argumentType) {
        if(Arrays.asList(validArguments).contains(argument)) {
            return argument;
        } else if(argumentType == null){
            return null;
        } else {
            return argumentType;
        }
    }

    private void validNumberOfArguments() throws EnigmaException {
        if(option == null) {
            throw new EnigmaException("Invalid option.");
        }
            if(!option.equalsIgnoreCase("-h")) {
                if (cipher == null) {
                    throw new EnigmaException("Invalid cipher.");
                } else if (file == null) {
                    throw new EnigmaException("Invalid file");
                } else if (option == null && cipher == null && file == null){
                    throw new EnigmaException("Invalid number of arguments.");
                }
            }
    }

    private void validateRailFence() throws EnigmaException {
        if(cipher != null && cipher.equalsIgnoreCase("rail-fence")) {
            try {
                Integer.parseInt(key);
            } catch (NumberFormatException ex) {
                throw new EnigmaException("Invalid key");
            }
        }
    }
}
