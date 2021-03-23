package com.manu.app

import akka.actor.typed.ActorSystem
import com.manu.behaviors.Multiplier
@main def run = {
    val system = ActorSystem(Multiplier(), "multiplierrrrr")

}
def msg = "I was compiled by Scala 3. :)"