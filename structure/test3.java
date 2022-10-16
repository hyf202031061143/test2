package structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;





public class test3 {
//	public static void main(String[] args) {
//	//��������
//    KWICSubjecttest kwicSubject = new KWICSubjecttest();
//    //�����۲���
//    Inputtest input = new Inputtest("D:\\input.txt");
//    Shifttest shift = new Shifttest(input.getLineTxt());
//    Alphabetizertest alphabetizer = new Alphabetizertest(shift.getKwicList());
//    Outputtest output = new Outputtest(alphabetizer.getKwicList(), "D:\\output.txt");
//
//    // ���۲��߼�������
//    kwicSubject.addObserver(input);
//    kwicSubject.addObserver(shift);
//    kwicSubject.addObserver(alphabetizer);
//    kwicSubject.addObserver(output);
//    // �𲽵��ø����۲���
//    kwicSubject.startKWIC();
//	}
}
 class Subjecttest {

    //�۲�������
    private List<Observertest> vector = new LinkedList<>();


    //����һ���۲���
    public void addObserver(Observertest observer) {
        vector.add(observer);
    }

    //ɾ��һ���۲���
    public void deleteObserver(Observertest observer) {
        vector.remove(observer);
    }

    //֪ͨ���й۲���
    public void notifyAllObserver() {
        for(Observertest observer : vector) {
            observer.toDo();
        }
    }

    // ֪ͨ�ض��۲���
    public void notifyOneObserver(int i) {
        vector.get(i).toDo();
    }

}	

 interface Observertest {
	    void toDo();
	}
 class Inputtest implements Observertest{

	    private ArrayList<String> lineTxt = new ArrayList<String>();

	    public ArrayList<String> getLineTxt() {
	        return lineTxt;
	    }
	    private String fileName;

	    public Inputtest(String fileName) {
	        this.fileName = fileName;
	    }

	    @Override
	    public void toDo() {
	        BufferedReader inputFile = null;
	        try {
	            inputFile = new BufferedReader(new FileReader(fileName));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        String line;
	        try {
	            while ((line = inputFile.readLine()) != null) {
	                lineTxt.add(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
 class Shifttest implements Observertest {
	    private ArrayList<String> kwicList = new ArrayList<String>();
	    private ArrayList<String> lineTxt;

	    public Shifttest( ArrayList<String> lineTxt) {
	        this.lineTxt = lineTxt;
	    }

	    public ArrayList<String> getKwicList() {
	        return kwicList;
	    }


	    public ArrayList<String> getLineTxt() {
	        return lineTxt;
	    }

	    @Override
	    public void toDo() {
	        //��ȡÿ�����ʣ�����tokens
	        Iterator<String> it = lineTxt.iterator();
	        while (it.hasNext()) {
	            StringTokenizer token = new StringTokenizer(it.next());
	            ArrayList<String> tokens = new ArrayList<String>();
	            int i = 0;
	            //ѭ����ӵ���
	            int count = token.countTokens();
	            while (i < count) {
	                tokens.add(token.nextToken());
	                i++;
	            }

	            //display(tokens);
	            //�и�������ʣ����ϸı���ʼֵ������loopʵ��λ�ơ�
	            for (i = 0; i < count; i++) {
	                StringBuffer lineBuffer = new StringBuffer();
	                int index = i;
	                for (int f = 0; f < count; f++) {
	                    //��ͷ����λ��
	                    if (index >= count)
	                        index = 0;
	                    //����StringBuffer
	                    lineBuffer.append(tokens.get(index));
	                    lineBuffer.append(" ");
	                    index++;
	                }
	                String tmp = lineBuffer.toString();
	                kwicList.add(tmp);
	            }
	        }

	    }

	}
 class Alphabetizertest implements Observertest {
	    private ArrayList<String> kwicList;

	    public Alphabetizertest(ArrayList<String> kwicList) {
	        this.kwicList = kwicList;
	    }

	    public ArrayList<String> getKwicList() {
	        return kwicList;
	    }

	    @Override
	    public void toDo() {
	        Collections.sort(this.kwicList, new AlphabetizerComparator());
	    }

	    private class AlphabetizerComparator implements Comparator<String> {
	        @Override
	        public int compare(String o1, String o2) {
	            if (o1 == null && o2 == null) {
	                throw new NullPointerException();
	            }
	            int compareValue = 0;
	            char o1c = o1.toLowerCase().charAt(0); //���Դ�Сд
	            char o2c = o2.toLowerCase().charAt(0); //���Դ�Сд
	            compareValue = o1c - o2c;
	            return compareValue;

	        }

	    }

	}
 class Outputtest implements Observertest {
	    private ArrayList<String> kwicList;
	    private BufferedWriter outputFile;
	    private String filename;
	    public Outputtest(ArrayList<String> kwicList,String filename) {
	        this.kwicList = kwicList;
	        this.filename = filename;
	    }

	    @Override
	    public void toDo(){
	        Iterator<String> it = kwicList.iterator();
	        try {
	            outputFile = new BufferedWriter(new FileWriter(filename));
	            while (it.hasNext()) {
	                outputFile.write(it.next()+"\n");
	            }
	        }catch (IOException e){
	            e.printStackTrace();
	        }finally {
	            try {
	                if (outputFile!=null) {
	                    outputFile.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	}
 class KWICSubjecttest extends Subjecttest{
	    public void startKWIC(){
	        for (int i = 0;i<3;i++){
	            super.notifyOneObserver(i);
	        }
	    }
	}

