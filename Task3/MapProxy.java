//
// $Header: /home/due1/cvsreps/due/java/pattern/proxy/MapProxy.java.templ,v 1.1 2003-05-06 09:35:04 due Exp $
//
// Copyright (c) 2001 by Eric Dubuis,
// BFH, HTA Biel-Bienne.
// All rights reserved.

package Task3;

import java.util.HashMap;

public class MapProxy implements AbstractMap {

    private String fileName;
    private Map map = null; 
    private HashMap<String, String> hashtable = new HashMap<>();

    public MapProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String find(String key) throws Exception {
        // Check if key is already cached
        String value = get(key);
        if (value == null) {
            // If not cached, fetch from real map and cache it
            value = getMap().find(key);
            if (value != null) {
                put(key, value);
            }
        }
        return value;
    }

    @Override
    public void add(String key, String value) throws Exception {
        // Add to real map
        getMap().add(key, value);
        // Update cache
        put(key, value);
    }

    // Lazy initialization of the real Map
    private Map getMap() {
        if (map == null) {
            map = new Map(fileName);
        }
        return map;
    }

    // Helper cache methods
    private String get(String key) {
        return hashtable.get(key);
    }

    private void put(String key, String value) {
        hashtable.put(key, value);
    }
}
