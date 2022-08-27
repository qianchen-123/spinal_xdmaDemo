package counter
import spinal.core._
import spinal.core.sim.{SimBitVectorPimper, SimBoolPimper, SimClockDomainHandlePimper, SimClockDomainPimper, SimConfig}
import spinal.lib._

case class counter() extends Component{
  val io = new Bundle{
    val oNum = out UInt(8 bits)
    val full = out Bool()

    val clk = in Bool()
    val rstn = in Bool()
  }


  val clkDomain = ClockDomain(
    clock = io.clk,
    reset = io.rstn,
    config = ClockDomainConfig(
      clockEdge = RISING,
      resetKind = ASYNC,
      resetActiveLevel = LOW
    )
  )

  val myArea = new ClockingArea(clkDomain){
    val counter = Reg(UInt(8 bits)) init(0)
    counter := counter + 1
    when(io.full){
      counter := counter
    }
  }
  io.oNum := myArea.counter
  io.full := myArea.counter === (U"1" << 8) - 1


}


object counterDemo{
  def main(args : Array[String]) : Unit = {
    SpinalConfig(targetDirectory = "rtl").generateVerilog(counter())
  }
}


object DemoAddVivado extends App{
  val a = SimConfig
  a.withXSim.withWave.compile(counter()).doSim{
    dut =>
      dut.clkDomain.forkStimulus(5)
      dut.clkDomain.waitSampling(10)
      for(i <- 0 until 200){
        dut.io.rstn #= true
        dut.clkDomain.waitSampling()
      }
      dut.clkDomain.waitSampling(50)
  }
}

 class Demo1 extends Component{
  val io = new Bundle{
    val a = in UInt(32 bits)
    val b = in UInt(32 bits)
    val c = out(Reg(UInt(32 bits)) init(0))
  }

  noIoPrefix()
  io.c := RegNext(io.a + io.b)
}

object Demo1Vivado extends App{
  val a = SimConfig
  a.withXSim.withWave.compile(new Demo1).doSim{
    dut =>
      dut.clockDomain.forkStimulus(5)
      dut.clockDomain.waitSampling(10)
      for(i <- 0 until 200){
        dut.io.a #= i
        dut.io.b #= i
        dut.clockDomain.waitSampling()
      }
      dut.clockDomain.waitSampling(50)
  }
}


