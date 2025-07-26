package editor2;

public class TestEditor {

    public static void main(String[] args) {
        DocumentInvoker myDocument1 = new DocumentInvoker("callmemaybe");
        myDocument1.Write("Hey I just met you");
        myDocument1.Write("And this is crazy");
        myDocument1.Bold(1);
        myDocument1.Write("But here's my number");
        myDocument1.Redo();
        myDocument1.Undo(0);
        myDocument1.Write("So call me maybe");
        myDocument1.Italic(3);
        myDocument1.Insert(2, "test inert");
        myDocument1.Redo();
        myDocument1.Undo();
        System.out.println(myDocument1.Read());
        myDocument1.printCommandBuffer();

        DocumentInvoker myDocument2 = new DocumentInvoker("callmemaybe");
        myDocument2.Write("Hey I just met you");
        myDocument2.Write("And this is crazy");
        myDocument2.Write("But here's my number");
        myDocument2.Undo(2);
        System.out.println(myDocument2.Read());
        myDocument2.printCommandBuffer();
    }
}
