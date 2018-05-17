/* $Header: jdev/src/esdk-samples/sample/OpenNodes/src/oracle/ide/extsamples/opennodes/ViewCommand.java /main/3 2012/03/28 11:37:33 svassile Exp $ */

/* Copyright (c) 2007, 2012, Oracle and/or its affiliates. 
All rights reserved. */

/*
   MODIFIED    (MM/DD/YY)
    bduff       11/21/07 - Bug 6624651 - fix compilation warning.
    bduff       08/29/07 - Initial revision
 */

package com.yngvi.scsandbox.observenodes;

import oracle.ide.Ide;
import oracle.ide.controller.Command;
import oracle.ide.docking.DockStation;
import oracle.ide.docking.Dockable;
import oracle.ide.docking.DockableFactory;
import oracle.ide.editor.EditorManager;
import oracle.ide.extension.RegisteredByExtension;
import oracle.ide.log.LogManager;
import oracle.ide.model.NodeFactory;
import oracle.ide.model.Node;

/**
 * Command handler for esdksample.openNodeTracker.
 */
@RegisteredByExtension("com.yngvi.scsandbox.observenodes")
public final class ViewCommand extends Command {
    public ViewCommand() {
        super(actionId());
    }

    public int doit() {
        DockableFactory factory = new OpenNodesDockableFactory();
        Dockable dockable = factory.getDockable(OpenNodesDockable.VIEW_ID );
        DockStation.getDockStation().setDockableVisible( dockable, true );
        LogManager lm = LogManager.getLogManager();
        lm.showLog();
        lm.getMsgPage().log("Hi!\n" );
        EditorManager.getEditorManager().addEditorListener(new EditorTracker());
        //NodeFactory.attach(new NodeObserver(),"oracle.dbtools.raptor.navigator.plsql.PlSqlNode" );
        

        
        lm.getMsgPage().log("Started Observing\n" );
        return OK;
    }

    /**
     * Returns the id of the action this command is associated with.
     *
     * @return the id of the action this command is associated with.
     * @throws IllegalStateException if the action this command is associated
     *    with is not registered.
     */
    public static int actionId() {
        final Integer cmdId = Ide.findCmdID("scsandbox.observeNodes");
        if (cmdId == null)
            throw new IllegalStateException("Action scsandbox.observeNodes not found.");
        return cmdId;
    }
}
