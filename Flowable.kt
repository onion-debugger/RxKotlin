fun main(args: Array<String>) { 
      val source = Observable.range(1, 1000) 
      source.toFlowable(BackpressureStrategy.BUFFER)
        .map { MyItem(it) } 
        .observeOn(Schedulers.io()) 
        .subscribe{
          print("Rec. $it;\t") 
          runBlocking { delay(1000) } 
        } 
        runBlocking { delay(100000) } 
    } 
 
    data class MyItem (val id:Int) { 
      init { 
        print("MyItem init $id") 
      } 
   }
}

