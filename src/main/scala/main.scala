import Generator.{DataGenerator, DataType}
import Generator.ReportTI


@main
def main(): Unit = {
  println("Generando archivos de datos...")
  //ReportTI.createUnitData(DataType.TOY, 25)
  //ReportTI.createUnitData(DataType.SMALL, 25)
  //ReportTI.createUnitData(DataType.MEDIUM, 25)
  ReportTI.testData( 25)
  println("Archivo de datos TOY generado.")
  println(DataType.TOY)

  println("Proceso completado.")
}
