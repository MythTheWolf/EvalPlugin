package com.myththewolf.evalPlugin;

import bsh.EvalError;
import bsh.Interpreter;
import com.myththewolf.modbot.core.API.command.interfaces.CommandExecutor;
import com.myththewolf.modbot.core.lib.Util;
import de.btobastian.javacord.entities.channels.TextChannel;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageAuthor;
import de.btobastian.javacord.entities.message.embed.EmbedBuilder;

import java.awt.*;

public class EvalCommand extends CommandExecutor {
    public void onCommand(TextChannel textChannel, MessageAuthor messageAuthor, String[] strings, Message message) {
        Interpreter I = new Interpreter();
        try {
            I.set("pl", getPlugin());
            Object result = I.eval(Util.arrayToString(0, strings));
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setColor(Color.green);
            embedBuilder.setTitle(":coffee: Java evaluation");
            if (result == null) {
                embedBuilder.addField(":printer: Result", "None", false);
                embedBuilder.addField(":wrench: Result Type", "null", false);
            } else {
                embedBuilder.addField(":printer: Result", result.toString(), false);
                embedBuilder.addField(":wrench: Result Type", result.getClass().getName(), false);
            }
            reply(embedBuilder);
        } catch (EvalError evalError) {
            failed(":bomb: ```" + evalError.getMessage() + "```");
            return;
        }

    }
}
