package LegendaryCardMaker.CustomCardMaker.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import LegendaryCardMaker.CustomCardMaker.CustomCardMakerFrame;
import LegendaryCardMaker.CustomCardMaker.structure.ElementText;

public class TextMenuItem extends JMenuItem implements ActionListener {
	
	public ElementText property;
	public CustomCardMakerFrame frame;
	
	public TextMenuItem(CustomCardMakerFrame frame, ElementText property)
	{
		this.property = property;
		this.frame = frame;
		
		setText("Set " + property.name + "...");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = JOptionPane.showInputDialog(frame, "Set " + property.name + "...", property.value == null ? property.defaultValue : property.value);
		if (s == null) { s = property.value; }
		if (s != null && s.isEmpty()) { s = null; }
		property.value = s;
		frame.reRenderCard();
		frame.hm.card.changed = true;
	}
}
