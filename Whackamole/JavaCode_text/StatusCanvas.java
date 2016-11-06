/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;

/**
 *
 * @author sorce
 */
public class StatusCanvas extends Canvas {
Font f1 = new Font("Helvetica",Font.BOLD,26);
  Font f2 = new Font("Times",Font.ITALIC+Font.BOLD,14);
  String value_ = "";
  String title_ = null;

  public StatusCanvas (String title, Color c) {
    super();
    title_=title;
    setBackground(c);
  }

  // The repaint method calls the method paint that updates the GUI.
  // We will explain the paint method later.
  public void setvalue(String newval) {
    value_ = newval;
    repaint(0);

  }
  public void concatvalue(String newval ) {
      value_ = value_.concat(newval);
       repaint(0);
  }
  
    public void free(String m) {
       value_ = value_.replace(m, "");
     repaint(0);

  }
  
    public void setcolor(Color c) {
    setBackground(c);
    repaint(0);
  }
     public void paint(Graphics g){

    g.setColor(Color.black);

    // Display the title
    g.setFont(f2);
    FontMetrics fm = g.getFontMetrics();
    int w = fm.stringWidth(title_);
    int h = fm.getHeight();
    int x = (getWidth() - w)/2;
    int y = h;
    g.drawString(title_, x, y);
    g.drawLine(x,y+3,x+w,y+3);

    // Display the value
    g.setFont(f1);
    fm = g.getFontMetrics();
    String s1 = String.valueOf(value_);
    w = fm.stringWidth(s1);
    h = fm.getHeight();
    x = (getWidth() - w)/2;
    y = (getHeight() + h)/2;
    g.drawString(s1, x, y);
  }
}
