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
        CodeEditor ce;
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
        try {
            ce = (CodeEditor)editor;
            bep = ce.getFocusedEditorPane();
        } catch (Exception e) {
            lm.getMsgPage().log("Exception: "+e.toString()+"\n");
        }
        /*bep.setEditable(true);*/
        lm.getMsgPage().log( "I'm out of here!\n" );
        //editor.se
        }

    @Override
    public void editorActivated(Editor editor) {
        /*LogManager lm = LogManager.getLogManager();
        lm.showLog();
        lm.getMsgPage().log("Activated:"+editor.toString()+"\n" );  */
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
