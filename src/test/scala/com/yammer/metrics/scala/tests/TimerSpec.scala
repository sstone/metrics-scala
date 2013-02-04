package com.yammer.metrics.scala.tests

import com.yammer.metrics.Metrics
import org.scalatest.{FlatSpec, FunSpec, Spec}
import com.yammer.metrics.scala.Timer
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TimerSpec extends FlatSpec {
  "A Timer" should "updates the underlying metric" in {
    val metric = Metrics.defaultRegistry().newTimer(classOf[TimerSpec], "timer")
    val timer = new Timer(metric)
    timer.time { Thread.sleep(100); 10 } === 10
    metric.min > 90 && metric.max() < 110
  }
}

