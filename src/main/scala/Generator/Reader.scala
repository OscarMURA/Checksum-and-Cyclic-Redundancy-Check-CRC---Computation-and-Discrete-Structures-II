package Generator

import java.nio.file.{Files, Paths}
import scala.util.{Try, Success, Failure}

class Reader() {
  /**
   * Retrieves information from files in a directory based on the specified size category.
   * @param sizeCategory The size category for which directory information is requested.
   * @return A list of byte lists representing the content of files in the specified directory.
   */
  def getData( path: String, sizeCategory: String): List[List[Byte]] = {
    val directory = new java.io.File(s"$path/${sizeCategory.toLowerCase}")
    if (directory.isDirectory) {
      directory.listFiles(_.isFile).toList.flatMap { file =>
        Try(Files.readAllBytes(Paths.get(file.getAbsolutePath)).toList) match {
          case Success(content) => Some(content)
          case Failure(_) => None
        }
      }
    } else {
      List.empty
    }
  }

  import java.nio.file.{Files, Paths}
  import scala.util.{Try, Success, Failure}

  /**
   * Retrieves information from files in a directory based on the specified size category.
   *
   * @param sizeCategory The size category for which directory information is requested.
   * @return A list of strings representing the content of files in the specified directory.
   */
  def getDataString(path: String, sizeCategory: String): List[String] = {
    val directory = new java.io.File(s"$path/${sizeCategory.toLowerCase}")
    if (directory.isDirectory) {
      directory.listFiles(_.isFile).toList.flatMap { file =>
        Try(new String(Files.readAllBytes(Paths.get(file.getAbsolutePath)))) match {
          case Success(content) => Some(content)
          case Failure(_) => None
        }
      }
    } else {
      List.empty
    }
  }


}

object Reader extends Reader


