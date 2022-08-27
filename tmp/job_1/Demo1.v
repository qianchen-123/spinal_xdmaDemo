// Generator : SpinalHDL v1.7.2    git head : 08fc866bebdc40c471ebe327bface63e34406489
// Component : Demo1

`timescale 1ns/1ps

module Demo1 (
  input      [31:0]   a,
  input      [31:0]   b,
  output reg [31:0]   c,
  input               clk,
  input               reset
);

  reg        [31:0]   _zz_c;

  always @(posedge clk or posedge reset) begin
    if(reset) begin
      c <= 32'h0;
    end else begin
      c <= _zz_c;
    end
  end

  always @(posedge clk) begin
    _zz_c <= (a + b);
  end


endmodule
