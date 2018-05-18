package yngvi.searchall;

import oracle.ide.Context;
import oracle.ide.Ide;
import oracle.ide.controller.Controller;
import oracle.ide.controller.IdeAction;
import oracle.ide.docking.DockStation;
import oracle.ide.docking.Dockable;
import oracle.ide.docking.DockableFactory;
import oracle.ide.log.LogManager;


public final class SearchAllController implements Controller {
    public static final int SEARCH_ALL_CMD_ID =
        Ide.findCmdID("yngvi.searchall.searchAllAction");
    
    @Override
    public boolean handleEvent(IdeAction ideAction, Context context) {
        DockableFactory factory = new SearchAllWindowFactory();
        Dockable dockable = factory.getDockable(SearchAllWindow.VIEW_ID );
        DockStation.getDockStation().setDockableVisible( dockable, true );
        LogManager lm = LogManager.getLogManager();
        lm.showLog();
        lm.getMsgPage().log("Takka Bani");
        
        return true;
    }

    @Override
    public boolean update(IdeAction ideAction, Context context) {
        ideAction.setEnabled(true);
        return true;
    }
}
