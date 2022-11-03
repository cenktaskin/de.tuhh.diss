package de.tuhh.diss.tools;
import de.tuhh.diss.io.SimpleIO;

public class Workshop {
  private Tool[] tools;

  public Workshop(int size) {
    tools = new Tool[size];
  }
  
  public boolean addTool(Tool t) {
    for (int i = 0; i < tools.length; i++) {
      if (tools[i] == null) {
        tools[i] = t;
        return true;
      }
    }
    return false;
  }
  
  public void useTool(int i) {
    if (i >= 0 && i < tools.length && tools[i] != null) {
      tools[i].apply();
    }
  }
  
  public void listTools() {
    SimpleIO.println("Workshop tools:\n");
    for (int i = 0; i < tools.length; i++) {
      SimpleIO.println("#" + i);
      if (tools[i] != null) {
        tools[i].explain();
        SimpleIO.println("");
      }
    }
  }
  
  public static void main(String args[]) {
    Workshop w = new Workshop(3);
    w.addTool(new Hammer());
    w.addTool(new Hammer("Parktool", 1000, "steel"));
    w.addTool(new Saw("Birzman", 500, "carbon"));
    w.addTool(new Saw("Topeak", 800, "aluminium"));
    
    w.listTools();
    w.useTool(2);

  }
}
