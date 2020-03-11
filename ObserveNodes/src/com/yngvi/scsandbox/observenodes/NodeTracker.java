package com.yngvi.scsandbox.observenodes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import oracle.ide.db.model.DBObjectNode;
import oracle.ide.model.Node;
import oracle.ide.model.NodeEvent;
import oracle.ide.model.NodeListener;
import oracle.ide.model.TextNode;

import oracle.javatools.db.DBObject;

public class NodeTracker extends NodeListener {
    public NodeTracker() {
        super();
    }

    @SuppressWarnings("oracle.jdeveloper.java.nested-assignment")
    public static int copy(Reader input, Writer output) throws IOException {
        char[] buffer = new char[1024];
        int count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
          output.write(buffer, 0, n);
          count += n;
        }
        return count;
      }
    //public void nodeWillBeSaved(NodeEvent e)
    public void nodeSaved(NodeEvent e)
    {
        oracle.ide.log.LogManager lm = oracle.ide.log.LogManager.getLogManager();
        lm.showLog();
        
        Node nd = e.getNode();
        
        lm.getMsgPage().log("Node: "+nd.toString()+"\n");
        lm.getMsgPage().log( "Node.Class:"+nd.getClass().getName()+"\n" );

        DBObjectNode dbn  = (DBObjectNode) nd;
        //PlSqlNode dbn = (PlSqlNode) nd;
        
        DBObject dbo = dbn.getDBObject();
        TextNode tn = (TextNode) nd;
        
        //lm.getMsgPage().log(String.format("DB Object .name = %s, .type = %s ",dbo.getName(),dbo.getType()));
        
        //DBObject par = dbo.getParent();
        //lm.getMsgPage().log(String.format("Parent Object .name = %s, .type = %s ",par.getName(),par.getType()));
        
        //TextBuffer buff = tn.acquireTextBuffer();
        try {
            Reader rd = tn.getReader();
            FileWriter wr = new FileWriter(String.format("%s\\%s.%s.%s","C:\\Temp","URSUS",dbo.getName(),dbo.getType()));
            copy(rd,wr);
            rd.close(); // May need to move to finally
            wr.close(); 
            // rd.transferTo(wr); -- JAVA 9
            //buff.write(wr);
        } catch(IOException ex){
            lm.getMsgPage().log("unable to save file"+ex);
        } 
        
    }
}
