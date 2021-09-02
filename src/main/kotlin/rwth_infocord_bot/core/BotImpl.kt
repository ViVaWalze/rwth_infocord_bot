package rwth_infocord_bot.core

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent

internal class BotImpl(token: String) : Bot {
    override val jda: JDA = JDABuilder.create(
        token,
        GatewayIntent.getIntents(GatewayIntent.DEFAULT)
    ).build()
}