package com.example.analytics

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object LogAnalyzer {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .appName("WebLogAnalyzer")
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._

    val logs = spark.read.parquet("/data/warehouse/web_logs")
    
    val errors = logs.filter($"response_code" >= 500)
      .groupBy("url")
      .count()
      .orderBy(desc("count"))
      
    errors.write.mode("overwrite").csv("/reports/errors_daily")
    
    spark.stop()
  }
}
