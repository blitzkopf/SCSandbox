package yngvi.searchall;

import oracle.ide.docking.*;
import oracle.ide.layout.ViewId;
import oracle.ide.IdeConstants;

/**
 * TODO Provide javadoc comment for SearchAllWindowFactory.
 */
public final class SearchAllWindowFactory implements DockableFactory {
    public static final String TYPE_ID = "SEARCHALLWINDOW_TYPE";

    private yngvi.searchall.SearchAllWindow dockable = null;

    private synchronized yngvi.searchall.SearchAllWindow getDockable() {
        if (dockable == null) {
            dockable = new yngvi.searchall.SearchAllWindow();
        }
        return dockable;
    }

    public void install() {
        DockingParam dockingParam = new DockingParam();
        dockingParam.setPosition(IdeConstants.EAST);
        DockStation.getDockStation().dock(getDockable(), dockingParam);
    }

    public Dockable getDockable(ViewId viewId) {
        if (viewId.getName().equals(yngvi.searchall
                                         .SearchAllWindow
                                         .DOCKABLE_NAME)) {
            return getDockable();
        }

        return null;
    }
}
