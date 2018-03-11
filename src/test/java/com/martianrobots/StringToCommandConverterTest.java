package com.martianrobots;

import com.martianrobots.command.Command;
import com.martianrobots.command.ForwardCommand;
import com.martianrobots.command.LeftCommand;
import com.martianrobots.command.RightCommand;
import org.junit.Test;

import java.util.List;

import static com.martianrobots.StringToCommandConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class StringToCommandConverterTest {

    @Test
    public void shouldBeAbleToParseInstruction() {
        String[] parseInstruction = StringToCommandConverter.parseInstruction("FLLR");
        assertThat(parseInstruction.length).isEqualTo(4);
        assertThat(parseInstruction).containsSequence(new String[]{"F", "L", "L", "R"});
    }

    @Test
    public void shouldBeAbleToConvertLeftInstructionToCommand() {
        List<Command> commands = convert("L");
        assertThat(commands.size()).isEqualTo(1);
        assertThat(commands.get(0)).isInstanceOf(LeftCommand.class);
    }

    @Test
    public void shouldBeAbleToConvertRightInstructionToCommand() {
        List<Command> commands = convert("R");
        assertThat(commands.size()).isEqualTo(1);
        assertThat(commands.get(0)).isInstanceOf(RightCommand.class);
    }

    @Test
    public void shouldBeAbleToConvertForwardInstructionToCommand() {
        List<Command> commands = convert("F");
        assertThat(commands.size()).isEqualTo(1);
        assertThat(commands.get(0)).isInstanceOf(ForwardCommand.class);
    }

    @Test
    public void shouldBeAbleToConvertMultipleInstructionsToCommands() {
        assertThat(convert("FFLR").size()).isEqualTo(4);
    }
}