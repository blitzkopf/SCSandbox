package com.yngvi.scsandbox.observenodes;

import oracle.ide.model.Observer;
import oracle.ide.model.UpdateMessage;
import oracle.ide.log.LogManager;

public class NodeObserver implements Observer {
    public NodeObserver() {
        
    }
    
    public void update(java.lang.Object observed, UpdateMessage change)
    {
        LogManager lm = LogManager.getLogManager();
        lm.showLog();
        lm.getMsgPage().log("ping:"+change.toString()+"\n" );
 
    }
    
}
