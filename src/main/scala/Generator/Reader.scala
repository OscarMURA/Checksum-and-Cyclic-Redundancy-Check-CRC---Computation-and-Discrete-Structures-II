package Generator
import scala.io.Source
import java.nio.file.{Files, Paths}
import scala.util.{Try, Success, Failure}


class Reader {

  /**
   * Reads the content of a file as a List of bytes.
   *
   * @param filePath the path to the file
   * @return the file content as a List of bytes
   */
  def getDataByte(filePath: String): List[Byte] = {
    val path = Paths.get(filePath)
    Files.readAllBytes(path).toList
  }

  /**
   * Reads the content of a file as a String.
   *
   * @param filePath the path to the file
   * @return the file content as a String
   */
  def getDataString(filePath: String): String = {
    Source.fromFile(filePath).mkString
  }
}

object Reader extends Reader