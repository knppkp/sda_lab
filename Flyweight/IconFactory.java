//
// $Header: /home/due1/cvsreps/due/java/pattern/flyweight/IconFactory.java.templ,v 1.1 2002-05-14 09:41:25 due Exp $
//
// Copyright (c) 2002 Eric Dubuis,
// Berner Fachhochschule, HTA Biel.
// All rights reserved.
//
// Based on: J.W. Cooper, Java Design Patterns, Addison-Wesley 2000.


import javax.swing.*;
import java.util.*;

public class IconFactory {
    private Map<String, AbstractIcon> iconmap = new HashMap();

    // Singleton.
    // COMPLETE.
    public AbstractIcon createIcon(String key) {
	// COMPLETE.
        if(iconmap.containsKey(key)) {
            return iconmap.get(key);
        }
        AbstractIcon icon;
        if (key.equals("folder")){
            icon = new FolderIcon();
        } else if(key.equals("java")){
            icon = new JavaIcon();
        } else if (key.equals("pdf")){
            icon = new PdfIcon();
        } else if (key.equals("picture")){
            icon = new PictureIcon();
        } else if (key.equals("text")){
            icon = new TextIcon();
        } else {
            icon = new UnknownIcon();
        }
        iconmap.put(key, icon);
        return icon;
    }

    // Add helper methods here, if any.
}
