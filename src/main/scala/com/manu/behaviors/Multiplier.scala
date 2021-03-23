package com.manu.behaviors

import akka.actor.typed.{ ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors


object Multiplier {
    final case class Multiply(elems:Seq[Int], replyTo: ActorRef[Multiplied])
    final case class Multiplied(result: Int)   

    def apply(): Behavior[Multiply] = Behaviors.receive { (context, message) =>
        context.log.info("multiplying some stuff")
        message.replyTo ! Multiplied(message.elems.foldLeft(1)(_ * _))
        Behaviors.same
    }
    
}
