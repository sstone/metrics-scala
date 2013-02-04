package com.yammer.metrics.scala.tests

import org.scalatest.FlatSpec
import org.mockito.Mockito
import com.yammer.metrics.scala.Meter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar

@RunWith(classOf[JUnitRunner])
class MeterSpec extends FlatSpec with MockitoSugar{
  val metric = mock[com.yammer.metrics.core.Meter]
  val meter = new Meter(metric)

  "A Meter" should "mark the underlying metric" in {
    meter.mark()
    Mockito.verify(metric, Mockito.times(1)).mark()
  }

  "A Meter" should "mark the underlying metric by an arbitrary amount" in {
    meter.mark(12)
    Mockito.verify(metric, Mockito.times(1)).mark(12)
  }
}

