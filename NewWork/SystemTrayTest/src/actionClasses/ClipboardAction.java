package actionClasses;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class ClipboardAction extends ActionClass{
	String clipboardContent;
	public ClipboardAction(String cbCon) {
		clipboardContent = cbCon;
	}

	public void run() {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(clipboardContent),
				new StringSelection(clipboardContent));
	}

	public String writeable() {
		return clipboardContent;
	}
}
