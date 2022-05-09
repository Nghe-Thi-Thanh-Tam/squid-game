import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;




public class panelBot extends JPanel implements ActionListener {
    Timer t = new Timer(100, this);
    int width;
    int height;
    final int numberOfBot = 8;
    ArrayList<Bot> bot = new ArrayList<>();
    Map map = new Map();



    public panelBot(int width, int height, Map map) {
        this.width = width;
        this.height = height;
        this.map = map;
        this.add(map);

        int distance = width / (numberOfBot+3);
        int positionX = distance;
        int indexMove = 1;

        for (int i = 1; i <= numberOfBot; i++) {
            Bot tempBot = new Bot(positionX, height - height/9 + 35 - 80, width, height, indexMove);
            bot.add(tempBot);
            if (i==(numberOfBot/2))
                positionX += 2*distance;
            else
                positionX += distance;
        }

        for (int i=0; i<bot.size(); i++) {
            bot.get(i).setMap(map);
            bot.get(i).loadImage();
        }

        t.start();
    }


    public void actionPerformed(ActionEvent arg0) {

        width = getWidth();
        height = getHeight();

        for (int i = 0; i < bot.size(); i++) {
            bot.get(i).checkWin();
            bot.get(i).randomMove();
        }

        repaint();




    }

    public void paint(Graphics g) {
        super.paintComponent(g);

        System.out.println(map.startY + "  " + map.finishY);

        g.fillRect(0, getHeight()/9-1, width, 3);
        g.fillRect(0, getHeight()-getHeight()/9 -1, width, 3);

        for (int i = 0; i < bot.size(); i++) {
            bot.get(i).draw(g, this);
        }
    }
}





