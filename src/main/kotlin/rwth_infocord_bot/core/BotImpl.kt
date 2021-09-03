package rwth_infocord_bot.core

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent
import rwth_infocord_bot.constants.BOT.ACTIVITY
import rwth_infocord_bot.constants.BOT.GATEWAY_INTENTS
import rwth_infocord_bot.constants.BOT.STATUS

internal class BotImpl(token: String) : Bot {
    override val jda: JDA = JDABuilder.create(
        token,
        GatewayIntent.getIntents(GATEWAY_INTENTS)
    )
        .setActivity(ACTIVITY)
        .setStatus(STATUS)
        .build()
}