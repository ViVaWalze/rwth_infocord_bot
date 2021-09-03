package rwth_infocord_bot.constants

import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent

object BOT {
    private const val PREFIX = "/"
    val STATUS = OnlineStatus.ONLINE
    val ACTIVITY = Activity.listening("$PREFIX help")
    val GATEWAY_INTENTS = GatewayIntent.ALL_INTENTS
}