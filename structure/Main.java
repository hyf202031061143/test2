package structure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("请输入你想选择测试的模式:");
		System.out.println("1:主程序-子程序软件体系结构");
		System.out.println("2:面向对象软件体系结构");
		System.out.println("3:事件系统软件体系结构");
		System.out.println("4:管道-过滤软件体系结构");
		Scanner sc=new Scanner(System.in);
		int model=sc.nextInt();
		if(model==1)
		{
			demo1 kwic = new demo1();
	        kwic.input("D:\\input.txt");
	        kwic.shift();
	        kwic.alphabetizer();
	        kwic.output("D:\\output.txt");
		}
		if(model==2)
		{
			 Input input = new Input();
		        input.input("D:\\input.txt");
		        Shift shift = new Shift(input.getLineTxt());
		        shift.shift();
		        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
		        alphabetizer.sort();
		        Output output = new Output(alphabetizer.getKwicList());
		        output.output("D:\\output.txt");

		}
		if(model==3)
		{
			

			//创建主题
		    KWICSubjecttest kwicSubject = new KWICSubjecttest();
		    //创建观察者
		    Inputtest input = new Inputtest("D:\\input.txt");
		    Shifttest shift = new Shifttest(input.getLineTxt());
		    Alphabetizertest alphabetizer = new Alphabetizertest(shift.getKwicList());
		    Outputtest output = new Outputtest(alphabetizer.getKwicList(), "D:\\output.txt");

		    // 将观察者加入主题
		    kwicSubject.addObserver(input);
		    kwicSubject.addObserver(shift);
		    kwicSubject.addObserver(alphabetizer);
		    kwicSubject.addObserver(output);
		    // 逐步调用各个观察者
		    kwicSubject.startKWIC();
			
		    
	
		}
		if(model==4)
		{
			File inFile = new File("D:\\input.txt");
	        File outFile = new File("D:\\output.txt");
	        Pipe pipe1 = new Pipe();
	        Pipe pipe2 = new Pipe();
	        Pipe pipe3 = new Pipe();
	        Input1 input = new Input1(inFile, pipe1);
	        Shift1 shift= new Shift1(pipe1, pipe2);
	        Alphabetizer1 alphabetizer  = new Alphabetizer1(pipe2, pipe3);
	        Output1 output = new Output1(outFile,pipe3);
	        input.transform();
	        shift.transform();
	        alphabetizer.transform();
	        output.transform();
	
		}
	}
}
