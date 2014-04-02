

/**
 * @author Anish Nath
 * 
 * http://youtube.com/zarigatongy
 */
object chmod {

  val chmodMap = Map[Char, String](
    '7' -> "rwx",
    '6' -> "rw-",
    '5' -> "r-x",
    '4' -> "r--",
    '3' -> "-wx",
    '2' -> "-w-",
    '1' -> "--x",
    '0' -> "---")

  @throws[Exception]("chmod checked failed")
  def constructPermision(chmod: String): String = {
    val buf = new StringBuilder
    try {
      var x = chmod.toInt
      if (x > 777) {
        throw new IllegalArgumentException("chmod number exceeded it must be range of 000-777")
      }

      for (a <- 0 to 2) {
        try {
          //Scala Map#get and the return of Some()
          //sol mymap.get(something).get
          buf ++= chmodMap.get(chmod.charAt(a)).get
        } catch {
          case e: StringIndexOutOfBoundsException => {}
          case e: Exception => {}
        }

      }

    } catch {
      case e: IllegalArgumentException => throw e;
      case ex: Exception => throw ex;

    }

    buf.toString
  }

  def main(args: Array[String]) {
    for (a <- 0 to 777) {
      val x =  chmod.constructPermision(a.toString);
      if(x.length()>0)
      {
        println("chmod " + a + " " + x);
      }
    }

  }

}