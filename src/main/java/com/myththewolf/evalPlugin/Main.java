package com.myththewolf.evalPlugin;

import com.myththewolf.modbot.core.lib.invocation.impl.BotPlugin;

public class Main extends BotPlugin {
    public void onDisable() {

    }

    public void onEnable() {
        getLogger().info("Registering commands");
        registerCommand(">eval", new EvalCommand());
    }
}
