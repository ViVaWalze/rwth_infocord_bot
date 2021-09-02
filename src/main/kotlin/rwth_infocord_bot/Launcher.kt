package rwth_infocord_bot

import io.github.cdimascio.dotenv.dotenv
import kotlin.system.exitProcess
import rwth_infocord_bot.core.BotImpl as Bot

fun main(args: Array<String>) {
    val env = dotenv()
    val token = env["TOKEN"] ?: exitProcess(1)
    val bot = Bot(token)
}