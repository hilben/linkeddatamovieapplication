package main;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import com.cloudgarden.resource.SWTResourceManager;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Panel;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Gui extends org.eclipse.swt.widgets.Composite implements MouseListener, KeyListener {

	private Menu menu1;
	private Button SearchButton;
	private Panel panel1;
	private Frame frame1;
	private Composite composite1;
	private PlayerPanel player;
	private Button trailerButton;
	private List ListResults;
	private Text TextSearch;
	private Label SearchLabel;
	private MenuItem aboutMenuItem;
	private MenuItem contentsMenuItem;
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private Label ProgName;
	private MenuItem exitMenuItem;
	private MenuItem closeFileMenuItem;
	private MenuItem saveFileMenuItem;
	private MenuItem newFileMenuItem;
	private MenuItem openFileMenuItem;
	private Menu fileMenu;
	private MenuItem fileMenuItem;
	
	public void openTrailer(String url) throws URISyntaxException, IOException{
		
			URI uri = new java.net.URI( url);
			Desktop desk = Desktop.getDesktop();
			desk.browse(uri);			
			
			
	}
			
	
	
	public  LDR ldr;

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	
	
	public Gui(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	/**
	* Initializes the GUI.
	*/
	private void initGUI() {
		
		ldr = new LDR();
		
		try {
			this.setSize(833, 417);
			this.setBackground(SWTResourceManager.getColor(192, 192, 192));
			FormLayout thisLayout = new FormLayout();
			this.setLayout(thisLayout);
			this.setBackgroundMode(1);
			

			{
				trailerButton = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData trailerButtonLData = new FormData();
				trailerButtonLData.left =  new FormAttachment(0, 1000, 406);
				trailerButtonLData.top =  new FormAttachment(0, 1000, 64);
				trailerButtonLData.width = 82;
				trailerButtonLData.height = 25;
				trailerButton.setLayoutData(trailerButtonLData);
				trailerButton.setText("Watch Trailer");
				trailerButton.addMouseListener(this);
			}
			{
				SearchButton = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData SerachButtonLData = new FormData();
				SerachButtonLData.left =  new FormAttachment(0, 1000, 299);
				SerachButtonLData.top =  new FormAttachment(0, 1000, 27);
				SerachButtonLData.width = 95;
				SerachButtonLData.height = 25;
				SearchButton.setLayoutData(SerachButtonLData);
				SearchButton.setText("Go!");
				SearchButton.addMouseListener(this);
			}
			{
				FormData ListResultsLData = new FormData();
				ListResultsLData.left =  new FormAttachment(0, 1000, 12);
				ListResultsLData.top =  new FormAttachment(0, 1000, 64);
				ListResultsLData.width = 362;
				ListResultsLData.height = 336;
				ListResults = new List(this, SWT.V_SCROLL);
				ListResults.setLayoutData(ListResultsLData);
				ListResults.setSelection(new java.lang.String[] {""});
				ListResults.setToolTipText("Double-Click on Item to see Details");
				ListResults.addMouseListener(this);
			}
			{
				TextSearch = new Text(this, SWT.NONE);
				FormData TextSearchLData = new FormData();
				TextSearchLData.left =  new FormAttachment(0, 1000, 59);
				TextSearchLData.top =  new FormAttachment(0, 1000, 33);
				TextSearchLData.width = 228;
				TextSearchLData.height = 15;
				TextSearch.setLayoutData(TextSearchLData);
				TextSearch.addKeyListener(this);
			}
			{
				SearchLabel = new Label(this, SWT.NONE);
				FormData SearchLabelLData = new FormData();
				SearchLabelLData.left =  new FormAttachment(0, 1000, 12);
				SearchLabelLData.top =  new FormAttachment(0, 1000, 33);
				SearchLabelLData.width = 35;
				SearchLabelLData.height = 15;
				SearchLabel.setLayoutData(SearchLabelLData);
				SearchLabel.setText("Search");
			}
			{
				ProgName = new Label(this, SWT.NONE);
				FormData ProgNameLData = new FormData();
				ProgNameLData.left =  new FormAttachment(0, 1000, 6);
				ProgNameLData.top =  new FormAttachment(0, 1000, 12);
				ProgNameLData.width = 127;
				ProgNameLData.height = 15;
				ProgName.setLayoutData(ProgNameLData);
				ProgName.setText("Movie Database Crawler");
			}
			

			{
				menu1 = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menu1);
				{
					fileMenuItem = new MenuItem(menu1, SWT.CASCADE);
					fileMenuItem.setText("File");
					{
						fileMenu = new Menu(fileMenuItem);
						{
							openFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							openFileMenuItem.setText("Open");
						}
						{
							newFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							newFileMenuItem.setText("New");
						}
						{
							saveFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							saveFileMenuItem.setText("Save");
						}
						{
							closeFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							closeFileMenuItem.setText("Close");
						}
						{
							exitMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							exitMenuItem.setText("Exit");
						}
						fileMenuItem.setMenu(fileMenu);
					}
				}
				{
					helpMenuItem = new MenuItem(menu1, SWT.CASCADE);
					helpMenuItem.setText("Help");
					{
						helpMenu = new Menu(helpMenuItem);
						{
							contentsMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							contentsMenuItem.setText("Contents");
						}
						{
							aboutMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							aboutMenuItem.setText("About");
						}
						helpMenuItem.setMenu(helpMenu);
					}
				}
			}
			this.layout();
			
			String temp = this.TextSearch.getText();
			ldr.saveSearchResults(temp);
			ArrayList<Film> tl = ldr.getSearchResultNames();	
			Collections.sort(tl);
			this.ListResults.removeAll();
			this.ListResults.redraw();
			for(int i=0; i < tl.size(); i++){
				this.ListResults.add(tl.get(i).getName());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
	
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		Gui inst = new Gui(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}


	@Override
	public void mouseDoubleClick(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseDown(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(SearchButton)){
			String temp = this.TextSearch.getText();
			ldr.saveSearchResults(temp);
			ArrayList<Film> tl = ldr.getSearchResultNames();	
			Collections.sort(tl);
			this.ListResults.removeAll();
			this.ListResults.redraw();
			for(int i=0; i < tl.size(); i++){
				this.ListResults.add(tl.get(i).getName());
			}
		}else if(arg0.getSource().equals(trailerButton)){
			try {
				SearchHelper sh = new SearchHelper();
				Youtube tube = new Youtube();
				this.openTrailer(tube.searchTrailer(sh.formatSearchString(ldr.getFilmName(this.ListResults.getSelectionIndex())) + " trailer"));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mouseUp(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(this.TextSearch) && (arg0.keyCode == 13)){
			String temp = this.TextSearch.getText();
			ldr.saveSearchResults(temp);
			ArrayList<Film> tl = ldr.getSearchResultNames();		
			Collections.sort(tl);
			this.ListResults.removeAll();
			this.ListResults.redraw();
			for(int i=0; i < tl.size(); i++){
				this.ListResults.add(tl.get(i).getName());
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
