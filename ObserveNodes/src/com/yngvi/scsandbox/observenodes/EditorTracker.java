package com.yngvi.scsandbox.observenodes;

import oracle.ide.Context;
import oracle.ide.editor.Editor;
import oracle.ide.editor.EditorListener;
import oracle.ide.log.LogManager;
import oracle.ide.model.Node;

import oracle.javatools.editor.BasicEditorPane;
//import oracle.ide.ceditor.CodeEditor;

public class EditorTracker implements EditorListener {
    public EditorTracker() {
        super();
    }

    @Override
    public void editorOpened(Editor editor) {
        Context ct;
        Node nd;
        BasicEditorPane bep;
         
//        CodeEditor ce;
        LogManager lm = LogManager.getLogManager();
        lm.showLog();
        lm.getMsgPage().log("ping:"+editor.toString()+"\n" );
        lm.getMsgPage().log( "Class:"+editor.getClass().getName()+"\n" );
        lm.getMsgPage().log("CTX:\n");
        ct = editor.getContext();
        lm.getMsgPage().log("Context: "+ct.toString()+"\n");
        nd = ct.getNode();
        lm.getMsgPage().log("Node: "+nd.toString()+"\n");
        lm.getMsgPage().log( "Node.Class:"+nd.getClass().getName()+"\n" );

        Object o = nd.getData();
        Class c = o.getClass();
        String indent = " ";
        while (c != null) {          
            lm.getMsgPage().log( indent + "Class:"+c.getName()+"\n" );
            c = c.getSuperclass();
            indent = indent +" ";
        }
        nd.addNodeListener(new NodeTracker());
        
        // get implemented interfaces
        Class[] classes = nd.getClass().getInterfaces();

        // pring interfaces
        for (Class c2: classes) {
           System.out.println("  " + c2.getName());
        }
        
        /*DocumentFactory df =  DocumentFactory.getDocumentFactory();
        Collection coll = df.getCachedDocuments();
        for(Object d: coll){
            lm.getMsgPage().log("docuemtnClass:"+d.getClass().getName()+"\n" );
        }
        */
        if(!nd.setReadOnly(true))
            lm.getMsgPage().log( "setReadOnly failed!\n" );
/*        try {
            ce = (CodeEditor)editor;
            bep = ce.getFocusedEditorPane();
        } catch (Exception e) {
            lm.getMsgPage().log("Exception: "+e.toString()+"\n");
        }*/
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
