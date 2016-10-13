package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (r==0 || r ==1 || c ==0)  1
      else if (c==r)  1
      else pascal(c-1,r-1)+pascal(c,r-1)
    }


  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
//      var flag = 0
      //      var res = true
      //      for (i <- 0 to chars.length-1){
      //        if (chars(i) == '(') flag +=1
      //        else if (chars(i) == ')') flag -=1
      //        print (flag)
      //        if (flag < 0) res = false
      //      }
      //      if (flag!=0) {res = false; res}
      //      else res
      def pa(charss: List[Char], pnum: Int,flag: Boolean): Boolean={
        var p =pnum
        var f = flag
        if (charss.isEmpty) {
          if (pnum != 0) {f = false;f}
          else f
        }
        else {
          if(charss.head == '(') p +=1
          else if(charss.head == ')') p -=1
          if(pnum <0) f = false
          pa(charss.tail,p,f)
        }
      }
      pa(chars,0,true)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money < 0) 0
      else if (coins.isEmpty && money >= 1) 0
      else
        countChange(money, coins.tail) + countChange(money - coins.head, coins)}
  }
