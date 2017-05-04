package view;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JMenuBar;

@SuppressWarnings("serial")
class VerticalMenuBar extends JMenuBar {
	  private static final LayoutManager grid = new GridLayout(0,1);
	  
	  public VerticalMenuBar() {
	    setLayout(grid);
	  }
	}
