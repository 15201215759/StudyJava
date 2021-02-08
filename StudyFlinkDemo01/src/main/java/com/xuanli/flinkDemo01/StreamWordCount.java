package com.xuanli.flinkDemo01;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author aidan.xuan
 * @version 1.0
 * @date 2021/02/08 10:42
 */
public class StreamWordCount {
    public static void main(String[] args) {
        //创建流处理执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //设置程序并行度，线程数。如果不设置默认是cpu线程数量
        env.setParallelism(1);
        //文件路径
        String inputPath="F:\\codeworkspace\\" +
                "StudyJava\\StudyFlinkDemo01\\" +
                "src\\main\\resources\\wordcount.txt";
        DataStream<String> inputdataStream = env.readTextFile(inputPath);
        //基于数据流转换数据
        DataStream<Tuple2<String, Integer>> resultStream = inputdataStream.flatMap(new wordcount.MyFlatMapMapper())
                                                                          .keyBy(0)
                                                                          .sum(1);
        resultStream.print();
        //以上程序，定义程序执行逻辑，添加env.execute().添加程序事件触发，执行流式处理。
        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
