package decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WordCounterStream extends FilterInputStream {
	
	public WordCounterStream(InputStream in){
		super(in);
	}
	
	@Override
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}
	
	public int read(byte[] b, int off, int len) throws IOException {
		int i = super.read(b, off, len);
		if(i == -1 || i == 0) return 0;
		int words = 1;
		for(int j = off; j < off + i; j++){
			if(b[j] == (byte)'\n' || b[j] == (byte)' ' || b[j] == (byte)'\t') words++;
		}
		return words;
	}
	
}
