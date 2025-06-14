package View;

import java.io.OutputStream;
import javax.swing.JTextArea;

public class TextAreaOutputStream extends OutputStream{
	private final JTextArea textArea;
	
	public TextAreaOutputStream(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	public void write(int b) {
		textArea.append(String.valueOf((char)b));
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	public void write(byte[] b, int off, int len) {
		textArea.append(new String(b, off, len));
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
}
