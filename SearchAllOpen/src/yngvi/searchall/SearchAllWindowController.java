package yngvi.searchall;

import oracle.ide.Context;
import oracle.ide.controller.*;
import oracle.ide.docking.*;

/**
 * TODO Provide javadoc comment for SearchAllWindowController.
 */
public final class SearchAllWindowController implements Controller {

    public boolean update(IdeAction action, Context context) {
        return true;
    }

    public boolean handleEvent(IdeAction action, Context context) {
        Dockable dockable = DockStation.getDockStation().findDockable(yngvi.searchall
                                                                           .SearchAllWindow
                                                                           .VIEW_ID);
        DockStation.getDockStation().setDockableVisible(dockable, true);
        return true;
    }
}
