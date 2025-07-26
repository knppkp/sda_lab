package editor2;

public class TestEditor {

    public static void main(String[] args) {
        DocumentInvoker myDocument = new DocumentInvoker("callmemaybe");
        myDocument.Write("Hey I just met you");
        myDocument.Write("And this is crazy");
        myDocument.Bold(1);
        myDocument.Write("But here's my number");
        myDocument.Redo();
        myDocument.Undo(0);
        myDocument.Write("So call me maybe");
        myDocument.Italic(3);
        myDocument.Redo(4);
        myDocument.Insert(2, "test inert");
        myDocument.Redo();
        myDocument.Undo();
        System.out.println(myDocument.Read());
        myDocument.printCommandBuffer();
    }
}
