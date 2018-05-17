package yngvi.searchall;

import oracle.ide.Context;
import oracle.ide.Ide;
import oracle.ide.controller.Controller;
import oracle.ide.controller.IdeAction;
import oracle.ide.log.LogManager;


public final class SearchAllController implements Controller {
    public static final int SEARCH_ALL_CMD_ID =
        Ide.findCmdID("yngvi.searchall.searchAllAction");
    public SearchAllController() {
        super();
    }

    @Override
    public boolean handleEvent(IdeAction ideAction, Context context) {
        // TODO Implement this method
        LogManager lm = LogManager.getLogManager();
        lm.showLog();
        lm.getMsgPage().log("TakkaBani");
        
        return true;
    }

    @Override
    public boolean update(IdeAction ideAction, Context context) {
        // TODO Implement this method
        return false;
    }
}
