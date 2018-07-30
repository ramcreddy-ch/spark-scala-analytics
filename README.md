# Spark Scala Analytics

Spark batch processing jobs written in Scala for high-performance log analysis.

## Jobs
- `LogAnalyzer`: Identifies top error-generating URLs.
- `UserSessionize`: Reconstructs user sessions from raw clicks.

## Build
```bash
sbt package
```

## Submit
```bash
spark-submit --class com.example.analytics.LogAnalyzer target/scala-2.11/spark-scala-analytics_2.11-1.0.jar
```
