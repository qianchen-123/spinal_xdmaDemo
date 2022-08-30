package xdma

import spinal.core.sim._
import common.xdmaSimConfig
import org.scalatest.FunSuite
import spinal.lib.bus.amba4.axi.Axi4Config

import scala.collection.mutable.ArrayBuffer

case class xdmaTester() extends FunSuite{
  var compiled: SimCompiled[xdma_wrapper] = null

  test("compile"){
    compiled = xdmaSimConfig().compile(xdma_wrapper(Axi4Config(32, 32, 4, true, false, true, true, true, true,
      false, true, true, true, true, true)))
  }

  test("testbench"){
    compiled.doSim{
      dut =>
//        dut.io.sys_rst_n #= true
        dut.clockDomain.forkStimulus(5)
        dut.clockDomain.waitSampling(10)
        for(i <- 0 until 100){
          dut.clockDomain.waitSampling()
        }
    }
  }
}

object xdmaTester1 extends App{
  val a = SimConfig.withXSimSourcesPaths(ArrayBuffer("C:\\Users\\zzz\\Desktop\\spinal_xdmaDemo\\xilinx_ip\\xc7k70tfbv676-1\\xdma"),ArrayBuffer(""))
  a.withXSim.withWave.compile(xdma_wrapper(Axi4Config(64, 64, 4, true, false, true, true, true, true,
    false, true, true, true, true, true))).doSim{
    dut =>
      dut.clockDomain.forkStimulus(5)
      for(i <- 0 until 100) {
        sleep(1)
      }
  }
}
