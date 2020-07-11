package mylib

import spinal.core._
object Global {
  def ufix= UFix(10 exp,-22 exp)
  def sfix= SFix(9 exp,-22 exp)
  def ufixConst(f:Float) ={val a=ufix;a:=f;a}
}
