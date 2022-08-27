package xdma

import spinal.core.SpinalConfig
import spinal.core.sim.{SimClockDomainHandlePimper, SimConfig}
import spinal.lib.bus.amba4.axi.Axi4Config

import scala.collection.mutable.ArrayBuffer

object xdmaMain {
  def main(args: Array[String]): Unit = {
    SpinalConfig(targetDirectory = "rtl/xdma").generateVerilog(xdma_wrapper(Axi4Config(32, 32, 4, true, false, true, true, true, true,
      false, true, true, true, true, true)))
  }
}

//Vivado Test
//object xdmaVivado extends App{
//  val a = SimConfig.withXSimSourcesPaths(ArrayBuffer("C:/Users/zzz/Desktop/spinal_xdmaDemo/xilinx_ip/xc7k70tfbv676-1"),ArrayBuffer(""))
//  a.withXSim.withWave.compile(xdma_wrapper(Axi4Config(32, 32, 4, true, false, true, true, true, true,
//    false, true, true, true, true, true))).doSim{
//    dut =>
//
////      dut.clockDomain.waitSampling(100)
//    //        dut.clockDomain.forkStimulus(10)
//    //        dut.clockDomain.waitSampling(10)
//    //        for(i <- 0 until 100){
//    //          dut.clockDomain.waitSampling()
//    //        }
//  }
//}
