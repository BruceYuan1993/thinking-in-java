package com.bruce.demo.io;

import java.util.prefs.BackingStoreException;
import java.util.prefs.NodeChangeEvent;
import java.util.prefs.NodeChangeListener;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;
import java.util.prefs.PreferencesFactory;

public class PreferencesDemo {
	public static void main(String[] args) {
		Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
		System.out.println(prefs.absolutePath());
		prefs.addNodeChangeListener(new NodeChangeListener() {
			
			@Override
			public void childRemoved(NodeChangeEvent evt) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void childAdded(NodeChangeEvent evt) {
				// TODO Auto-generated method stub
				System.out.println("AddChild--->" + evt.getChild().name());
			}
		});
		
		prefs.addPreferenceChangeListener(new PreferenceChangeListener() {
			
			@Override
			public void preferenceChange(PreferenceChangeEvent evt) {
				// TODO Auto-generated method stub
				System.out.println("PreferenceChange  ---> "+evt.getKey());
			}
		});
		
		
		prefs.put("Location", "OZ");
		prefs.put("Footwear", "Ruby");
		prefs.putInt("Companions", 4);
		prefs.putBoolean("Are", true);
		
		
		int usage = prefs.getInt("UsageCount", 0);
		usage++;
		prefs.putInt("UsageCount", usage);
		
		try {
			for (String key : prefs.keys()) {
				System.out.println(key + " : " + prefs.get(key, null));
			}
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			prefs.removeNode();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
