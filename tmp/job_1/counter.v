// Generator : SpinalHDL v1.7.2    git head : 08fc866bebdc40c471ebe327bface63e34406489
// Component : counter

`timescale 1ns/1ps

module counter (
  output     [7:0]    io_oNum,
  output              io_full,
  input               io_clk,
  input               io_rstn
);

  wire       [8:0]    _zz_io_full;
  wire       [8:0]    _zz_io_full_1;
  wire       [8:0]    _zz_io_full_2;
  reg        [7:0]    myArea_counter;

  assign _zz_io_full = {1'd0, myArea_counter};
  assign _zz_io_full_1 = (_zz_io_full_2 - 9'h001);
  assign _zz_io_full_2 = ({8'd0,1'b1} <<< 8);
  assign io_oNum = myArea_counter;
  assign io_full = (_zz_io_full == _zz_io_full_1);
  always @(posedge io_clk or negedge io_rstn) begin
    if(!io_rstn) begin
      myArea_counter <= 8'h0;
    end else begin
      myArea_counter <= (myArea_counter + 8'h01);
      if(io_full) begin
        myArea_counter <= myArea_counter;
      end
    end
  end


endmodule
