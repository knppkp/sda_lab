package editor2;

public class DocumentInsertCommand implements Command {

    private Document editableDoc;
    private int line;
    private String text;

    public DocumentInsertCommand(Document doc, int line, String text) {
        this.editableDoc = doc;
        this.line = line;
        this.text = text;
        editableDoc.Insert(line, text);
    }

    public void undo() {
        editableDoc.Erase(line);
    }

    public void redo() {
        editableDoc.Insert(line, text);
    }

    public String toString() {
        return "Insert";
    }
}
