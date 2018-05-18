package yngvi.searchall;

import java.awt.Component;

import oracle.ide.docking.*;
import oracle.ide.layout.ViewId;

/**
 * TODO Provide javadoc comment for SearchAllWindow.
 */
public final class SearchAllWindow extends DockableWindow {

    public static final String DOCKABLE_NAME = "SEARCHALLWINDOW_VIEW";
    public static final ViewId VIEW_ID = new ViewId(yngvi.searchall
                                                         .SearchAllWindowFactory
                                                         .TYPE_ID, DOCKABLE_NAME);
    private SearchPanel panel;

    @Override
    public String getTitleName() {
        return "Search All Open Documents";
    }
    @Override
    public Component getGUI() {
        return searchPanel();
    }
    
    private SearchPanel searchPanel() {
        if ( panel == null ) panel = new SearchPanel();
        return panel;
    }
}
