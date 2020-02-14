package com.knoldus

import java.io.File

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}


object FutureDirectory extends App {

  /**
   * Create a application which takes folder path as input and print all the names of files in a directory using Scala futures.
   * @param pathDirectory-A string path of a file/directory
   */
  def listDirectories(pathDirectory: String): Unit = {
    val path: File = new File(pathDirectory)
    val listOfFiles = path.listFiles
    //val l1 = List.empty[String]
    for (temporaryList <- listOfFiles)
      if (temporaryList.isFile) {
        println(temporaryList.getPath)
        //        l1 +: temporaryList.getPath

      }
      else
        Future {
          listDirectories(temporaryList.getPath)
        }

  }

  val path = "/home/knoldus/Music"
  listDirectories(path)

  //  l2 onComplete {
  //    case Success(res) => res
  //    case Failure(exception) => exception.getMessage
  //  }

}
