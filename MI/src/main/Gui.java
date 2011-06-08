package main;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import com.cloudgarden.resource.SWTResourceManager;
import com.hp.hpl.jena.query.ResultSet;

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

	private Button ActorsButton;
	private Button SearchButton;
	private Button DescriptionButton;
	private List Actors;
	private StyledText DescriptionField;
	private Button trailerButton;
	private List ListResults;
	private Text TextSearch;
	private Label SearchLabel;
	private Label ProgName;

	public void openTrailer(String url) throws URISyntaxException, IOException{
		
			URI uri = new java.net.URI( url);
			Desktop desk = Desktop.getDesktop();
			desk.browse(uri);			
			
			
	}
			
	
	
	public  LinkedMDBEntryPoint linkedMDBEntryPoint;

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
		
		linkedMDBEntryPoint = new LinkedMDBEntryPoint();
		
		
		try {
			this.setSize(867, 417);
			this.setBackground(SWTResourceManager.getColor(192, 192, 192));
			FormLayout thisLayout = new FormLayout();
			this.setLayout(thisLayout);
			this.setBackgroundMode(1);
			{
				DescriptionButton = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData DescriptionButtonLData = new FormData();
				DescriptionButtonLData.left =  new FormAttachment(0, 1000, 406);
				DescriptionButtonLData.top =  new FormAttachment(0, 1000, 278);
				DescriptionButtonLData.width = 95;
				DescriptionButtonLData.height = 25;
				DescriptionButton.setLayoutData(DescriptionButtonLData);
				DescriptionButton.setText("Get Description");
				DescriptionButton.setBackground(SWTResourceManager.getColor(192, 192, 192));
				DescriptionButton.addMouseListener(this);
			
			}
			{
				FormData DescriptionFieldLData = new FormData();
				DescriptionFieldLData.left =  new FormAttachment(0, 1000, 507);
				DescriptionFieldLData.top =  new FormAttachment(0, 1000, 278);
				DescriptionFieldLData.width = 330;
				DescriptionFieldLData.height = 122;
				DescriptionField = new StyledText(this, SWT.V_SCROLL);
				DescriptionField.setLayoutData(DescriptionFieldLData);
				DescriptionField.setEditable(false);
				DescriptionField.setOrientation(SWT.VERTICAL);
				DescriptionField.setBackground(SWTResourceManager.getColor(238, 238, 238));
				DescriptionField.setJustify(false);
				DescriptionField.setWordWrap(true);
				DescriptionField.setLineSpacing(2);
				

			}
			{
				FormData ActorsLData = new FormData();
				ActorsLData.left =  new FormAttachment(0, 1000, 507);
				ActorsLData.top =  new FormAttachment(0, 1000, 64);
				ActorsLData.width = 328;
				ActorsLData.height = 202;
				Actors = new List(this, SWT.V_SCROLL);
				Actors.setLayoutData(ActorsLData);
				Actors.setDragDetect(false);
			}
			{
				ActorsButton = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData ActorsButtonLData = new FormData();
				ActorsButtonLData.left =  new FormAttachment(0, 1000, 406);
				ActorsButtonLData.top =  new FormAttachment(0, 1000, 64);
				ActorsButtonLData.width = 95;
				ActorsButtonLData.height = 25;
				ActorsButton.setLayoutData(ActorsButtonLData);
				ActorsButton.setText("Show Actors");
				ActorsButton.setBackground(SWTResourceManager.getColor(192, 192, 192));
				ActorsButton.addMouseListener(this);
			}


			{
				trailerButton = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData trailerButtonLData = new FormData();
				trailerButtonLData.left =  new FormAttachment(0, 1000, 406);
				trailerButtonLData.top =  new FormAttachment(0, 1000, 176);
				trailerButtonLData.width = 95;
				trailerButtonLData.height = 25;
				trailerButton.setLayoutData(trailerButtonLData);
				trailerButton.setText("Watch Trailer");
				trailerButton.setBackground(SWTResourceManager.getColor(192, 192, 192));
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
				SearchButton.setBackground(SWTResourceManager.getColor(192, 192, 192));
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
				ProgName.setText("Movie Database ");
			}
			

			this.layout();
			
			String temp = this.TextSearch.getText();
			linkedMDBEntryPoint.saveSearchResults(temp);
			ArrayList<Film> tl = linkedMDBEntryPoint.getSearchResultNames();	
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
			linkedMDBEntryPoint.saveSearchResults(temp);
			linkedMDBEntryPoint.printRDF("Queen");
			ArrayList<Film> tl = linkedMDBEntryPoint.getSearchResultNames();	
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
				this.openTrailer(tube.searchTrailer(sh.formatSearchString(linkedMDBEntryPoint.getFilmName(this.ListResults.getSelectionIndex())) + " trailer"));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(arg0.getSource().equals(this.ActorsButton)){
			LinkedMDBFilmData lf = new LinkedMDBFilmData();
			ResultSet temp = lf.getMovieActors(this.linkedMDBEntryPoint.getSearchResultNames().get(ListResults.getSelectionIndex()).getURI());
			ArrayList<String> alist = new ArrayList<String>();
			alist = lf.getMovieActorsList(temp);
			this.Actors.removeAll();
			for(int i = 0; i < alist.size(); i++){
				this.Actors.add(alist.get(i));
			}
			
		}else if(arg0.getSource().equals(this.DescriptionButton)){
			LinkedMDBFilmData lf = new LinkedMDBFilmData();
			String t = lf.getFilmDescription(this.ListResults.getItem(this.ListResults.getSelectionIndex()));
			this.DescriptionField.setText(t);
			
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
			linkedMDBEntryPoint.saveSearchResults(temp);
			ArrayList<Film> tl = linkedMDBEntryPoint.getSearchResultNames();		
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
