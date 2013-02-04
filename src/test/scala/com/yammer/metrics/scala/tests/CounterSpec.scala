package com.yammer.metrics.scala.tests

import org.scalatest.FlatSpec
import com.yammer.metrics.scala.Counter
import org.mockito.Mockito
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar

@RunWith(classOf[JUnitRunner])
class CounterSpec extends FlatSpec with MockitoSugar {
  val metric = mock[com.yammer.metrics.core.Counter]
  val counter = new Counter(metric)

  "A Counter" should "increment the underlying metric by an arbitrary amount" in {
    counter += 12
    Mockito.verify(metric, Mockito.times(1)).inc(12)
  }

  "A Counter" should "decrement the underlying metric by an arbitrary amount" in {
    counter -= 12
    Mockito.verify(metric, Mockito.times(1)).dec(12)
  }
}

