import java.awt.*;
import javax.swing.*;
class Pumpkin extends JFrame
{
  public static void main (String[] args)
  {
    Pumpkin one = new Pumpkin();
    one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    one.setSize(1000,1000);
    one.setVisible(true);
    one.setVisible(true);
  }
 public void paint (Graphics g)
 {


   g.setColor(Color.orange);
   g.drawRect(0,0, 500, 500);
   g.fillRect(0,0, 500, 500);

   g.setColor(Color.black);
   g.drawLine(50,0,50,500);
   g.drawLine(100,0,100,500);
   g.drawLine(150,0,150,500);
   g.drawLine(200,0,200,500);
   g.drawLine(250,0,250,500);
   g.drawLine(300,0,300,500);
   g.drawLine(350,0,350,500);
   g.drawLine(400,0,400,500);
   g.drawLine(450,0,450,500);

   g.setColor(Color.black);
   g.fillOval(100,100,100,65);

   g.setColor(Color.black);
   g.fillOval(300, 100, 100, 65);

   g.fillArc(250, 150, 45, 80, -60, -60);
   g.fillArc(0, 300, 500, 50, 0, -180);



 }
}
