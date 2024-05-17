package Generator

import Generator.DataType
import scala.util.Random
import java.io.{File, PrintWriter}

class DataGenerator {

  def generate(dataType: DataType, size: Int): Unit = {
    val generatedData = generateData(size)
    val folderName = dataType.toString.toUpperCase
    val path = s"Data/$folderName"
    val folder = new File(path)
    if (!folder.exists()) {
      folder.mkdirs()
    }
    
    val identification = getNextFileNumber(folder)
    val filePath = s"$path/$identification.txt"
    val writer = new PrintWriter(filePath)
    
    try {
      writer.write(generatedData)
    } finally {
      writer.close()
    }
  }

  private def generateData(size: Int): String = {
    val chars = ('a' to 'z') ++ ('A' to 'Z') ++ ('0' to '9')
    val randomChars = Seq.fill(size)(chars(Random.nextInt(chars.length)))
    randomChars.mkString
  }

  private def getNextFileNumber(path: File): Int =
    val ThereAreFile = path.listFiles().map(_.getName).filter(_.endsWith(".txt"))
    if (!ThereAreFile.nonEmpty) 1 else ThereAreFile.map(_.stripSuffix(".txt").toInt).max + 1

}
object DataGenerator extends DataGenerator



