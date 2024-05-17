package Generator

import Generator.DataType
import Generator.Reader
import ModelCheckSum.CheckSum
import java.io.PrintWriter


object ReportTI {

  def createUnitData(dataType: DataType, amount: Int): Unit={
    def sizeOfInterval(min: Int, max: Int, amount: Int): List[Int] = {
      (0 until amount).map(i => min + i *  (max - min) / amount).toList
    }
    val sizesData = sizeOfInterval(dataType.minSize, dataType.maxSize, amount)
    sizesData.foreach(size => {
      DataGenerator.generate(dataType, size)
    })
  }

  def testData(revisions: Int): Unit={
    val dataToy = Reader.getData("Data",DataType.TOY.toString)
    testReport(revisions, dataToy, "ReportToy.csv")
  }

  private def testReport(revisions: Int, data: List[List[Byte]], reportData: String): Unit={
    val writer = new PrintWriter(reportData)
    writer.println("BytesAmount,AverageDualSumTime")

    for (bytes <- data){
      var totalDual:Long = 0
      for (_ <- 1 to revisions){
        val dualSum = new CheckSum()
        dualSum.calculateCheckum(bytes)
        totalDual += dualSum.getTime()
      }
      val averageDualTime = totalDual / revisions
      val bytesAmount = bytes.length

      writer.println(s"$bytesAmount,$averageDualTime")
    }

    writer.close()
  }




}
