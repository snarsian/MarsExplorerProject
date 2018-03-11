package com.martianrobots;

import com.martianrobots.command.Command;
import com.martianrobots.command.LeftCommand;
import com.martianrobots.command.RightCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringToCommandConverter {

    private static final Map<String, Command> stringCommandMap = new HashMap<String, Command>() {{
        put("L", new LeftCommand());
        put("R", new RightCommand());
    }};

    static String[] parseInstruction(String instructions) {
        return instructions.split("");
    }

    public static List<Command> convert(String instructions) {
        List<Command> commands = new ArrayList<Command>();

        for (String instruction : parseInstruction(instructions)) {
            commands.add(stringCommandMap.get(instruction));
        }

        return commands;
    }
}
