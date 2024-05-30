import Generator.{DataGenerator, DataType, TypeEDC}
import Generator.ReportTI


@main
def main(): Unit = {
  println("Generando archivos de datos...")

  //ReportTI.createUnitData(DataType.TOY, 20)
  //ReportTI.createUnitData(DataType.SMALL, 20)
  //ReportTI.createUnitData(DataType.MEDIUM, 40)
  //ReportTI.createUnitData(DataType.BIG, 40)

  //ReportTI.testReportGeneric(DataType.TOY, 20, TypeEDC.CRC,0)
  //ReportTI.testReportGeneric(DataType.SMALL, 20, TypeEDC.CRC,0)
  //ReportTI.testReportGeneric(DataType.BIG, 40, TypeEDC.CRC,0)
  ReportTI.testReportGeneric(DataType.MEDIUM, 40, TypeEDC.CRC,0)


  //ReportTI.testReportGeneric(DataType.TOY, 20, TypeEDC.DUAL_SUM,8)
  //ReportTI.testReportGeneric(DataType.SMALL, 20, TypeEDC.DUAL_SUM,8)
  //ReportTI.testReportGeneric(DataType.MEDIUM, 40, TypeEDC.DUAL_SUM,8)
  //ReportTI.testReportGeneric(DataType.BIG, 40, TypeEDC.DUAL_SUM,8)


  //ReportTI.testReportGeneric(DataType.TOY, 20, TypeEDC.DUAL_SUM,16)
  //ReportTI.testReportGeneric(DataType.SMALL, 20, TypeEDC.DUAL_SUM,16)
  //ReportTI.testReportGeneric(DataType.MEDIUM, 40, TypeEDC.DUAL_SUM,16)
  //ReportTI.testReportGeneric(DataType.BIG, 40, TypeEDC.DUAL_SUM,16)

  //ReportTI.testReportGeneric(DataType.TOY, 20, TypeEDC.DUAL_SUM,32)
  //ReportTI.testReportGeneric(DataType.SMALL, 20, TypeEDC.DUAL_SUM,32)
  //ReportTI.testReportGeneric(DataType.MEDIUM, 40, TypeEDC.DUAL_SUM,32)
  //ReportTI.testReportGeneric(DataType.BIG, 40, TypeEDC.DUAL_SUM,32)

  //ReportTI.testReportGeneric(DataType.TOY, 20, TypeEDC.DUAL_SUM,64)
  //ReportTI.testReportGeneric(DataType.SMALL, 20, TypeEDC.DUAL_SUM,64)
  //ReportTI.testReportGeneric(DataType.MEDIUM, 40, TypeEDC.DUAL_SUM,64)
  //ReportTI.testReportGeneric(DataType.BIG, 40, TypeEDC.DUAL_SUM,64)

  print("Archivo de datos  generado.  ")
  println("Proceso completado.")
}
