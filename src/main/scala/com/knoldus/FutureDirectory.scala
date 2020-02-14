package com.knoldus
import java.io.File

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
//import scala.util.{Failure, Success}


object FutureDirectory extends App {

  def listDirectories(pathDirectory : String) : List[String] = {
    val path :File = new File(pathDirectory)
    val listOfFiles = path.listFiles
    val l1 =List.empty[String]
    for(temporaryList <- listOfFiles)
      if(temporaryList.isFile) {
        println(temporaryList.getPath)
        l1 +: temporaryList.getPath
        Thread.sleep(1000)
      }
      else
        Future
        {
          listDirectories(temporaryList.getPath)
        }
    l1
  }
  Thread.sleep(1200)
  val path = "/home/knoldus/Music"
  val l2:List[String] = listDirectories(path)

  //  l2 onComplete {
  //    case Success(res) => res
  //    case Failure(exception) => exception.getMessage
  //  }

}
