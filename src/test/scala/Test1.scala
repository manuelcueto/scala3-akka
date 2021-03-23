
package com.manu.app

import com.manu.behaviors._
import Multiplier._
import org.scalatest._
import flatspec._
import matchers._
import akka.actor.testkit.typed.scaladsl.BehaviorTestKit
import akka.actor.testkit.typed.scaladsl.TestInbox

class MultiplierSpec extends AnyFlatSpec {
  "A Multiplier" should "Multiply all values" in {

    val testkit = BehaviorTestKit(Multiplier())
    val inbox = TestInbox[Multiplied]()
    testkit.run(Multiply(Seq(1,2,3,4,5), inbox.ref))
    inbox.expectMessage(Multiplied(120))
  }
}