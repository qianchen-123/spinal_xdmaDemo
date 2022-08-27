// Generator : SpinalHDL v1.7.2    git head : 08fc866bebdc40c471ebe327bface63e34406489
// Component : counter

`timescale 1ns/1ps

module counter (
  output     [7:0]    io_oNum,
  input               io_clk,
  input               io_rstn
);

  reg        [7:0]    myArea_counter;

  assign io_oNum = myArea_counter;
  always @(posedge io_clk or negedge io_rstn) begin
    if(!io_rstn) begin
      myArea_counter <= 8'h0;
    end else begin
      myArea_counter <= (myArea_counter + 8'h01);
    end
  end


endmodule
