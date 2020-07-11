package mylib
import spinal.core._

class Controller  extends Component {
  val io = new Bundle{
    val HA,HB,HC,LA,LB,LC= out Bool
  }

  for(i<-io.elements){
    i._2 := False
  }

  val period = Reg(UInt(32 bits)).init(10000)
  val cnt = Reg(UInt(32 bits)).init(0)
  val cc1 = Reg(UInt(32 bits)).init(5000)
  val result = Reg(UFix(4 exp,-10 exp))
  cnt := cnt+1
  result := (U4.theta * U4.alpha).truncated
}

class VectorConst(a:Float,b:Float,c:Float,t:Double){
  def A = Global.ufixConst(a)
  def B = Global.ufixConst(b)
  def C = Global.ufixConst(c)

  def theta =  Global.ufixConst(t.toFloat)
}

object U4 extends VectorConst(1,0,0,0)
object U6 extends VectorConst(1,1,0,math.Pi/3)
object U2 extends VectorConst(0,1,0,2*math.Pi/3)
object U3 extends VectorConst(0,1,1,math.Pi)
object U1 extends VectorConst(0,0,1,4*math.Pi/3)
object U5 extends VectorConst(1,0,1,5*math.Pi/3)


class SVPWM extends Component{
  //val  arr = List(U4,U6,U2,U3,U1,U5)
  val targetTheta = in(Global.ufix)

  val area = in UInt (3 bits)

  var u1,u2: VectorConst = U4
  when(targetTheta < Global.ufixConst(60)){
    *t1 = alpha - 0.57735f * beta;
    *t2 = 1.1547f * beta
  }

}