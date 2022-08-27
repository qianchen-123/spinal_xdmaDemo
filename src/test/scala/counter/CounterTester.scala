package counter

import spinal.sim._
import spinal.core._
import spinal.core.sim._
import common.xdmaSimConfig
import org.scalatest.FunSuite

import scala.util.Random


class CounterTester extends FunSuite{
  var compiled: SimCompiled[counter] = null

  test("compile"){
    compiled = xdmaSimConfig().compile(counter())
  }

  test("testbench"){
    compiled.doSim{ dut =>
      dut.clkDomain.forkStimulus(10)
      dut.clkDomain.waitSampling(10)
//      var counter = 0
      for(_ <- 0 until 100){
        dut.io.rstn #= true
        dut.clkDomain.waitSampling()
//        assert(dut.io.oNum.toInt == counter, "dut.io.value missmatch")
//        assert(dut.io.full.toBoolean == (counter == 255), "dut.io.full missmatch")
//        counter = if(!dut.io.rstn.toBoolean) 0 else (counter + 1) & 0xFF
      }
    }
  }
}
