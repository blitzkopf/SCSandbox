package com.yngvi.scsandbox.observenodes;

import oracle.ide.log.LogManager;
import oracle.ide.model.Node;
import oracle.ide.model.Observer;
import oracle.ide.model.UpdateMessage;

public class NodeObserver implements Observer {
    public NodeObserver() {
        
    }
    
    public void update(java.lang.Object observed, UpdateMessage change)
    {
        LogManager lm = LogManager.getLogManager();
        lm.showLog();
        lm.getMsgPage().log("ping:"+change.toString()+"\n" );
 
        Node nd = (Node) observed;
        if(!nd.setReadOnly(true))
            lm.getMsgPage().log( "NodeObserver setReadOnly failed!\n" );
        
        
    }
    
}
