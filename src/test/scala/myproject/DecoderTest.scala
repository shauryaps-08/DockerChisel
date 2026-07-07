package myproject

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class DecoderTest extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "MyModule"

  it should "produce a one-hot output for every 3-bit input" in {
    test(new MyModule) { dut =>
      for (i <- 0 until 8) {
        dut.io.in.poke(i.U)
        dut.clock.step(1)
        dut.io.out.expect((1 << i).U)
      }
    }
  }
}
