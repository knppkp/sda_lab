package editor2;

public class DocumentRemoveBoldCommand implements Command {

    private Document editableDoc;
    private int line;

    public DocumentRemoveBoldCommand(Document doc, int line) {
        this.editableDoc = doc;
        this.line = line;
        editableDoc.RemoveItalic(line);
    }

    public void undo() {
        editableDoc.Italic(line);
    }

    public void redo() {
        editableDoc.RemoveItalic(line);
    }

    public String toString() {
        return "UnItalic";
    }
}
