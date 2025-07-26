package editor2;

public class DocumentItalicCommand implements Command {

    private Document editableDoc;
    private int line;

    public DocumentItalicCommand(Document doc, int line) {
        this.editableDoc = doc;
        this.line = line;
        editableDoc.Italic(line);
    }

    public void undo() {
        editableDoc.RemoveItalic(line);
    }

    public void redo() {
        editableDoc.Italic(line);
    }

    public String toString() {
        return "Italic";
    }
}
