import Generator.{DataGenerator, DataType, TypeEDC}
import Generator.ReportTI


@main
def main(): Unit = {
  println("Generando archivos de datos...")

  //ReportTI.createUnitData(DataType.TOY, 25)
  //ReportTI.createUnitData(DataType.SMALL, 25)
  //ReportTI.createUnitData(DataType.MEDIUM, 20)
  //ReportTI.createUnitData(DataType.BIG, 20)

  //ReportTI.testReportGeneric(DataType.TOY, 25, TypeEDC.DUAL_SUM)
  //ReportTI.testReportGeneric(DataType.SMALL, 25, TypeEDC.DUAL_SUM)
  //ReportTI.testReportGeneric(DataType.MEDIUM, 20, TypeEDC.DUAL_SUM)
  //ReportTI.testReportGeneric(DataType.BIG, 20, TypeEDC.DUAL_SUM)

  //ReportTI.testReportGeneric(DataType.TOY, 25, TypeEDC.CRC)
  //ReportTI.testReportGeneric(DataType.SMALL, 25, TypeEDC.CRC)
  //ReportTI.testReportGeneric(DataType.MEDIUM, 20, TypeEDC.CRC)
  //ReportTI.testReportGeneric(DataType.BIG, 20, TypeEDC.CRC)
  ReportTI.testByFileCRC("1")
  print("Archivo de datos  generado.  ")
  println("Proceso completado.")
}
