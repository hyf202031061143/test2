package structure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Shift1 extends Filter {

    public Shift1(Pipe input, Pipe output) {
        super(input, output);
    }

    @Override
	public void transform() throws IOException {
        //��ȡÿ�����ʣ�����tokens
        while (input.hashNextLine()) {
            StringTokenizer token = new StringTokenizer(input.readerLine());
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
                output.writerLine(tmp);
            }
        }
        input.closeReader();
        output.closeWriter();
    }
}
