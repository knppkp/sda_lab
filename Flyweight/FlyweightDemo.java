//
// $Header: /home/due1/cvsreps/due/java/pattern/flyweight/FlyweightDemo.java.templ,v 1.1 2002-05-14 09:41:24 due Exp $
//
// Copyright (c) 2002 Eric Dubuis,
// Berner Fachhochschule, HTA Biel.
// All rights reserved.
//
// Based on: J.W. Cooper, Java Design Patterns, Addison-Wesley 2000.


import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class FlyweightDemo extends JFrame implements MouseMotionListener
{
    private ArrayList<Item> items;
    private IconFactory factory;
    private final int Top = 30, Left = 30;
    private final int  W = 50, H = 30;
    private final int VSpace = 80, HSpace=70, HCount = 3;
    private String selectedName = "";

    private class Item {
        String type;
        String name;
        AbstractIcon icon;
        Item(String type, String name, AbstractIcon icon) {
            this.type = type;
            this.name = name;
            this.icon = icon;
        }
    }

    public FlyweightDemo() {
        super("Flyweight Demo");
        setSize(new Dimension(250,300));
        JPanel jp = new JPanel();
        getContentPane().add(jp, BorderLayout.CENTER);
        addMouseMotionListener(this);
	    addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {System.exit(0);}
	    });

        loadItems();

        setVisible(true);
    }

    private void loadItems() {
	// Get the icon factory.
	// COMPLETE.
        IconFactory factory = new IconFactory();

	// Create a bunch of different kind of items.
	// COMPLETE.
        items = new ArrayList();

        AbstractIcon folderSelIcon = factory.createIcon("folder");
        AbstractIcon folderUnselIcon = factory.createIcon("folder");
        AbstractIcon javaIcon = factory.createIcon("java");
        AbstractIcon pdfIcon = factory.createIcon("pdf");
        AbstractIcon pictureIcon = factory.createIcon("picture");
        AbstractIcon textIcon = factory.createIcon("text");
        AbstractIcon unknownIcon = factory.createIcon("unknown");
        AbstractIcon unknownIcon2 = factory.createIcon("unknown");

        Item item1 = new Item("folder", "folderSel", folderSelIcon);
        Item item2 = new Item("folder", "folderUnsel", folderUnselIcon);
        Item item3 = new Item("java", "java", javaIcon);
        Item item4 = new Item("pdf", "pdf", pdfIcon);
        Item item5 = new Item("picture", "picture", pictureIcon);
        Item item6 = new Item("text", "text", textIcon);
        Item item7 = new Item("unknown", "unknown", unknownIcon);
        Item item8 = new Item("unknown", "unknown", unknownIcon2);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
    }


    public void paint(Graphics g) {
	// super.paint(g);
        //Folder f;
        Item item;

        int j = 0;      //count number in row
        int row = Top;  //start in upper left
        int x = Left;

        //go through all the items
        for (int i = 0; i< items.size(); i++) {
	    // Get next item, and draw its icon and name:
	    // COMPLETE.
            item = items.get(i);
            if (i == 0){
                item.icon.draw(g, x, row, item.name, true);
            } else {
                item.icon.draw(g, x, row, item.name, false);
            }


	    // Recalculation of part of the extrinsic state:
            x = x + HSpace;          //change to next posn
            j++;
            if (j >= HCount) {       //reset for next row
                j = 0;         
                row += VSpace;
                x = Left;
            }
        }
    }

    public void mouseMoved(MouseEvent e) {
        int j = 0;      //count number in row
        int row = Top;  //start in upper left
        int x = Left;

        //go through all the items
        for (int i = 0; i< items.size(); i++) {
            //see if this item area contains the mouse
            Rectangle r = new Rectangle(x,row,W,H);
            if (r.contains(e.getX(), e.getY())) {
                selectedName = ((Item)items.get(i)).name;
                repaint();
            }
            x = x + HSpace;          //change to next posn
            j++;
            if (j >= HCount) {       //reset for next row
                j = 0;         
                row += VSpace;
                x = Left;
            }
        }
    }
    public void mouseDragged(MouseEvent e) {
    }

    public static  void main(String[] args) {
        new FlyweightDemo();
    }
}
