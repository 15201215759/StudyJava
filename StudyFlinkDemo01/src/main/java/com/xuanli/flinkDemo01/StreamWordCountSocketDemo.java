package com.xuanli.flinkDemo01;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author aidan.xuan
 * @version 1.0
 * @date 2021/02/08 11:13
 */
public class StreamWordCountSocketDemo {
    public static void main(String[] args) throws Exception {
        //创建流式执行引擎
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //通过外部传参获取socket参数信息
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        String host = parameterTool.get("host");
        int port = parameterTool.getInt("port");
        //获取socket数据流
        DataStream<String> inputDataStream = env.socketTextStream(host, port);
        //对流数据进行处理，处理成元组（word，1）然后求和
        DataStream<Tuple2<String, Integer>> resultStream = inputDataStream.flatMap(new wordcount.MyFlatMapMapper())                                                              .keyBy(0)
                                                            .sum(1);
        //打印输出
        resultStream.print();
        //执行流处理
        env.execute();
    }
}
