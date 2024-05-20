package Generator

import Generator.DataType
import Generator.Reader
import ModelCheckSum.CheckSum
import ModelCRC.CRC
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
    val dataToyBytes = Reader.getData("Data",DataType.TOY.toString)
    val dataToyString=Reader.getDataString("Data",DataType.TOY.toString)
    val dataSmallBytes = Reader.getData("Data",DataType.SMALL.toString)
    val dataSmallString=Reader.getDataString("Data",DataType.SMALL.toString)
    val dataMediumBytes = Reader.getData("Data",DataType.MEDIUM.toString)
    val dataMediumString=Reader.getDataString("Data",DataType.MEDIUM.toString)

    testReport(revisions, dataToyBytes, "Report/ReportToy.csv", dataToyString)
    println("Toy data tested")
    testReport(revisions, dataSmallBytes, "Report/ReportSmall.csv", dataSmallString)
    println("Small data tested")
    testReport(revisions, dataMediumBytes, "Report/ReportMedium.csv", dataMediumString)
    println("Medium data tested")
  }

  import java.io.PrintWriter

  private def testReport(revisions: Int, dataB: List[List[Byte]], reportData: String, dataS: List[String]): Unit = {
    val writer = new PrintWriter(reportData)
    print("Creating report: ")
    println(reportData)
    writer.println("BytesAmount,AverageDualSumTimeMS,AverageDualSumTimeNS,AverageCRCTimeMS,AverageCRCTimeNS")

    for (i <- dataB.indices) {
      var totalDualMillSeconds: Long = 0
      var totalDualNanoSeconds: Long = 0
      var totalCRCMillSeconds: Long = 0
      var totalCRCNanoSeconds: Long = 0

      for (_ <- 1 to revisions) {
        val dualSum = new CheckSum()
        val crc = new CRC()

        dualSum.calculateCheckum(dataB(i))
        crc.calculateCRC(dataS(i))

        totalDualMillSeconds += dualSum.getTimeMS()
        totalDualNanoSeconds += dualSum.getTimeNS()
        totalCRCMillSeconds += crc.getTimeMS() // Uncomment and implement if necessary
        totalCRCNanoSeconds += crc.getTimeNS() // Uncomment and implement if necessary
      }

      val averageDualTimeMS = totalDualMillSeconds / revisions
      val averageDualTimeNS = totalDualNanoSeconds / revisions
      val averageCRCMillSeconds = totalCRCMillSeconds / revisions
      val averageCRCNanoSeconds = totalCRCNanoSeconds / revisions
      val bytesAmount = dataB(i).length
      print("Index: ")
      println(i)

      writer.println(s"$bytesAmount,$averageDualTimeMS,$averageDualTimeNS,$averageCRCMillSeconds,$averageCRCNanoSeconds")
    }

    writer.close()
  }


}
