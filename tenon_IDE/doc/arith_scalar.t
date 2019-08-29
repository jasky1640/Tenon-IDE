! RUN: tenonc %s -o %t.asm
! RUN: tvm -t l %t.asm | FileCheck %s

! Binary support
! ---
! RUN: tvm -a %t.asm -o %t.o
! RUN: tvm -t l %t.o | FileCheck %s

module test

var num g_src_a = 123;
var bool g_false = false;
var bool g_true = true;

function void main()
  var num src_a = 123;
  var num src_b = 987;

  var num add_ret;
  var num sub_ret;
  var num mul_ret;
  var num div_ret;

  var num add_const_ret;
  var num sub_const_ret;
  var num mul_const_ret;
  var num div_const_ret;

  var num add_global_ret;
  var num sub_global_ret;
  var num mul_global_ret;
  var num div_global_ret;

  add_ret = src_a + src_b;
  sub_ret = src_a - src_b;
  mul_ret = src_a * src_b;
  div_ret = src_a / src_b;

  add_const_ret = src_a + 987;
  sub_const_ret = src_a - 987;
  mul_const_ret = src_a * 987;
  div_const_ret = src_a / 987;

  add_global_ret = g_src_a + src_b;
  sub_global_ret = g_src_a - src_b;
  mul_global_ret = g_src_a * src_b;
  div_global_ret = g_src_a / src_b;

  var bool l_true = true;
  var bool l_false = false;

  var bool and_ret = l_true and l_false;
  var bool xor_ret = l_true xor l_true;
  var bool or_ret = l_false or l_true;
  var bool not_ret = not l_false;
  var bool or_gret = g_false or g_true;
  var bool not_gret = not g_false;
  
  twrite("Hello World! Hello Tenon!");

! CHECK: src_a          *num            123
! CHECK: src_b          *num            987
! CHECK: add_ret        *num            1110
! CHECK: sub_ret        *num            -864
! CHECK: mul_ret        *num            121401
! CHECK: div_ret        *num            0.12
! CHECK: add_const_ret  *num            1110
! CHECK: sub_const_ret  *num            -864
! CHECK: mul_const_ret  *num            121401
! CHECK: div_const_ret  *num            0.12
! CHECK: add_global_ret *num            1110
! CHECK: sub_global_ret *num            -864
! CHECK: mul_global_ret *num            121401
! CHECK: div_global_ret *num            0.12
! CHECK: l_true         *bool           true
! CHECK: l_false        *bool           false
! CHECK: and_ret        *bool           false
! CHECK: xor_ret        *bool           false
! CHECK: or_ret         *bool           true
! CHECK: not_ret        *bool           true
! CHECK: or_gret        *bool           true
! CHECK: not_gret       *bool           true

end

end
