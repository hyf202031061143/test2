package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import structure.Alphabetizer;
import structure.Alphabetizer1;
import structure.Input;
import structure.Input1;
import structure.Output;
import structure.Output1;
import structure.Pipe;
import structure.Shift;
import structure.Shift1;

import structure.demo1;

public class TestButton {
	Button b1,b2;
    public static void main(String[] args) {
        Frame frame = new Frame("Test Button");


        /**
         * public void addActionListener(ActionListener l)
         * ActionListener��һ���ӿ���������Ҫд����̳�����ӿ�
         * void actionPerformed(ActionEvent e)
         * Invoked when an action occurs.
         * ��д����ӿ��еķ���
         */
        Panel panel = new Panel();
        Button button1 = new Button("������-�ӳ��������ϵ�ṹ");
        Button button2 = new Button("������������ϵ�ṹ");
        Button button3 = new Button("�¼�ϵͳ�����ϵ�ṹ");
        Button button4 = new Button("�ܵ�-���������ϵ�ṹ");
        button1.addActionListener(new ButtonHandler1());
        button2.addActionListener(new ButtonHandler2());
        button3.addActionListener(new ButtonHandler3());
        button4.addActionListener(new ButtonHandler4());
        
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        frame.add(panel, BorderLayout.NORTH);

//        frame.pack();//������������С
        frame.setVisible(true);
    }
}

class ButtonHandler1 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	demo1 kwic = new demo1();
        kwic.input("D:\\input.txt");
        kwic.shift();
        kwic.alphabetizer();
        kwic.output("D:\\output.txt");
        FileInputStream fis = null;
        try {
         File file = new File("D://output.txt");
         fis = new FileInputStream(file);
         byte[] b = new byte[(int)file.length()];
         while (fis.read(b) != -1) {
         }
         System.out.println(new String(b));
        } catch (Exception e1) {
         e1.printStackTrace();
        }
        
    }
}
class ButtonHandler2 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
    	Input input = new Input();
        input.input("D:\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("D:\\output.txt");
    	FileInputStream fis = null;
    	try {
            File file = new File("D://output.txt");
            fis = new FileInputStream(file);
            byte[] b = new byte[(int)file.length()];
            while (fis.read(b) != -1) {
            }
            System.out.println(new String(b));
           } catch (Exception e1) {
            e1.printStackTrace();
           }
    }
}
class ButtonHandler3 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	FileInputStream fis = null;
    	try {
            File file = new File("D://output.txt");
            fis = new FileInputStream(file);
            byte[] b = new byte[(int)file.length()];
            while (fis.read(b) != -1) {
            }
            System.out.println(new String(b));
           } catch (Exception e1) {
            e1.printStackTrace();
           }
    }
}
class ButtonHandler4 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
    	File inFile = new File("D:\\input.txt");
        File outFile = new File("D:\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input1 input = new Input1(inFile, pipe1);
        Shift1 shift= new Shift1(pipe1, pipe2);
        Alphabetizer1 alphabetizer  = new Alphabetizer1(pipe2, pipe3);
        Output1 output = new Output1(outFile,pipe3);
        try {
			input.transform();
			shift.transform();
			alphabetizer.transform();
			output.transform();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        

    	FileInputStream fis = null;
    	try {
            File file = new File("D://output.txt");
            fis = new FileInputStream(file);
            byte[] b = new byte[(int)file.length()];
            while (fis.read(b) != -1) {
            }
            System.out.println(new String(b));
           } catch (Exception e1) {
            e1.printStackTrace();
           }
    }
}


