package rwth_infocord_bot.core

import net.dv8tion.jda.api.JDA

interface Bot {
    val jda: JDA
}