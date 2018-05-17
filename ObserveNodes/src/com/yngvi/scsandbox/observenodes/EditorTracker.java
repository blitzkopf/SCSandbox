package com.yngvi.scsandbox.observenodes;

import oracle.ide.editor.Editor;
import oracle.ide.editor.EditorListener;
import oracle.ide.ceditor.CodeEditor;
import oracle.ide.log.LogManager;
import oracle.ide.Context;


import oracle.javatools.editor.BasicEditorPane;
import oracle.ide.model.Node;

public class EditorTracker implements EditorListener {
    public EditorTracker() {
        super();
    }

    @Override
    public void editorOpened(Editor editor) {
        Context ct;
        Node nd;
        BasicEditorPane bep;
        LogManager lm = LogManager.getLogManager();
        lm.showLog();
        lm.getMsgPage().log("ping:"+editor.toString()+"\n" );
        lm.getMsgPage().log( "Class:"+editor.getClass().getName()+"\n" );
        lm.getMsgPage().log("CTX:\n");
        ct = editor.getContext();
        lm.getMsgPage().log("Context: "+ct.toString()+"\n");
        nd = ct.getNode();
        lm.getMsgPage().log("Node: "+nd.toString()+"\n");
        if(!nd.setReadOnly(true))
            lm.getMsgPage().log( "setReadOnly failed!\n" );
        bep = ((CodeEditor) editor).getFocusedEditorPane();
        bep.setEditable(true);
        lm.getMsgPage().log( "I'm out of here!\n" );
        //editor.se
    }

    @Override
    public void editorActivated(Editor editor) {
        // TODO Implement this method
    }

    @Override
    public void editorDeactivated(Editor editor) {
        // TODO Implement this method
    }

    @Override
    public void editorClosed(Editor editor) {
        // TODO Implement this method
    }
}
