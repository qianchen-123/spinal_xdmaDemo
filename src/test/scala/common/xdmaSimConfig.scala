package common

import spinal.core.SpinalConfig
import spinal.core.sim.SimConfig

import scala.collection.mutable.ArrayBuffer

object xdmaSimConfig {
  def apply() = SimConfig.withXSim.withWave.withConfig(SpinalConfig(targetDirectory = "rtl/xdma")).workspacePath("waves")
    .withXSimSourcesPaths(ArrayBuffer("C:/Users/zzz/Desktop/spinal_xdmaDemo/xilinx_ip/xc7k70tfbv676-1"),ArrayBuffer(""))
}
