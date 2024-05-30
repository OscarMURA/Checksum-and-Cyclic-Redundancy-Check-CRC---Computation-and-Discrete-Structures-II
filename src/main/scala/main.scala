import Generator.{DataGenerator, DataType, TypeEDC}
import Generator.ReportTI


@main
def main(): Unit = {
  println("Generando archivos de datos...")

  //ReportTI.createUnitData(DataType.TOY, 20)
  //ReportTI.createUnitData(DataType.SMALL, 20)
  //ReportTI.createUnitData(DataType.MEDIUM, 40)
  //ReportTI.createUnitData(DataType.BIG, 40)

  //ReportTI.testReportGeneric(DataType.TOY, 20, TypeEDC.DUAL_SUM)
  //ReportTI.testReportGeneric(DataType.SMALL, 20, TypeEDC.DUAL_SUM)
  //ReportTI.testReportGeneric(DataType.TOY, 20, TypeEDC.CRC)
  //ReportTI.testReportGeneric(DataType.SMALL, 20, TypeEDC.CRC)

  //ReportTI.testReportGeneric(DataType.MEDIUM, 40, TypeEDC.DUAL_SUM)
  //ReportTI.testReportGeneric(DataType.MEDIUM, 40, TypeEDC.CRC)

  ReportTI.testReportGeneric(DataType.BIG, 40, TypeEDC.DUAL_SUM)
  //ReportTI.testReportGeneric(DataType.BIG, 40, TypeEDC.CRC)

  print("Archivo de datos  generado.  ")
  println("Proceso completado.")
}
