package structure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output1 extends Filter {
    private File file;
    public Output1(File file,Pipe input) {
        super(input, null);
        this.file = file;
    }

    @Override
	public void transform() throws IOException {
        BufferedWriter outputFile =null;
        String line;
        try {
            outputFile = new BufferedWriter(new FileWriter(file));
            while (input.hashNextLine()) {
                outputFile.write(input.readerLine()+"\n");
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
        input.closeReader();
    }
}
