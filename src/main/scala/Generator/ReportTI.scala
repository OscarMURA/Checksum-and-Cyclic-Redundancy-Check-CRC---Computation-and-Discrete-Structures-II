package Generator

import Generator.DataType
import Generator.Reader
import ModelCheckSum.CheckSum
import ModelCRC.CRC
import java.io.PrintWriter
import Interface.EDC

object ReportTI {

  private var iterations: Int = 25
  private var crc: Int = 15

  def createUnitData(dataType: DataType, amount: Int): Unit={
    def sizeOfInterval(min: Int, max: Int, amount: Int): List[Int] = {
      (0 until amount).map(i => min + i *  (max - min) / amount).toList
    }
    val sizesData = sizeOfInterval(dataType.minSize, dataType.maxSize, amount)
    sizesData.foreach(size => {
      DataGenerator.generate(dataType, size)
    })
  }

  def testReportGeneric(dataType: DataType, amountData: Int,edc: TypeEDC): Unit={
    if(edc==TypeEDC.CRC) testReportCRC(dataType, amountData, edc)
    else testReportCheckSum(dataType, amountData,edc)
  }

   private def  testReportCheckSum(dataType: DataType, amountData: Int,edc: TypeEDC): Unit = {
    val writer=new PrintWriter(("Report/Report"+dataType.toString+edc.toString+".csv"))
    writer.println("Name,BytesAmount,AverageDualSumTimeMS,AverageDualSumTimeNS")
    val range=1 to amountData
    range.foreach(i =>
      val data=Reader.getDataByte("Data/"+dataType.toString+"/"+i+".txt")
      val range2= 1 to iterations
      var timeDualSum: Long = 0
      var timeDualSumNS: Long = 0
      range2.foreach(j =>
        val EDCvar = new CheckSum()
        EDCvar.calculateTime(data)
        if(j>1){
          timeDualSum+=EDCvar.getTimeMS()
          timeDualSumNS+=EDCvar.getTimeNS()
        }
        //println(("Iteration: "+j))
      )
      timeDualSum=timeDualSum/iterations
      timeDualSumNS=timeDualSumNS/iterations
      println((" File "+i))
      writer.println(s"$i,${data.length},$timeDualSum,$timeDualSumNS")
    )
     println("Report created")
    writer.close()
  }

   private def testReportCRC(dataType: DataType, amountData: Int,edc: TypeEDC): Unit = {
    val writer=new PrintWriter(("Report/Report"+dataType.toString+edc.toString+".csv"))
    writer.println("Name,lenght,AverageDualSumTimeMS,AverageDualSumTimeNS")
    val range=1 to amountData
    range.foreach(i =>
      val data=Reader.getDataString("Data/"+dataType.toString+"/"+i+".txt")
      val range2= 1 to crc
      var timeDualSum: Long = 0
      var timeDualSumNS: Long = 0
      range2.foreach(j =>
        val EDCvar = new CRC()
        EDCvar.calculateTime(data)
        if(j>1){
          timeDualSum+=EDCvar.getTimeMS()
          timeDualSumNS+=EDCvar.getTimeNS()
        }
        //println(("Iteration: "+j))
      )
      timeDualSum=timeDualSum/crc
      timeDualSumNS=timeDualSumNS/crc
      writer.println(s"$i,${data.length},$timeDualSum,$timeDualSumNS")
      println((" File "+i))
    )

    writer.close()
  }

}
